import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.rmi.RemoteException;

public class TargetModel implements Model {
	
	private Map<String, String> machine;
	private Map<String, StitchParser.TacticContext> tactics;
	private HashSet<String> hooks;
	private AnsibleProbe ansibleProbe;
	private Map<String, Probe> otherProbe;
	private Map<String, Integer> timeThresholds;

	// TODO: implement a cache/memory of remote variables, updated by probes on each call

	public TargetModel (Map<String,String> serverIP) {
		machine = serverIP;
		tactics = new HashMap<>();
		hooks = new HashSet<>();
		timeThresholds = new HashMap<String, Integer>();

		// populate the set of hooks
		hooks.add("hasWebCredential");
		hooks.add("hasCardCredential");
		hooks.add("hasLogFile");
		// hooks.add("suspicious"); // removed
		hooks.add("currentTime");
		hooks.add("WEB_THRESHOLD");

		System.out.println("Creating probe...");
		ansibleProbe = new AnsibleProbe(machine.get("ansible"), 15213); // magic number for port, hardcode ansible server
		// ansibleProbe = new AnsibleProbe("128.2.220.18", 15213);
		System.out.println("probe created");
		otherProbe = ansibleProbe.getProbe();
		System.out.println("ansibleProbe.getProbe() complete");

		int webThreshold = (int) System.currentTimeMillis() + 20000;
		
		timeThresholds.put("webThreshold", webThreshold);
		int paymentThreshold = (int) System.currentTimeMillis() + 40000;
		timeThresholds.put("paymentThreshold", paymentThreshold);
		System.out.println("webThreshold: " + webThreshold);
		System.out.println("paymentThreshold: " + paymentThreshold);
	}

	@Override
	public Map<String, String> getMachines() {
		return machine;
	}

	@Override
	public Map<String, StitchParser.TacticContext> getTactics() {
		return tactics;
	}

	@Override
	public HashSet<String> checkHooks() {
		return hooks;
	}

	@Override
	public void addTactic(String name, StitchParser.TacticContext tree) {
		tactics.put(name, tree);
		System.out.println("Model: adding new tactic, name: "+name);
	}

	@Override
	public String getName() {
		return new String("TargetModel");
	}

	/*
	 * Check whether the whole attack succeeds or not
	 */
	@Override
	public Integer checkAttackResult() {
		System.out.println("check attack result"); // has transactions file
			try {
				Integer retVal = ((FtpProbe)otherProbe.get("ftp")).checkFile("/upload/transactions.txt");  
				return retVal; 
			} catch (RemoteException e) {
				e.printStackTrace();
			}
	}

	/*
	 * Implement all the hooks right here
	 */
	@Override
	public Integer execHook(String id) {
		if (id.equals("hasCardCredential")) {
			System.out.println("execHook: hasCardCredential"); // has card credential
			try {
				Integer retVal = ((BlackhatProbe)otherProbe.get("blackhat")).checkFile("~/passwd") + 
							 ((BlackhatProbe)otherProbe.get("blackhat")).checkFile("~/shadow");
				if (retVal != 2) {
					return 0;  
				} 
				return 1;
			} catch (RemoteException e) {
				e.printStackTrace();
			} 
		} 
		else if (id.equals("hasLogFile")) {
			System.out.println("execHook: hasLogFile"); // has log file
			try {
				Integer retVal = ((FtpProbe)otherProbe.get("ftp")).checkFile("/upload/logs.txt");  
				return retVal; 
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} 
		else if (id.equals("hasWebCredential")) {
			System.out.println("execHook: hasWebCredential"); // has web credential
			try {
				Integer retVal = ((BlackhatProbe)otherProbe.get("blackhat")).checkFile("~/logs_decoded.txt"); 
				return retVal; 
			} catch (RemoteException e) {
				e.printStackTrace();
			}
		} 
		else if (id.equals("currentTime")) {
			System.out.println("execHook: currentTime"); // show current time
			return (int)System.currentTimeMillis();
		} 
		else if (id.equals("WEB_THRESHOLD")) {
			System.out.println("execHook: webThreshold"); // show web server's threshold
			return timeThresholds.get("webThreshold");
		}
		System.err.println("execHook: name of hook cannot be found");
		return -1;
	}

	/*
	 * Implement all operations right here
	 */
	@Override
	public Integer execOperations(String id) {
		if (id.equals("increaseWebThreshold")) {
			int webThreshold = timeThresholds.get("webThreshold");
			webThreshold += 2000;
			timeThresholds.put("webThreshold", webThreshold);
		} 
		if (id.equals("filterPhishingEmail")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("contractor"), "python filterEmail.py");
				if (!conn) {
					System.err.println("session connection 1 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Phishing email is filtered");
		} 
		if (id.equals("W.resetPassword")) {
			String newPassword = String.valueOf(System.currentTimeMillis() + 1);
			try {
			    String command = "ansible-playbook inject/resetWebPassword.yml --extra-vars '{\"new_password\":" + newPassword + "}'";
				boolean conn = ConnectionSSH.connect(machine.get("ansible"), command);
				if (!conn) {
					System.err.println("session connection 2 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Password is reset");
		} 
		if (id.equals("sendPhishingEmail")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/sendPhishingEmail.yml");
				if (!conn) {
					System.err.println("session connection 3 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Phishing email is sent");
		} 
		if (id.equals("A.downloadLogFile")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/downloadLogFile.yml");
				if (!conn) {
					System.err.println("session connection 4 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Log file is downloaded");
		} 
		if (id.equals("A.decodeLogFile")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/decodeLogFile.yml");
				if (!conn) {
					System.err.println("session connection 5 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Log file is decoded");
		} 
		if (id.equals("A.loginWeb")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/loginWeb.yml");
				if (!conn) {
					System.err.println("session connection 6 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Login web server");
		} 
		if (id.equals("A.injectShell")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/injectShell.yml");
				if (!conn) {
					System.err.println("session connection 7 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Shell injection");
		} 
		if (id.equals("A.crackPasswd")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/crackPasswd.yml");
				if (!conn) {
					System.err.println("session connection 8 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Password is cracked");
		} 
		if (id.equals("A.storePasswd")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/storePasswd.yml");
				if (!conn) {
					System.err.println("session connection 9 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Password is stored");
		} 
		if (id.equals("A.firmware")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/firmware.yml");
				if (!conn) {
					System.err.println("session connection 10 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Firmware");
		} 
		if (id.equals("A.transaction")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/tracsaction.yml");
				if (!conn) {
					System.err.println("session connection 11 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Transaction");
		}
		if (id.equals("A.deleteLogFile")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/deleteBlackhatLogFile.yml");
				if (!conn) {
					System.err.println("session connection 12 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Log file is deleted");
		}
		if (id.equals("A.deleteWebCredential")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("blackhat"), "ansible-playbook inject/deleteWebCredential.yml");
				if (!conn) {
					System.err.println("session connection 13 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Web credential is deleted");
		}
		if (id.equals("F.deleteLogFile")) {
			try {
				boolean conn = ConnectionSSH.connect(machine.get("ftp"), "ansible-playbook inject/deleteFTPLogFile.yml");
				if (!conn) {
					System.err.println("session connection 14 timeout, wrong IP address?");
					return 0;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Log file is deleted in FTP server");
		}
		return 1;
	}
}

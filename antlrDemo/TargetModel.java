import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TargetModel implements Model {
	
<<<<<<< HEAD
	private Map<String, String> machine; // TODO: should change to private
	private Map<String, StitchParser.TacticContext> tactics;
	private HashSet<String> hooks;
	private Probe ansibleProbe;
	private Map<String, probe> otherProbe;
=======
	Map<String, String> machine; // TODO: should change to private
	Map<String, StitchParser.TacticContext> tactics;
	HashSet<String> hooks;
	Probe probe;
	Map<String, Integer> timeThresholds;
	// long webThreshold;
	// long paymentThreshold;
>>>>>>> b5d345753eaa156c895926a839197cec8ced253f
	// TODO: implement a cache/memory of remote variables, updated by probes on each call

	public TargetModel (Map<String,String> serverIP) {
		machine = serverIP;
		tactics = new HashMap<>();
		hooks = new HashSet<>();
		hooks.add("hasCredential");
		System.out.println("Creating probe...");
		ansibleProbe = new AnsibleProbe(machine.get("ansible"), 15213); // magic number for port, hardcode ansible server
		// probe = new Probe("128.237.200.112", 15213); // testing only
		// probe = new Probe("18.204.18.19", 1099); // testing only
		System.out.println("probe created");
<<<<<<< HEAD
		otherProbe = ansibleProbe.getProbe();
=======
		int webThreshold = System.currentTimeMillis() + 20000;
		timeThresholds.put("webThreshold", webThreshold);
		int paymentThreshold = System.currentTimeMillis() + 40000;
		timeThresholds.put("paymentThreshold", paymentThreshold);
		System.out.println("webThreshold: " + webThreshold);
		System.out.println("paymentThreshold: " + paymentThreshold);
>>>>>>> b5d345753eaa156c895926a839197cec8ced253f
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
		return "TargetModel";
	}

	/*
	 * Implement all the hooks right here
	 */
	@Override
	public Integer execHook(String id) {
		if (id.equals("hasCard")) {
			System.out.println("execHook: hasCard"); // has card credential
			Integer retVal = probe.hasCardCredential(); // TODO: API from Probe class
			// model
		} else if (id.equals("hasLog")) {
			System.out.println("execHook: hasLogFile"); // has log file
			Integer retVal = probe.hasLogFile(); // TODO: API from Probe class
			// add return
		} else if (id.equals("hasWeb")) {
			System.out.println("execHook: validWeb"); // has valid web server password
			Integer retVal = probe.hasWebCredential(); // TODO: API from Probe class
			// add return
		} else if (id.equals("suspicious")) {
			System.out.println("execHook: suspicious"); // has suspicious mail
			Integer retVal = probe.checkSuspicious(); // TODO: API from Probe class
			// add return
		} else if (id.equals("c.time")) {
			System.out.println("execHook: currentTime"); // show current time
			return System.currentTimeMillis();
		} else if (id.equals("WEB_THRESHOLD")) {
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
		if (id.equals("increaseThreshold")) {
			
		}
	}
}

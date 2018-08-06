import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class AnsibleServer extends UnicastRemoteObject implements RmiServer {
	
	// private static String ip;
	private static int port;
	private static Map<String, String> ip;
	private Map<String, Probe> probe;

	/*
	 * Ldap, Sales do not need probes
	 */
	public AnsibleServer() throws RemoteException {
		super();
		probe = new HashMap<String, Probe>();
		probe.put("elk", new ElkProbe(ip.get("elk"), 15214));
		// probe.put("elk", new ElkProbe("10.0.0.11", 15214));
		System.out.println("elk online");

		probe.put("wazuh", new WazuhProbe(ip.get("wazuh"), 15214));
		// probe.put("wazuh", new WazuhProbe("10.0.0.12", 15214));
		System.out.println("wazuh online");

		probe.put("contractor", new ContractorProbe(ip.get("contractor"), 15214));
		// probe.put("contractor", new ContractorProbe("10.0.0.14", 15214));
		System.out.println("contractor online");

		probe.put("mail", new MailProbe(ip.get("mail"), 15214));
		// probe.put("mail", new MailProbe("10.0.0.15", 15214));
		System.out.println("mail online");

//		probe.put("web", new WebProbe("54.162.0.198", 15214));
//		System.out.println("web online");
		probe.put("blackhat", new BlackhatProbe(ip.get("blackhat"), 15214));
		// probe.put("blackhat", new BlackhatProbe("10.0.0.18", 15214));
		System.out.println("blackhat online");

		probe.put("ftp", new FtpProbe(ip.get("ftp"), 15214));
		// probe.put("ftp", new FtpProbe("10.0.0.19", 15214));
		System.out.println("ftp online");

//		probe.put("payments", new PaymentsProbe("34.202.233.15", 15214));
//		System.out.println("payments online");
		System.out.println("All servers online");
	}

	public static void main(String[] args) {
		try {
			// ip = args[0];
			port = Integer.parseInt(args[0]); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		ip.put("elk", args[1]);
		ip.put("wazuh", args[2]);
		ip.put("contractor", args[3]);
		ip.put("mail", args[4]);
		ip.put("blackhat", args[5]);
		ip.put("ftp", args[6]);

		AnsibleServer srv = null;
		try {
			srv = new AnsibleServer();
		} catch (RemoteException e) {
			System.err.println("fail to create the RMI server");
			e.printStackTrace();
		}
		
		try {
			// System.setProperty("java.rmi.server.hostname", ip);
			LocateRegistry.createRegistry(port);
			Naming.rebind(String.format("//127.0.0.1:%d/ServerService", port), srv);
		} catch (RemoteException e) {
			System.err.println("fail to create the RMI registry");
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Integer checkFile(String path) throws RemoteException {
		File file = new File(path);
		if (file.exists()) {
			return 1;
		}
		return 0;
	} 

	@Override
	public Map<String, Probe> getProbe() throws RemoteException {
		return new HashMap<String, Probe>(probe);
	}

    @Override
    public Integer checkLogin() throws RemoteException {
        return null;
    }

}

	

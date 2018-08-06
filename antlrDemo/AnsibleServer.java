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
	private Map<String, Probe> probe;

	/*
	 * Ldap, Sales do not need probes
	 */
	public AnsibleServer() throws RemoteException {
		super();
		probe = new HashMap<String, Probe>();
		probe.put("elk", new ElkProbe("54.166.147.172", 15214));
		System.out.println("elk online");
		probe.put("wazuh", new WazuhProbe("52.86.183.203", 15214));
		System.out.println("wazuh online");
		probe.put("contractor", new ContractorProbe("54.162.92.101", 15214));
		System.out.println("contractor online");
		probe.put("mail", new MailProbe("52.91.147.224", 15214));
		System.out.println("mail online");
//		probe.put("web", new WebProbe("54.162.0.198", 15214));
//		System.out.println("web online");
		probe.put("blackhat", new BlackhatProbe("18.210.15.175", 15214));
		System.out.println("blackhat online");
		probe.put("ftp", new FtpProbe("34.229.56.58", 15214));
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

	

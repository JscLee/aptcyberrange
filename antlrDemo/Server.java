import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;
import java.util.Map;

public class Server extends UnicastRemoteObject implements RmiServer {
	
	private static String ip;
	private static int port;

	public Server() throws RemoteException {
		super();
	}

	public static void main(String[] args) {

		try {
			ip = args[0];
			port = Integer.parseInt(args[1]); 
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		Server srv = null;
		try {
			srv = new Server();
		} catch (RemoteException e) {
			System.err.println("fail to create the RMI server");
			e.printStackTrace();
		}
		
		try {
			System.setProperty("java.rmi.server.hostname", ip);
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
	public Integer checkLogin() throws RemoteException {
		return 0;
	} 

	@Override
	public Map<String, Probe> getProbe() throws RemoteException {
		System.err.println("Empty method: Server.getProbe()");
		return null;
	}
}

	
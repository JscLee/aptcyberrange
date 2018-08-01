import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;
import java.io.*;

public class Server extends UnicastRemoteObject implements RmiServer {
	
	private static int port;

	public Server() throws RemoteException {
		super();
	}

	public static void main(String[] args) {

		try {
			port = Integer.parseInt(args[0]); 
		} catch(NumberFormatException e) {
			e.printStackTrace();
		}

		Server srv = null;
		try {
			srv = new Server();
		} catch (RemoteException e) {
			System.err.println("fail to create the server ");
			e.printStackTrace();
		}
		
		try {
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
	public boolean checkFile(String path) {
		File file = new File(path);
		return file.exists();
	}

}

	
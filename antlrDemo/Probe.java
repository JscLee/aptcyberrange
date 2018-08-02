import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.io.*;

public class Probe {

	private RmiServer srv;

	public Probe(String srvIP, int srvPort) {
		this.srv = connectServer(srvIP, srvPort);
	}
	
	public RmiServer connectServer(String srvIP, int srvPort) {
		RmiServer srv = null;
		try {
			srv = (RmiServer)Naming.lookup(String.format("//%s:%d/ServerService", srvIP, srvPort));
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch(NotBoundException e) {
			e.printStackTrace();
		}
		return srv;
	}

	public boolean checkFile(String path) throws RemoteException {
		return srv.checkFile(path);
	}

	public Integer hasCredential() {
		// empty function for compilition sake
		return 1;
	}
}

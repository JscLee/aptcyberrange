import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.io.*;
import java.io.Serializable;

public class Probe implements Serializable {

	protected RmiServer srv;

	public Probe(String srvIP, int srvPort) {
		try {
			srv = (RmiServer)Naming.lookup(String.format("//%s:%d/ServerService", srvIP, srvPort));
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch(NotBoundException e) {
			e.printStackTrace();
		}
	}

}

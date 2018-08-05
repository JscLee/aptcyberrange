import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class AnsibleProbe {

	private RmiAnsible srv;

	public AnsibleProbe(String srvIP, int srvPort) {
		try {
			srv = (RmiAnsible)Naming.lookup(String.format("//%s:%d/ServerService", srvIP, srvPort));
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch(NotBoundException e) {
			e.printStackTrace();
		}
	}

	public Map<String, Probe> getProbe() throws RemoteException {
		return srv.getProbe();
	}

}
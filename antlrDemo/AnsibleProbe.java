import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class AnsibleProbe {

	protected RmiServer srv;

	public AnsibleProbe(String srvIP, int srvPort) {
		//super(srvIP, srvPort);
		try {
			srv = (RmiServer)Naming.lookup(String.format("//%s:%d/ServerService", srvIP, srvPort));
			// srv = (AnsibleServer)Naming.lookup(String.format("//%s:%d/ServerService", srvIP, srvPort));
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(RemoteException e) {
			e.printStackTrace();
		} catch(NotBoundException e) {
			e.printStackTrace();
		}
	}

	public HashMap<String, Probe> getProbe() {
		//return ((AnsibleServer)srv).getProbe();
		HashMap<String, Probe> fetchedProbe = null;
		try {
			fetchedProbe = srv.getProbe();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (fetchedProbe == null) {
			System.err.println("!!AnsibleProbe: getProbe() returning null");
		}
		return fetchedProbe;
	}
	
	/*
	// defender uses this to decide whether filterEmail should be used
	public Integer checkSuspicious() {
    	if (Math.random() < 0.3) {
    		return 1;
    	}
    	return 0;
	}
	*/

}
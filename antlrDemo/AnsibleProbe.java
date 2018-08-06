import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.io.*;
import java.util.Map;
import java.util.HashMap;

public class AnsibleProbe extends Probe {

	public AnsibleProbe(String srvIP, int srvPort) {
		super(srvIP, srvPort);
	}

	public Map<String, Probe> getProbe() {
		Map<String, Probe> otherProbe = null;
		try {
			otherProbe = srv.getProbe();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if (otherProbe == null) {
			System.err.println("Return null: AnsibleProbe.getProbe()");
		}
		return otherProbe;
	}
}

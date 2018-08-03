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
	
	// TODO: maybe use Integer return type is easier
	// defender uses this to decide whether filterEmail should be used
	public boolean checkSuspicious() {
    	if (Math.random() < 0.3) return true;
    	else return false;
	}

	// webThreshold should be included in model, can be set as system's current time + 20000 when initialized
	public boolean checkWebTimeExpired() {
//        if (System.currentTimeMillis() > webThreshold) {
//            webThreshold += 20000;
//            return true;
//        } else {
//            return false;
//        }
		return true;
	}

	// paymentThreshold should be included in model, can be set as system's current time + 40000 when initialized
	public boolean checkPaymentTimeExpired() {
//        if (System.currentTimeMillis() > paymentThreshold) {
//            paymentThreshold += 40000;
//            return true;
//        } else {
//            return false;
//        }
		return true;
	}
}

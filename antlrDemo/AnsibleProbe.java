
public class AnsibleProbe extends Probe {

	public AnsibleProbe(String srvIP, int srvPort) {
		super(srvIP, srvPort);
	}
	
	public boolean checkFile(String path) throws RemoteException {
		return srv.checkFile(path);
	}

	public Map<String, Probe> getProbe() {
		return srv.getProbe();
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
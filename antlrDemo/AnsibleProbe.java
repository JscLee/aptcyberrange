
public class AnsibleProbe extends Probe {

	public AnsibleProbe(String srvIP, int srvPort) {
		super(srvIP, srvPort);
	}

	public Map<String, Probe> getProbe() {
		return srv.getProbe();
	}
	
	public Integer checkFile(String path) throws RemoteException {
		return srv.checkFile(path);
	}
	
	// defender uses this to decide whether filterEmail should be used
	public Integer checkSuspicious() {
    	if (Math.random() < 0.3) {
    		return 1;
    	}
    	return 0;
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
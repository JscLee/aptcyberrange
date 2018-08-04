
public class AnsibleProbe extends Probe {

	public AnsibleProbe(String srvIP, int srvPort) {
		super(srvIP, srvPort);
	}

	public Map<String, Probe> getProbe() {
		return srv.getProbe();
	}
	
	// defender uses this to decide whether filterEmail should be used
	public Integer checkSuspicious() {
    	if (Math.random() < 0.3) {
    		return 1;
    	}
    	return 0;
	}

}
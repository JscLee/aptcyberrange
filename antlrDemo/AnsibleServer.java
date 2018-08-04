import java.rmi.RemoteException;
import java.util.Map;
import java.util.HashMap;

public class AnsibleServer extends Server {
	
	private Map<String, Probe> probe;

	public AnsibleServer() throws RemoteException {
		super();
		probe = new HashMap<String, Probe>();
		probe.put("elk", new ElkProbe("10.0.0.11", 15214));
		probe.put("wazuh", new WazuhProbe("10.0.0.12", 15214));
		probe.put("contractor", new ContractorProbe("10.0.0.14", 15214));
		probe.put("mail", new MailProbe("10.0.0.15", 15214)); 
		probe.put("web", new WebProbe("10.0.0.16", 15214));
		probe.put("ldap", new LdapProbe("10.0.0.17", 15214));
		probe.put("blackhat", new BlackhatProbe("10.0.0.18", 15214));
		probe.put("ftp", new FtpProbe("10.0.0.19", 15214));
		probe.put("payments", new PaymentsProbe("10.0.0.20", 15214));
		probe.put("sales", new SalesProbe("10.0.0.21", 15214));
	}

	public Probe getProbe() {
		return probe;
	}

}

	
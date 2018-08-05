import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface RmiAnsible extends Remote {
	public Integer checkFile(String path) throws RemoteException;
	public Map<String, Probe> getProbe() throws RemoteException;
}

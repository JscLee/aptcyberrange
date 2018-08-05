import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Map;

public interface RmiServer extends Remote {
	public Integer checkFile(String path) throws RemoteException;
	public Integer checkLogin() throws RemoteException;
	public Map<String, Probe> getProbe() throws RemoteException;
}

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.HashMap;

public interface RmiServer extends Remote {
	public Integer checkFile(String path) throws RemoteException;
	public Integer checkLogin() throws RemoteException;
	abstract public HashMap<String, Probe> getProbe() throws RemoteException;
}

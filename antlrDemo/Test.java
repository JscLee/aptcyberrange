import java.rmi.RemoteException;

public class Test {
	public static void main(String[] args) {
		System.out.println("connecting...");
		// Probe probe = new Probe("128.2.220.13", 15213);
		Probe probe = new Probe("18.204.18.19", 15213);
		// Probe probe = new Probe("128.237.213.17", 15213);
		System.out.println("connected");
		
		String path = "/home/ubuntu/Probe.java";
		try {
			System.out.println(probe.checkFile(path));
		} catch (RemoteException e) {
			System.out.println("what");
			e.printStackTrace();
		}
	}
}

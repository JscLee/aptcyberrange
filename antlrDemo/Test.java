import java.rmi.RemoteException;

public class Test {
	public static void main(String[] args) {
		Probe probe = new Probe("128.237.181.50", 15213);
		String path = "/Users/guoxiuyuan/Applications/Dropbox/CMU/project/aptcyberrange/antlrDemo/Probe.java";
		try {
			System.out.println(probe.checkFile(path));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
} 
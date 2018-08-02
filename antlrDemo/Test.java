import java.rmi.RemoteException;

public class Test {
	public static void main(String[] args) {
<<<<<<< HEAD
		Probe probe = new Probe("128.237.200.112", 15213);
=======
		Probe probe = new Probe("128.237.200.11", 15213);
>>>>>>> 9a28606320e06e541aec698540b535bc2355286e
		String path = "/Users/guoxiuyuan/Applications/Dropbox/CMU/project/aptcyberrange/antlrDemo/Probe.java";
		try {
			System.out.println(probe.checkFile(path));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
} 
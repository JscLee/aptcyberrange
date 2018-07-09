import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class ConnectionSSH {

    public static void connect(String username, String host, String command) throws JSchException, IOException {
        JSch jsch = new JSch();
        String pubKeyPath = "key";
        jsch.addIdentity(pubKeyPath);

        Session session = jsch.getSession(username, host, 22);
        session.setConfig("StrictHostKeyChecking", "no");
        session.connect();
        ChannelExec channel = (ChannelExec)session.openChannel("exec");
        channel.setCommand(command);

        channel.connect();

        channel.disconnect();
        session.disconnect();
    }
}

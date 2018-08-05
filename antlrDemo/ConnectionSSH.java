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

    public static boolean connect(String username, String host, String command) throws JSchException, IOException {
        // Timeout limit reference website: 
        // https://stackoverflow.com/questions/35009009/jsch-session-timeout-limit
        try {
            JSch jsch = new JSch();
            String pubKeyPath = "key";
            jsch.addIdentity(pubKeyPath);

            Session session = jsch.getSession(username, host, 22);
            session.setConfig("StrictHostKeyChecking", "no");
            // set the timeout (ms) here
            int timeout = 2000;
            session.connect(timeout);
            ChannelExec channel = (ChannelExec)session.openChannel("exec");
            channel.setCommand(command);

            channel.connect();

            channel.disconnect();
            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}

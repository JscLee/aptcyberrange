import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.json.*;

public class Stitch {

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("usage: java Stitch <inputTactic> <inputStrategy>");
            return;
        }
        InputStream inputTactic = new FileInputStream(args[0]);
        InputStream inputStrategy = new FileInputStream(args[1]);

        // change of API: https://stackoverflow.com/questions/18110180/processing-a-string-with-antlr4
        StitchLexer tacticLexer = new StitchLexer(CharStreams.fromStream(inputTactic));
        StitchLexer strategyLexer = new StitchLexer(CharStreams.fromStream(inputStrategy));
        CommonTokenStream tacticTokens = new CommonTokenStream(tacticLexer);
        CommonTokenStream strategyTokens = new CommonTokenStream(strategyLexer);
        StitchParser tacticParser = new StitchParser(tacticTokens);
        StitchParser strategyParser = new StitchParser(strategyTokens);

        ParseTree tacticTree = tacticParser.script();
        ParseTree strategyTree = strategyParser.script();

        // read global_state.json to get a HashMap of servers -> ip
        InputStream ipList = new FileInputStream("../global_state.json");
        BufferedReader buf = new BufferedReader(new InputStreamReader(ipList));

        // Code from: https://javarevisited.blogspot.com/2015/09/how-to-read-file-into-string-in-java-7.html
        String line = buf.readLine();
        StringBuilder sb = new StringBuilder();
        while(line != null) {
            sb.append(line);
            line = buf.readLine();
        }
        String fileAsString = sb.toString();
        // System.out.println("Contents : " + fileAsString);
        JSONObject obj = new JSONObject(fileAsString);
        JSONObject ips = obj.getJSONObject("ip");
        HashMap<String, String> serverIP = new HashMap<>();
        for (String key : ips.keySet()) {
            serverIP.put(key, ips.getString(key));
        }

        for (Map.Entry<String, String> entry : serverIP.entrySet()) {
            System.out.println("server: "+entry.getKey()+", ip:"+entry.getValue());
        }

        ModelManager manager = new ModelManager();

        // TargetModel model = new TargetModel(serverIP); // make it a hashtable of type of models
        // new visitor to resolve type of model

        TacticScanner tacScan = new TacticScanner(manager, serverIP);

        tacScan.visit(tacticTree);

        Model model = manager.spawnModel();

        StitchEvalVisitor eval = new StitchEvalVisitor(model);

        // Start traversing the tree (AST) repeatedly
        //while(true) {
            // TODO: add a probe, rpc or remote access
            eval.visit(strategyTree); // TODO: needs to pick ONE not ALL strategies
        //    try {
        //        Thread.sleep(1000);
        //    } catch (Exception e) {
        //        e.printStackTrace();
        //    }
        //}
    }
}

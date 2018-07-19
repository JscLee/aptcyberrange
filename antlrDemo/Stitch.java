import java.io.InputStream;
import java.io.FileInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

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

        Model model = new Model(); // make it a hashtable of type of models
        // new visitor to resolve type of model

        TacticScanner tacScan = new TacticScanner(model);

        tacScan.visit(tacticTree);

        StitchEvalVisitor eval = new StitchEvalVisitor(model, tacticTree);

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

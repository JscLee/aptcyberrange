import java.io.InputStream;
import java.io.FileInputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Stitch {

    public static void main(String[] args) throws Exception {
        // InputStream is = args.length > 0 ? new FileInputStream(args[0]) : System.in;
        InputStream is = new FileInputStream(args[0]);

        // ANTLRInputStream input = new ANTLRInputStream(is);
        // change of API: https://stackoverflow.com/questions/18110180/processing-a-string-with-antlr4
        StitchLexer lexer = new StitchLexer(CharStreams.fromStream(is));
        //lexer.setInputStream(CharStreams.fromStream(is));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        StitchParser parser = new StitchParser(tokens);
        // parser.setInputStream(tokens);
        ParseTree tree = parser.script();

        Model model = new Model();

        StitchEvalVisitor eval = new StitchEvalVisitor(model);
        // Start traversing the tree (AST)
        eval.visit(tree);

        // System.out.println(tree.toStringTree(parser));
    }
}

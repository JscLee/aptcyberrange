// TacticScanner.java

import java.util.*;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.HashMap;
import java.util.Map;

public class TacticScanner extends StitchBaseVisitor<Integer> {

	//Map<String, Integer> memory = new HashMap<String, Integer>();

	ModelManager manager;
	Model model;
	Map<String, String> tmpMap;

	TacticScanner(ModelManager m, Map<String, String> serverIP) {
		manager = m;
		tmpMap = serverIP;
	}

	/*
	 * Instantiate the model, populate ModelManager
	 */
	@Override
	public Integer visitImportSt(StitchParser.ImportStContext ctx) {
		String modelName = ctx.STRING_LIT().getText();
		System.out.println("visitImportSt: modelName: "+modelName);
		model = new TargetModel(tmpMap); // TODO: test only
		return 1;
	}


	/*
	 * For testing purpose only
	 */
	@Override
	public Integer visitTactic(StitchParser.TacticContext ctx) {
		String tacticName = ctx.IDENTIFIER().getText();
		System.out.println("TacticScanner: visitTactic: tacticName is "+tacticName);
		model.addTactic(tacticName, ctx);
		System.out.println("TacticScanner: Tactic Added");
		return 1;
	}

}

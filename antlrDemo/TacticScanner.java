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
		if (ctx.LIB() != null || ctx.OP() != null || ctx.MODEL() == null) {
			System.err.println("visitImportSt: Only support import model in tactics.");
			return 0;
		}
		String modelName = ctx.STRING_LIT().getText();
		String cleanModelName = modelName.substring(1, modelName.length()-1);
		System.out.println("visitImportSt: cleanModelName: "+cleanModelName);
		manager.initModel(cleanModelName, tmpMap);
		model = manager.spawnModel();
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

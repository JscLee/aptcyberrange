// TacticScanner.java

import java.util.*;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

import java.util.HashMap;
import java.util.Map;

public class TacticScanner extends StitchBaseVisitor<Integer> {

	//Map<String, Integer> memory = new HashMap<String, Integer>();

	Model model;

	TacticScanner(Model m) {
		model = m;
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

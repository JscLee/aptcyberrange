import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class Model {
	
	Map<String, Integer> machine; // TODO: should change to private
	Map<String, StitchParser.TacticContext> tactics;

	Model () {
		machine = new HashMap<>();
		tactics = new HashMap<>();
		machine.put("testVariable", 1);
	}

	public void addTactic(String name, StitchParser.TacticContext tree) {
		tactics.put(name, tree);
		System.out.println("Model: adding new tactic, name: "+name);
	}
}
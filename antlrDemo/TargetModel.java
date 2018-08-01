import java.util.HashMap;
import java.util.Map;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TargetModel implements Model {
	
	Map<String, String> machine; // TODO: should change to private
	Map<String, StitchParser.TacticContext> tactics;

	TargetModel (Map<String,String> serverIP) {
		machine = serverIP;
		tactics = new HashMap<>();
	}

	@Override
	public Map<String, String> getMachine() {
		return machine;
	}

	@Override
	public Map<String, StitchParser.TacticContext> getTactics() {
		return tactics;
	}

	@Override
	public void addTactic(String name, StitchParser.TacticContext tree) {
		tactics.put(name, tree);
		System.out.println("Model: adding new tactic, name: "+name);
	}
}
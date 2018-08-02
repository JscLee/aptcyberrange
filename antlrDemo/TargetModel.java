import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TargetModel implements Model {
	
	Map<String, String> machine; // TODO: should change to private
	Map<String, StitchParser.TacticContext> tactics;
	HashSet<String> hooks;
	Probe probe;

	TargetModel (Map<String,String> serverIP) {
		machine = serverIP;
		tactics = new HashMap<>();
		hooks = new HashSet<>();
		hooks.add("hasCredential");
		System.out.println("Creating probe...");
		// probe = new Probe(machine.get("ansible"), 15213); // magic number for port, hardcode ansible server
		probe = new Probe("128.237.200.11", 15213); // testing only
		System.out.println("probe created");
	}

	@Override
	public Map<String, String> getMachines() {
		return machine;
	}

	@Override
	public Map<String, StitchParser.TacticContext> getTactics() {
		return tactics;
	}

	@Override
	public HashSet<String> checkHooks() {
		return hooks;
	}

	@Override
	public void addTactic(String name, StitchParser.TacticContext tree) {
		tactics.put(name, tree);
		System.out.println("Model: adding new tactic, name: "+name);
	}

	@Override
	public String getName() {
		return "TargetModel";
	}

	/*
	 * Implement all the hooks right here
	 */
	@Override
	public Integer execHook(String id) {
		if (id.equals("hasCredential")) {
			System.out.println("execHook: hasCrendential");
			return probe.hasCredential(); // TODO: API from Probe class
		}
		System.err.println("execHook: name of hook cannot be found");
		return -1;
	}
}

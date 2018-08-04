import java.util.Map;
import java.util.HashSet;

public interface Model {
	abstract public Map<String, String> getMachines();
	abstract public Map<String, StitchParser.TacticContext> getTactics();
	abstract public HashSet<String> checkHooks();
	abstract public void addTactic(String name, StitchParser.TacticContext tree);
	abstract public String getName();
	abstract public Integer execHook(String id);
	abstract public Integer execOperations(String id);
}

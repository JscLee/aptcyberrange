import java.util.Map;

public interface Model {
	abstract public Map<String, String> getMachine();
	abstract public Map<String, StitchParser.TacticContext> getTactics();
	abstract public void addTactic(String name, StitchParser.TacticContext tree);
}
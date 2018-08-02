import java.util.Map;
import java.util.HashSet;

public class ModelManager {

	Model modelPool;
	HashSet<String> namePool;

	ModelManager() {
		namePool = new HashSet<>();
		namePool.add("TargetModel");
	}

	public void initModel(String modelName, Map<String, String> serverIP) {
		if (namePool.contains(modelName)) {
			System.out.println("ModelManager: input model is: "+modelName);
			if (modelName.equals("TargetModel")) {
				modelPool = new TargetModel(serverIP);
			}
		} else {
			System.err.println("ModelManager: input model "+modelName+" not supported!");
		}
	}

	public Model spawnModel() {
		if (modelPool != null) {
			return modelPool;
		}
		System.err.println("ModelManager: modelPool is empty, cannot spawn a model; use tacScanner to initialize modelPool");
		return null;
	}
}
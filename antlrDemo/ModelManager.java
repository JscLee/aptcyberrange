import java.util.Map;

public class ModelManager {

	Model modelPool;

	public void initModel(String modelName, Map<String, String> serverIP) {
		if (modelName.equals("TargetModel")) {
			modelPool = new TargetModel(serverIP);
		} else {
			System.err.println("ModelManager: model: " + modelName + " not supported!");
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
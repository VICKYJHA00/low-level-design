abstract class modelTrainer{
    public final void trainpipelines(String dataPath){
        loadData(dataPath);
        preprocessData();
        trainModel();
        evaluateModel();
        saveModel();
    }

    protected void loadData(String path){
        System.out.println("[Common] loading dataset form " + path);
    }

    protected void preprocessData(){
        System.out.println("[common] splitting into trin/test and normalizing");
    }

    protected abstract void trainModel();

    protected abstract void evaluateModel();

    protected void saveModel(){
        System.out.println("[Commin ] saving model to disk as default format ");
    }
}


class NeuralNetworkTrainer extends modelTrainer{
    
    protected void trainModel(){
       System.out.println("[NeuralNet] Evaluating accuracy and loss on validation set");
    }

    protected void evaluateModel(){
        System.out.println("[NeuralNet] Serializing network weights to .h5 file");
    }

}

class DecisionTreeModel extends modelTrainer{
    
    protected void trainModel(){
        System.out.println("[DecisionTree] Building decision tree with max_depth=5");
    }

    protected void evaluateModel(){
        System.out.println("[DecisionTree] Computing classification report (precision/recall)");
    }
}

public class templatePatternDesign{
    public static void main(String[] args) {
        System.out.println("=== neural network training ====");
        modelTrainer nTrainer = new NeuralNetworkTrainer();
        nTrainer.trainpipelines("data/images");

        System.out.println("\n === Decision Tree Training ===");
        modelTrainer dTrainer = new DecisionTreeModel();
        dTrainer.trainpipelines("data.iris.csv");
    }
}
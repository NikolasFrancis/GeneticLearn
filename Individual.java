package geneticlearn;

/**
 *
 * @author Nikolas
 */
public class Individual {

    String genes = "";
    double fitness, value;

    public Individual() {
    }

    public Individual(String s) {
        genes = s;
    }

    public void setValue(double v) {
        value = v;
    }

    public double getValue() {
        return value;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fit) {
        fitness = fit;
    }

    public void findFitness() {
        fitness = Fitness.findFitness(this);
    }

    public void setGenes(String gene, int index) {
        genes = genes.substring(0, index) + gene + genes.substring(index + 1);
    }

    public void setGenes(String genes) {
        this.genes = genes;
    }

    public String getGenes() {
        return genes;
    }

    public void createGenes(int numOfGenes) {
        for (int i = 0; i < numOfGenes; i++) {
            genes += Math.round(Math.random()) + "";
        }
    }

    public String toString() {
        String output = genes + "\t" + value;
        return output;
    }
}

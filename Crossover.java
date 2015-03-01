/*
 * 
 */
package geneticlearn;

/**
 *
 * @author Nikolas
 */
public class Crossover {

    boolean singlePointCrossover = true;
    boolean doublePointCrossover = false;
    boolean uniformPointCrossover = false;

    public Crossover() {
    }

    public Crossover(boolean sPC, boolean dPC, boolean uPC) {
        singlePointCrossover = sPC;
        doublePointCrossover = dPC;
        uniformPointCrossover = uPC;
    }

    public void setSinglePointCrossover() {
        singlePointCrossover = true;
        doublePointCrossover = false;
        uniformPointCrossover = false;
    }

    public Individual[] crossover(Individual[] pair) {
        Individual[] children = new Individual[2];
        if (singlePointCrossover) {
            children = singlePointCrossover(pair);
        } else if (doublePointCrossover) {
            children = doublePointCrossover(pair);
        } else {
            children = uniformPointCrossover(pair);
        }

        return children;
    }

    public Individual[] singlePointCrossover(Individual[] pair) {
        Individual[] children = new Individual[2];
        children[0] = new Individual();
        children[1] = new Individual();
        int index = (int) (Math.round(Math.random() * pair[0].getGenes().length()));
        String childA = pair[0].getGenes().substring(0, index) + pair[1].getGenes().substring(index, pair[1].getGenes().length());
        String childB = pair[1].getGenes().substring(0, index) + pair[0].getGenes().substring(index, pair[0].getGenes().length());
        children[0].setGenes(childA);
        children[1].setGenes(childB);

        return children;
    }

    public Individual[] doublePointCrossover(Individual[] pair) {
        Individual[] children = new Individual[2];

        return children;
    }

    public Individual[] uniformPointCrossover(Individual[] pair) {
        Individual[] children = new Individual[2];

        return children;
    }
}

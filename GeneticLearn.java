/*
 *Hi I'm Nikolas Francis. 
 * This is my example code to demonstrate how to use my code.
 * My goal with this software is to create an easy to use set of classes that 
 * will allow any programmer with a basic understanding of Java and Genetic 
 * Algorithms to quickly implement learning into their software.
 * 
 */
package geneticlearn;

/**
 *
 * @author Nikolas
 */
public class GeneticLearn {

    public static void main(String[] args) {
        Population myPop = new Population();
        myPop.getSelection().setSelectionTS();//Use tournament selection
        myPop.getCrossover().setSinglePointCrossover();//Use single point crossover
        System.out.println("Initial values and population.\n");
        myPop.createNewPopulation(50, 64);
        System.out.println(myPop.toString());
        for (int i = 0; i < 1000; i++) {
            System.out.println("Population's fitness found.\n");
            myPop.findFitness();
            System.out.println("Fittest score ");
            System.out.println(myPop.getMostFitIndividual().toString()+"\n");
            System.out.println(myPop.toString());
            System.out.println("Evolving population\n");
            myPop.evolve();
            System.out.println(myPop.toString());
            System.out.println("Mutating population");
            myPop.mutate();
            System.out.println(myPop.toString());
        }
    }
}

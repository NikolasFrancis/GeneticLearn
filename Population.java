/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticlearn;

import java.util.ArrayList;

/**
 *
 * @author Nikolas
 */
public class Population {

    Selection popSelect = new Selection();
    Crossover popCrossover = new Crossover();
    ArrayList<Individual> population = new ArrayList<Individual>();
    ArrayList<Individual> nextPopulation = new ArrayList<Individual>();
    String popName = "";
    double mutationRate = 0.01;

    public Population() {
    }

    public Population(String name) {
        popName = name;
    }

    public void setName(String newName) {
        popName = newName;
    }

    public Individual getIndividual(int index) {
        return population.get(index);
    }

    public Selection getSelection() {
        return popSelect;
    }

    public Crossover getCrossover() {
        return popCrossover;
    }

    public void setSelection(Selection select) {
        popSelect = select;
    }

    public void createNewPopulation(int numOfIndividuals, int numOfGenes) {
        for (int i = 0; i < numOfIndividuals; i++) {
            Individual Nik = new Individual();
            Nik.createGenes(numOfGenes);
            population.add(Nik);
        }
    }

    public void createNewPopulation(int numOfIndividuals, int numOfGenes, String populationName) {
        //set the name of the population
        setName(populationName);
        //Create the population one individual at a time and add them to our arraylist.
        for (int i = 0; i < numOfIndividuals; i++) {
            Individual Nik = new Individual();// :)
            Nik.createGenes(numOfGenes);
            population.add(Nik);
        }
    }

    public void findFitness() {
        for (int i = 0; i < population.size(); i++) {
            population.get(i).findFitness();
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < population.size(); i++) {
            output += population.get(i).toString() + "\n";
        }
        return output;
    }

    public double getTotalScore() {
        double value = 0;
        for (int i = 0; i < population.size(); i++) {
            value += population.get(i).getFitness();
        }
        return value;
    }

    public int getSize() {
        return population.size();
    }

    public void evolve() {
        nextPopulation.clear();
        for (int i = 0; i < population.size() / 2; i++) {
            Individual[] pair = popSelect.select(this);
            Individual[] children = popCrossover.crossover(pair);
            nextPopulation.add(children[0]);
            nextPopulation.add(children[1]);
        }
        //population.clear();
        ArrayList<Individual> population = new ArrayList<Individual>(nextPopulation);
    }

    public void mutate() {
        int mutations = 0;
        for (int i = 0; i < population.size(); i++) {
            for (int a = 0; a < population.get(i).getGenes().length(); a++) {
                if (Math.random() < mutationRate) {
                    mutations++;
                    if (population.get(i).getGenes().charAt(a) == '1') {
                        population.get(i).setGenes("0", a);
                    } else {
                        population.get(i).setGenes("1", a);
                    }
                }
            }
        }
        System.out.println(mutations + " have occured ");
    }

    public Individual getMostFitIndividual() {
        Individual strongest = new Individual();
        double maxFitness = -1;
        for (int i = 0; i < population.size(); i++) {
            if (population.get(i).getFitness() > maxFitness) {
                strongest = population.get(i);
                maxFitness = population.get(i).getFitness();
            }
        }

        return strongest;
    }
}

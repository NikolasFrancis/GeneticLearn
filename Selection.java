package geneticlearn;
/*
 * In this class I have implemented three different selection methods fitness
 * proportional Selection, tournament Selection, and rank Selection.
 * 
*/

public class Selection {

    boolean fitnessProportionalSelection = false;
    boolean tournamentSelection = true;
    boolean rankSelection = false;
    double tournamentSelectionProbability = 0.9;//probability the better individual will be chosen.

    public Selection() {
    }

    public Selection(boolean fps, boolean tS, boolean rS) {
        fitnessProportionalSelection = fps;
        tournamentSelection = tS;
        rankSelection = rS;
    }

    public void setSelectionFPS() {
        fitnessProportionalSelection = true;
        tournamentSelection = false;
        rankSelection = false;
    }

    public void setSelectionTS() {
        fitnessProportionalSelection = false;
        tournamentSelection = true;
        rankSelection = false;
    }

    public void setSelectionRS() {
        fitnessProportionalSelection = false;
        tournamentSelection = false;
        rankSelection = true;
    }

    public Individual[] select(Population pop) {
        Individual[] pair = new Individual[2];
        if (fitnessProportionalSelection) {
            pair = fitnessProportionalSelection(pop);
        } else if (tournamentSelection) {
            pair = tournamentSelection(pop);
        } else {
            pair = rankSelection(pop);
        }

        return pair;
    }

    public Individual[] fitnessProportionalSelection(Population pop) {
        Individual[] pair = new Individual[2];
        double totalScore = pop.getTotalScore();



        return pair;
    }

    public Individual[] tournamentSelection(Population pop) {
        Individual[] pair = new Individual[2];
        for (int i = 0; i < 2; i++) {
            int first = (int) Math.round(Math.random() * (pop.getSize() - 1));
            int second = (int) Math.round(Math.random() * (pop.getSize() - 1));
            Individual stronger, weaker;
            while (first == second) {
                second = (int) Math.round(Math.random() * (pop.getSize() - 1));
            }
            if (pop.getIndividual(first).getFitness() > pop.getIndividual(second).getFitness()) {
                stronger = pop.getIndividual(first);
                weaker = pop.getIndividual(second);
            } else {
                stronger = pop.getIndividual(second);
                weaker = pop.getIndividual(first);
            }

            if (Math.random() > tournamentSelectionProbability) {
                pair[i] = stronger;
            } else {
                pair[i] = weaker;
            }
        }
        return pair;
    }

    public Individual[] rankSelection(Population pop) {
        Individual[] pair = new Individual[2];




        return pair;
    }
}

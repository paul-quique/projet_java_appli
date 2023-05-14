package fr.quique.projetjava;

import java.util.Comparator;

public class EvaluationComparator implements Comparator<Evaluation> {
    @Override
    public int compare(Evaluation o1, Evaluation o2) {
        if (o1.getPouceBleus() > o2.getPouceBleus()) {
            return 1;
        }
        return -1;
    }
}

package fr.quique.projetjava;

import java.util.Comparator;

public class EvaluationSignaleesComparator implements Comparator<Evaluation> {
    @Override
    public int compare(Evaluation o1, Evaluation o2) {
        if (o1.getSignalements() < o2.getSignalements()) {
            return 1;
        }
        return -1;
    }
}

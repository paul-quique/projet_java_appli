package fr.quique.projetjava;

import java.util.Comparator;

public class JoueurComparator implements Comparator<Joueur> {
    @Override
    public int compare(Joueur j1, Joueur j2) {
        if (j1.getPoucesBleu() * j1.getEvals().size() > j2.getPoucesBleu() * j2.getEvals().size()) {
            return -1;
        }
        return 1;
    }
}

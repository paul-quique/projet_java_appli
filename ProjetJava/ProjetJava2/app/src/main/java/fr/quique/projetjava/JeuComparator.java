package fr.quique.projetjava;

import java.util.Comparator;

public class JeuComparator implements Comparator<Jeu> {
    @Override
    public int compare(Jeu j1, Jeu j2) {
        if (j1.getJetonsPlaces() > j2.getJetonsPlaces()) {
            return -1;
        }
        return 1;
    }
}

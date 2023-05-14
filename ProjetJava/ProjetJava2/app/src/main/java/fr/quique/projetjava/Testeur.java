package fr.quique.projetjava;

import java.io.Serializable;
import java.util.ArrayList;

public class Testeur extends Joueur implements Serializable {
    private ArrayList<Critique> critiques;
    public Testeur (String pseudo) {
        super(pseudo);
        this.pseudo = pseudo;
        critiques = new ArrayList<Critique>();
    }

    public ArrayList<Critique> getCritiques() {
        return critiques;
    }

    public void ajouterCritique(String date, String version, String texte, String noteInterface, String noteOptimisation, String noteGameplay) {
        critiques.add(
                new Critique(date, version, texte, Integer.parseInt(noteInterface), Integer.parseInt(noteGameplay), Integer.parseInt(noteOptimisation))
        );
    }

    protected Administrateur promouvoir() {
        return new Administrateur(pseudo);
    }
}

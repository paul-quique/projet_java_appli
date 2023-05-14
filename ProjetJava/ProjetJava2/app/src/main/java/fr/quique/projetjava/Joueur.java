package fr.quique.projetjava;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.EventListener;

public class Joueur extends Invite implements Serializable {
    public Joueur(String pseudo) {
        this.pseudo = pseudo;
        jeux = new ArrayList<Jeu>();
        tempsJeux = new ArrayList<Integer>();
        evals = new ArrayList<Evaluation>();
    }
    protected String pseudo;
    private int distribues = 0;
    private boolean bloque;

    public boolean isBloque() {
        return bloque;
    }

    public void setBloque(boolean bloque) {
        this.bloque = bloque;
    }

    public int getNbJetons() {
        nbJetons += getPoucesBleu()/10 - distribues;
        distribues = getPoucesBleu() / 10;
        return nbJetons;
    }

    protected void enleverJeton() {
        nbJetons--;
    }

    private int nbJetons = 3;

    private ArrayList<Jeu> jeux;
    protected void ajouterJetons(int n) {
        nbJetons += n;
    }
    public ArrayList<Evaluation> getEvals() {
        return evals;
    }

    protected final void ajouterEval(Evaluation e) {
        evals.add(e);
    }
    private ArrayList<Evaluation> evals;

    public ArrayList<Jeu> getJeux() {
        return jeux;
    }

    public ArrayList<Integer> getTempsJeux() {
        return tempsJeux;
    }

    private ArrayList<Integer> tempsJeux;
    public String getPseudo() {
        return pseudo;
    }

    protected static void supprimerCompte(String pseudo) {
        for (int i = 0; i < MainActivity.joueurs.size(); i++) {
            if (MainActivity.joueurs.get(i).getPseudo().equals(pseudo)) {
                MainActivity.joueurs.remove(i);
            }
        }
        for (int i = 0; i < MainActivity.testeurs.size(); i++) {
            if (MainActivity.testeurs.get(i).getPseudo().equals(pseudo)) {
                MainActivity.testeurs.remove(i);
            }
        }
        for (int i = 0; i < MainActivity.admins.size(); i++) {
            if (MainActivity.admins.get(i).getPseudo().equals(pseudo)) {
                MainActivity.admins.remove(i);
            }
        }
    }

    protected Testeur promouvoir() {
        return new Testeur(pseudo);
    }

    protected final void ajouterJeu(String tempsJeu, Jeu jeu) {
        try {
            int tmp = Integer.parseInt(tempsJeu);
            tempsJeux.add(tmp);
        } catch (NumberFormatException e) {
            tempsJeux.add(0);
        }
        jeux.add(jeu);
    }

    protected final int getDureeJeuGlobale() {
        int somme = 0;
        for (int j : tempsJeux) {
            somme += j;
        }
        return somme;
    }

    protected final int getPoucesBleu() {
        int total = 0;
        for (Evaluation e : evals) {
            total+=e.getPouceBleus();
        }
        return total;
    }
    protected final int getPoucesRouge() {
        int total = 0;
        for (Evaluation e : evals) {
            total+=e.getPouceRouges();
        }
        return total;
    }
}




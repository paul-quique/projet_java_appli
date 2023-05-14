package fr.quique.projetjava;

import android.util.Log;

import java.util.ArrayList;

public class Evaluation {
    static int compteur = 0;
    private String date;
    private String texte;
    private Jeu jeu;
    private String version;
    protected final int id = compteur++;
    private int signalements;
    private int pouceRouges;
    private int pouceBleus;

    public static int getCompteur() {
        return compteur;
    }

    public String getDate() {
        return date;
    }

    public String getTexte() {
        return texte;
    }

    public Jeu getJeu() {
        return jeu;
    }

    public String getVersion() {
        return version;
    }

    public int getId() {
        return id;
    }

    public int isEstProblematique() {
        return signalements;
    }

    public int getPouceRouges() {
        return pouceRouges;
    }

    public int getPouceBleus() {
        return pouceBleus;
    }

    protected void setPouceBleus(int n) {
        pouceBleus=n;
    }
    protected void setPouceRouges(int n) {
        pouceRouges=n;
    }

    protected void signaler() {
        signalements++;
    }
    public Evaluation(String date, String texte, String version, Jeu jeu) {
        this.date = date;
        this.texte = texte;
        this.version = version;
        this.jeu = jeu;
    }

    protected static ArrayList<Evaluation> obtenirEvaluations(Jeu jeu) {
        ArrayList<Evaluation> match = new ArrayList<Evaluation>();
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        for (Administrateur a : MainActivity.admins) {
            joueurs.add(a);
        }
        for (Testeur t : MainActivity.testeurs) {
            joueurs.add(t);
        }
        for (Joueur j : MainActivity.joueurs) {
            joueurs.add(j);
        }
        for (Joueur j : joueurs) {
            for (Evaluation e : j.getEvals()) {
                if (e.jeu.getNom().equals(jeu.getNom()) && e.jeu.getSupport().equals(jeu.getSupport())) {
                    match.add(e);
                }
            }
        }
        return match;
    }
    protected static void supprimerEvaluation(int id) {
        ArrayList<Evaluation> match = new ArrayList<Evaluation>();
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        for (Administrateur a : MainActivity.admins) {
            joueurs.add(a);
        }
        for (Testeur t : MainActivity.testeurs) {
            joueurs.add(t);
        }
        for (Joueur j : MainActivity.joueurs) {
            joueurs.add(j);
        }
        for (Joueur j : joueurs) {
            ArrayList<Evaluation> ev = j.getEvals();
            int taille = ev.size();
            for (int i = 0; i < taille; i++) {
                if (ev.get(i).getId() == id) {
                    ev.remove(i);
                    return;
                }
            }
        }
    }
    protected static ArrayList<Evaluation> obtenirEvaluations() {
        ArrayList<Evaluation> match = new ArrayList<Evaluation>();
        ArrayList<Joueur> joueurs = new ArrayList<Joueur>();
        for (Administrateur a : MainActivity.admins) {
            joueurs.add(a);
        }
        for (Testeur t : MainActivity.testeurs) {
            joueurs.add(t);
        }
        for (Joueur j : MainActivity.joueurs) {
            joueurs.add(j);
        }
        for (Joueur j : joueurs) {
            for (Evaluation e : j.getEvals()) {
                match.add(e);
            }
        }
        return match;
    }

    public int getSignalements() {
        return signalements;
    }
}

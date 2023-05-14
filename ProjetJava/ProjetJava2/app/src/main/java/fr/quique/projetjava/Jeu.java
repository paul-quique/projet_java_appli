package fr.quique.projetjava;

import java.io.Serializable;
import java.util.ArrayList;

public class Jeu implements Serializable {
    public int getJetonsPlaces() {
        return jetonsPlaces;
    }

    public void setJetonsPlaces(int j) {
        jetonsPlaces = j;
    }
    private int jetonsPlaces;
    private final String nom;
    private final String categorie;
    private final String editeur;

    private final String classement;

    private final int anneeSortie;
    private final String developpeur;
    private final double ventesMondiales;
    //Testeurs
    private final double nbCritiques;
    private final double scoreMoyenCritiques;
    //Joueurs
    private final double nbEvaluations;
    private final double scoreMoyenEvaluations;
    protected String id;
    private static int compteur = 0;
    public String getSupport() {
        return support;
    }

    private final String support;

    public int getAnneeSortie() {
        return anneeSortie;
    }

    public String getDeveloppeur() {
        return developpeur;
    }

    public double getVentesMondiales() {
        return ventesMondiales;
    }

    public double getNbCritiques() {
        return nbCritiques;
    }

    public double getScoreMoyenCritiques() {
        return scoreMoyenCritiques;
    }

    public double getNbEvaluations() {
        return nbEvaluations;
    }

    public double getScoreMoyenEvaluations() {
        return scoreMoyenEvaluations;
    }

    public String getNom() {
        return nom;
    }

    public String getCategorie() {
        return categorie;
    }

    public String getEditeur() {
        return editeur;
    }

    public String getClassement() {
        return classement;
    }


    public Jeu(String support, String nom, String categorie, String editeur, String classement, int anneeSortie, String developpeur, double ventesMondiales, double nbCritiques, double scoreMoyenCritiques, double nbEvaluations, double scoreMoyenEvaluations) {
        this.id = "id::" + compteur++;
        if(nom.equals("")) {
            nom = "?";
        }
        this.nom = nom;
        if(categorie.equals("")) {
            categorie = "?";
        }
        this.categorie = categorie;
        if(editeur.equals("")) {
            editeur = "?";
        }
        this.editeur = editeur;
        if(classement.equals("")) {
            classement = "?";
        }
        this.anneeSortie = anneeSortie;
        if(developpeur.equals("")) {
            developpeur = "?";
        }
        this.developpeur = developpeur;
        this.ventesMondiales = ventesMondiales;
        this.nbCritiques = nbCritiques;
        this.nbEvaluations = nbEvaluations;
        this.scoreMoyenCritiques = scoreMoyenCritiques;
        this.scoreMoyenEvaluations = scoreMoyenEvaluations;
        this.classement = classement;
        this.support = support;
    }
    @Override
    public String toString() {
        return getNom() + " - " + getSupport();
    }
}

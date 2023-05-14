package fr.quique.projetjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListeJeuxJoueurAdapter extends ArrayAdapter<Jeu> {
    private ArrayList<Integer> tempsJeu;
    public ListeJeuxJoueurAdapter(Context context, ArrayList<Jeu> jeux, ArrayList<Integer> tempsJeu) {
        super(context, R.layout.liste_jeux_joueur, jeux);
        this.tempsJeu= tempsJeu;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Jeu jeu = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.liste_jeux_joueur, parent, false);
        }

        TextView nomJeu = convertView.findViewById(R.id.nom_jeu);
        TextView categorie = convertView.findViewById(R.id.categorie);
        TextView editeur = convertView.findViewById(R.id.editeur);
        TextView classement = convertView.findViewById(R.id.classement);
        TextView support = convertView.findViewById(R.id.support);
        TextView anneeSortie = convertView.findViewById(R.id.annee_sortie);
        TextView developpeur = convertView.findViewById(R.id.developpeur);
        TextView ventes = convertView.findViewById(R.id.ventes_mondiales);
        TextView nbCritiques = convertView.findViewById(R.id.nb_critiques);
        TextView moyCritiques = convertView.findViewById(R.id.score_critiques);
        TextView nbEval = convertView.findViewById(R.id.nb_evaluations);
        TextView moyEval = convertView.findViewById(R.id.score_evaluations);
        TextView tj = convertView.findViewById(R.id.temps_jeu_joueur);

        nomJeu.setText(jeu.getNom());
        categorie.setText(jeu.getCategorie());
        editeur.setText(jeu.getEditeur());
        classement.setText(jeu.getClassement());
        support.setText(jeu.getSupport());
        anneeSortie.setText(jeu.getAnneeSortie()+"");
        developpeur.setText(jeu.getDeveloppeur());
        ventes.setText(jeu.getVentesMondiales()+"");
        nbCritiques.setText(jeu.getNbCritiques()+"");
        moyCritiques.setText(jeu.getScoreMoyenCritiques()+"");
        nbEval.setText(jeu.getNbEvaluations()+"");
        moyEval.setText(jeu.getScoreMoyenEvaluations()+"");

        tj.setText("Temps de jeu: " + tempsJeu.get(position) + " heures");
        return convertView;
    }
}
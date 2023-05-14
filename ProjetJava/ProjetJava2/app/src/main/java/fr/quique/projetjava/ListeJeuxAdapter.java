package fr.quique.projetjava;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListeJeuxAdapter extends ArrayAdapter<Jeu> {
    public ListeJeuxAdapter(Context context, ArrayList<Jeu> jeux) {
        super(context, R.layout.liste_jeux, jeux);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Jeu jeu = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.liste_jeux, parent, false);
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
        TextView nbJetons = convertView.findViewById(R.id.nb_jetons);
        Button afficher_les_evals = (Button) convertView.findViewById(R.id.voir_les_evals);
        Button placerJeton = (Button) convertView.findViewById(R.id.placer_jeton);

        afficher_les_evals.setOnClickListener(v -> {
            Intent in = new Intent(getContext(), ListerEvaluationActivity.class);
            in.putExtra("numJeu", position);
            getContext().startActivity(in);
        });

        placerJeton.setOnClickListener(v -> {
            Joueur joueur = (Joueur) MainActivity.utilisateur;
            if (joueur.getNbJetons() > 0) {
                joueur.enleverJeton();
                jeu.setJetonsPlaces(jeu.getJetonsPlaces()+1);
                nbJetons.setText(jeu.getJetonsPlaces()+"");
            }
        });
        nomJeu.setText(jeu.getNom());
        nbJetons.setText(jeu.getJetonsPlaces()+"");
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
        // Return the completed view to render on screen
        return convertView;
    }
}
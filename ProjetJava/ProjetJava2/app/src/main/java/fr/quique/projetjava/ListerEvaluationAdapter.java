package fr.quique.projetjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class ListerEvaluationAdapter extends ArrayAdapter<Evaluation> {

    public ListerEvaluationAdapter(Context context, ArrayList<Evaluation> evals) {
        super(context, R.layout.liste_evaluations, evals);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Evaluation eval = (Evaluation) getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.liste_evaluations, parent, false);
        }

        TextView nomJeu = (TextView) convertView.findViewById(R.id.nom_jeu);
        TextView date = (TextView) convertView.findViewById(R.id.date);
        TextView version = (TextView) convertView.findViewById(R.id.version);
        TextView texte = (TextView) convertView.findViewById(R.id.texte);

        Button pouceBleu = (Button) convertView.findViewById(R.id.pouce_vert);
        Button pouceRouge = (Button) convertView.findViewById(R.id.pouce_rouge);
        pouceBleu.setText(eval.getPouceBleus() + "👍");
        pouceRouge.setText(eval.getPouceRouges() + "👎");
        Button supprimer = (Button) convertView.findViewById(R.id.supprimer_evaluation);
        Button signaler = (Button) convertView.findViewById(R.id.signaler_evaluation);

        nomJeu.setText(eval.getJeu().getNom());
        date.setText(eval.getDate());
        version.setText(eval.getVersion()+"");
        texte.setText(eval.getTexte());

        pouceBleu.setOnClickListener(v -> {
            eval.setPouceBleus(eval.getPouceBleus()+1);
            pouceBleu.setText(eval.getPouceBleus() + "👍");
        });

        pouceRouge.setOnClickListener(v -> {
            eval.setPouceRouges(eval.getPouceRouges()+1);
            pouceRouge.setText(eval.getPouceRouges() + "👎");
        });

        signaler.setOnClickListener(v -> {
            if (MainActivity.utilisateur instanceof Testeur) {
                eval.signaler();
            }
        });

        supprimer.setOnClickListener(v -> {
            if (MainActivity.utilisateur instanceof Administrateur) {
                Evaluation.supprimerEvaluation(eval.id);
            }
        });
        return convertView;
    }
}
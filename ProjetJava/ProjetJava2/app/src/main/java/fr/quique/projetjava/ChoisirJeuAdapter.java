package fr.quique.projetjava;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChoisirJeuAdapter extends ArrayAdapter<Jeu> {
    public ChoisirJeuAdapter(Context context, ArrayList<Jeu> jeux) {
        super(context, R.layout.choisir_jeu, jeux);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Jeu jeu = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.choisir_jeu, parent, false);
        }

        TextView nomJeu = (TextView) convertView.findViewById(R.id.item_jeu);
        nomJeu.setText(jeu.getNom() + " - " + jeu.getSupport());
        // Return the completed view to render on screen
        return convertView;
    }
}
package fr.quique.projetjava;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListeUtilisateursAdapter extends ArrayAdapter<Invite> {
    public ListeUtilisateursAdapter(Context context, ArrayList<Invite> utilisateurs) {
        super(context, R.layout.liste_utilisateurs, utilisateurs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Invite utilisateur = getItem(position);
        Joueur joueur = (Joueur) utilisateur;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.liste_utilisateurs, parent, false);
        }

        TextView textViewName = convertView.findViewById(R.id.nom_utilisateur);
        TextView textViewRole = convertView.findViewById(R.id.role_utilisateur);

        textViewName.setText(joueur.getPseudo());
        textViewName.setOnClickListener(v -> {
                Intent in = new Intent(getContext(), AfficherInfoJoueurActivity.class);
                in.putExtra("pseudo", joueur.getPseudo());
                getContext().startActivity(in);
        });
        if (joueur instanceof Administrateur) {
            textViewRole.setTextColor(Color.RED);
            textViewRole.setText("Administrateur");
        } else if (joueur instanceof Testeur) {
            textViewRole.setTextColor(Color.CYAN);
            textViewRole.setText("Testeur");
        } else {
            textViewRole.setTextColor(Color.GREEN);
            textViewRole.setText("Joueur");
        }


        // Return the completed view to render on screen
        return convertView;
    }
}
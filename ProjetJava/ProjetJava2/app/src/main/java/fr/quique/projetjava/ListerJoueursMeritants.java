package fr.quique.projetjava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListerJoueursMeritants extends AppCompatActivity {
    public ListerJoueursMeritants() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_liste_utilisateurs);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listeU = (ListView) findViewById(R.id.liste_utilisateurs);
        ArrayList<Joueur> utilisateurs = new ArrayList<Joueur>();
        for (Joueur j : MainActivity.joueurs) {
            utilisateurs.add(j);
        }
        utilisateurs.sort(new JoueurComparator());
        listeU.setAdapter(new ListeJoueursMeritantsAdapter(this, utilisateurs));
        final Button retour = (Button) findViewById(R.id.bouton_retour);
        retour.setOnClickListener(v -> {
            finish();
        });
    }
}

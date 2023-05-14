package fr.quique.projetjava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListerJeuxATesterActivity extends AppCompatActivity {
    public ListerJeuxATesterActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_liste_jeux);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listeJ = (ListView) findViewById(R.id.liste_jeux);
        Joueur j = (Joueur) Persistant.obtenirUtilisateur(getIntent().getExtras().getString("pseudo"));
        ArrayList<Jeu> jeux = j.getJeux();
        jeux.sort(new JeuComparator());

        listeJ.setAdapter(new ListeJeuxAdapter(this, jeux));
        final Button retour = (Button) findViewById(R.id.bouton_retour);

        retour.setOnClickListener(v -> {
            finish();
        });
    }
}

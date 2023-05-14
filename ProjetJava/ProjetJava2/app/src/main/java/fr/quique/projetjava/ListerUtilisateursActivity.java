package fr.quique.projetjava;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ListerUtilisateursActivity extends AppCompatActivity {
    public ListerUtilisateursActivity() {
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
        ArrayList<Invite> utilisateurs = new ArrayList<Invite>();
        for (Administrateur a : MainActivity.admins) {
            utilisateurs.add(a);
        }
        for (Testeur t : MainActivity.testeurs) {
            utilisateurs.add(t);
        }
        for (Joueur j : MainActivity.joueurs) {
            utilisateurs.add(j);
        }
        listeU.setAdapter(new ListeUtilisateursAdapter(this, utilisateurs));
        final Button retour = (Button) findViewById(R.id.bouton_retour);
        retour.setOnClickListener(v -> {
            finish();
        });
    }
}

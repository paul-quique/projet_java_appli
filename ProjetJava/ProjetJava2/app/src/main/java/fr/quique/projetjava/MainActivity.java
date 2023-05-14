package fr.quique.projetjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<Administrateur> admins;
    public static ArrayList<Testeur> testeurs;
    public static ArrayList<Joueur> joueurs;

    public static Invite utilisateur;

    public static ArrayList<Jeu> jeux;

    public MainActivity() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Persistant.charger(getApplicationContext());

        final Button ouvrirEnregistrement = (Button) findViewById(R.id.ouvrir_enregistrement);
        ouvrirEnregistrement.setOnClickListener(v -> {
            Intent in = new Intent(this, CreerCompteActivity.class);
            startActivity(in);
        });

        final Button validerConnexion = (Button) findViewById(R.id.valider_connexion);
        final TextInputEditText pseudo = (TextInputEditText) findViewById(R.id.pseudo_connexion);
        validerConnexion.setOnClickListener(v -> {
            String p = pseudo.getText().toString();
            utilisateur = Persistant.obtenirUtilisateur(p);
            if (!CreerCompteActivity.pseudoExiste(p)) {
                pseudo.setHintTextColor(Color.RED);
                pseudo.setHint("Utilisateur inconnu");
                pseudo.setText("");
            } else if (((Joueur) utilisateur).isBloque()) {
                pseudo.setHintTextColor(Color.RED);
                pseudo.setHint("Utilisateur bloqué");
                pseudo.setText("");
            } else {
                    Intent in = new Intent(this, ChoisirActionActivity.class);
                    startActivity(in);
            }
        });
        jeux = Persistant.chargerJeux(this);
    }

    @Override
    protected void onDestroy() {
        /*Sérialiser les objets et les enregistrer dans des fichiers persistants à la fermeture*/
        super.onDestroy();
        Persistant.sauvegarder(getApplicationContext());
    }

}
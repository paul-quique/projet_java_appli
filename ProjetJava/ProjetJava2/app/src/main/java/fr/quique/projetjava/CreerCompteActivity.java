package fr.quique.projetjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CreerCompteActivity extends AppCompatActivity {
    public CreerCompteActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_creer_compte);
        final Button ouvrirEnregistrement = (Button) findViewById(R.id.retour_connexion);
        ouvrirEnregistrement.setOnClickListener(v -> {
            finish();
        });
        final Button creerCompte = (Button) findViewById(R.id.creer_compte);
        final TextInputEditText pseudo = (TextInputEditText) findViewById(R.id.pseudo_nouveau_compte);
        creerCompte.setOnClickListener(v -> {
            String p = pseudo.getText().toString();
            if (p.equals("")) {

            } else if (pseudoExiste(p)){
                creerCompte.setTextColor(Color.RED);
                creerCompte.setText("Valider (pseudo déjà utilisé)");
            } else if (p.equals("admin")){
                MainActivity.admins.add(new Administrateur(p));
                finish();
            } else {
                MainActivity.joueurs.add(new Joueur(p));
                finish();
            }
        });
    }

    public static final boolean pseudoExiste(String pseudo) {
        for (Joueur j : MainActivity.joueurs) {
            if (j.getPseudo().equals(pseudo)) {
                return true;
            }
        }
        for (Testeur t : MainActivity.testeurs) {
            if (t.getPseudo().equals(pseudo)) {
                return true;
            }
        }

        for (Administrateur a : MainActivity.admins) {
            if (a.getPseudo().equals(pseudo)) {
                return true;
            }
        }
        return false;
    }
}

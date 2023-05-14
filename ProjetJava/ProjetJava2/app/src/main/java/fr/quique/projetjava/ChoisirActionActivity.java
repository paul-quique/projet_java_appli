package fr.quique.projetjava;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class ChoisirActionActivity extends AppCompatActivity {

    public ChoisirActionActivity() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_choisir_action);
        final Button supprimerCompte = (Button) findViewById(R.id.supprimer_compte);
        final Button listerJoueurs = (Button) findViewById(R.id.lister_joueurs);
        listerJoueurs.setOnClickListener(v -> {
            Intent i = new Intent(this, ListerUtilisateursActivity.class);
            startActivity(i);
        });
        supprimerCompte.setOnClickListener(v -> {
            if (MainActivity.utilisateur instanceof Joueur) {
                Joueur j = (Joueur) MainActivity.utilisateur;
                Joueur.supprimerCompte(j.getPseudo());
                finish();
            }
        });
        final Button listerJeux = (Button) findViewById(R.id.voir_jeux);
        listerJeux.setOnClickListener(v -> {
            Intent i = new Intent(this, ListerJeuxActivity.class);
            startActivity(i);
        });

        final Button nouvelleEval = (Button) findViewById(R.id.ajouter_evaluation);
        nouvelleEval.setOnClickListener(v -> {
            Joueur j = (Joueur) MainActivity.utilisateur;
            if (j.getJeux().size() == 0) return;
            Intent i = new Intent(this, AjouterEvaluationActivity.class);
            i.putExtra("pseudo", j.getPseudo());
            startActivity(i);
        });

        final Button nouvelleCritique = (Button) findViewById(R.id.ajouter_critique);
        if (MainActivity.utilisateur instanceof Testeur) {
            nouvelleCritique.setOnClickListener(v -> {
                Testeur t = (Testeur) MainActivity.utilisateur;
                if (t.getJeux().size() == 0) return;
                Intent i = new Intent(this, AjouterCritiqueActivity.class);
                i.putExtra("pseudo", t.getPseudo());
                startActivity(i);
            });
        }

        final Button jeuxATester = (Button) findViewById(R.id.jeux_a_tester);
        if (MainActivity.utilisateur instanceof Testeur) {
            jeuxATester.setOnClickListener(v -> {
                Testeur t = (Testeur) MainActivity.utilisateur;
                if (t.getJeux().size() == 0) return;
                Intent i = new Intent(this, ListerJeuxATesterActivity.class);
                i.putExtra("pseudo", t.getPseudo());
                startActivity(i);
            });
        }

        final Button evalsSignalees = (Button) findViewById(R.id.evaluations_signalees);
        if (MainActivity.utilisateur instanceof Administrateur) {
            evalsSignalees.setOnClickListener(v -> {
                Intent i = new Intent(this, ListerEvaluationsSignaleesActivity.class);
                startActivity(i);
            });
        }

        final Button joueursMeritants = (Button) findViewById(R.id.meritants_promotion);
        if (MainActivity.utilisateur instanceof Administrateur) {
            joueursMeritants.setOnClickListener(v -> {
                Intent i = new Intent(this, ListerJoueursMeritants.class);
                startActivity(i);
            });
        }
    }

    @Override
    protected void onDestroy() {
        /*Sérialiser les objets et les enregistrer dans des fichiers persistants à la fermeture*/
        super.onDestroy();
        Persistant.sauvegarder(getApplicationContext());
    }

}
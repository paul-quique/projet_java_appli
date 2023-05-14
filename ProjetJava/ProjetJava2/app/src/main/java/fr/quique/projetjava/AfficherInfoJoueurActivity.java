package fr.quique.projetjava;

import android.content.Intent;
import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.google.android.material.textfield.TextInputEditText;

public class AfficherInfoJoueurActivity extends AppCompatActivity {
    private Joueur utilisateur;
    public AfficherInfoJoueurActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Invite i = Persistant.obtenirUtilisateur(getIntent().getExtras().getString("pseudo"));
        this.utilisateur = (Joueur) i;

        setContentView(R.layout.activite_afficher_info_joueur);
        final TextView pseudo = (TextView) findViewById(R.id.pseudo_utilisateur);
        pseudo.setText(utilisateur.getPseudo());

        final TextView dureeJeuGlobale = (TextView) findViewById(R.id.duree_jeu_globale);
        dureeJeuGlobale.setText(utilisateur.getDureeJeuGlobale() + " heure(s)");

        final TextView nbEvaluations = (TextView) findViewById(R.id.nb_evaluations);
        nbEvaluations.setText(utilisateur.getEvals().size() + "");

        final TextView nbPoucesBleu = (TextView) findViewById(R.id.avis_utiles);
        if (MainActivity.utilisateur instanceof Testeur) {
            nbPoucesBleu.setText(utilisateur.getPoucesBleu() + "");
        }

        final TextView nbPoucesRouges = (TextView) findViewById(R.id.avis_inutiles);
        if (MainActivity.utilisateur instanceof Testeur) {
            nbPoucesRouges.setText(utilisateur.getPoucesRouge() + "");
        }
        final Button desincrireCompte = (Button) findViewById(R.id.desincrire_utilisateur);
        desincrireCompte.setOnClickListener(v -> {
            if ((MainActivity.utilisateur instanceof Administrateur)) {
                Joueur.supprimerCompte(utilisateur.getPseudo());
                finish();
            }
        });
        if (! (MainActivity.utilisateur instanceof Administrateur)) {
            desincrireCompte.setTextColor(getResources().getColor(R.color.gray));
        }
        final Button bloquerCompte = (Button) findViewById(R.id.bloquer_compte);
        bloquerCompte.setOnClickListener(v -> {
            if ((MainActivity.utilisateur instanceof Administrateur)) {
                utilisateur.setBloque(true);
                finish();
            }
        });
        if (! (MainActivity.utilisateur instanceof Administrateur)) {
            desincrireCompte.setTextColor(getResources().getColor(R.color.gray));
        }
        final Button promouvoirCompte = (Button) findViewById(R.id.promouvoir_utilisateur);
        promouvoirCompte.setOnClickListener(v -> {
            if ((MainActivity.utilisateur instanceof Administrateur)) {
                if (utilisateur instanceof Administrateur) {
                } else if (utilisateur instanceof Testeur) {
                    Joueur.supprimerCompte(utilisateur.getPseudo());
                    MainActivity.admins.add(((Testeur) utilisateur).promouvoir());
                } else {
                    Joueur.supprimerCompte(utilisateur.getPseudo());
                    MainActivity.testeurs.add(((Joueur) utilisateur).promouvoir());
                }
                finish();
            }
        });
        if (! (MainActivity.utilisateur instanceof Administrateur)) {
            promouvoirCompte.setTextColor(getResources().getColor(R.color.gray));
        }
        final TextView textViewRole = (TextView) findViewById(R.id.type_profil);
        if (utilisateur instanceof Administrateur) {
            textViewRole.setTextColor(Color.RED);
            textViewRole.setText("Administrateur");
        } else if (utilisateur instanceof Testeur) {
            textViewRole.setTextColor(Color.CYAN);
            textViewRole.setText("Testeur");
        } else {
            textViewRole.setTextColor(Color.GREEN);
            textViewRole.setText("Joueur");
        }
        final Button ajouterJeu = (Button) findViewById(R.id.ajouter_jeu_btn);
        ajouterJeu.setOnClickListener(v -> {
            if ((MainActivity.utilisateur instanceof Administrateur)) {
                Intent in = new Intent(this, AjouterJeuActivity.class);
                in.putExtra("pseudo", getIntent().getExtras().getString("pseudo"));
                startActivity(in);
            }
        });
        if (!(MainActivity.utilisateur instanceof Administrateur)) {
            ajouterJeu.setTextColor(getResources().getColor(R.color.gray));
        }

        final Button voirJeuxJoueur = (Button) findViewById(R.id.voir_jeux_joueur);
        voirJeuxJoueur.setOnClickListener(v -> {
                Intent in = new Intent(this, ListerJeuxJoueurActivity.class);
                in.putExtra("pseudo", getIntent().getExtras().getString("pseudo"));
                startActivity(in);
        });
    }
}

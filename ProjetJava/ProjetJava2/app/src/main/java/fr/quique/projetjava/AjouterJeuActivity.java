package fr.quique.projetjava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class AjouterJeuActivity extends AppCompatActivity {
    public AjouterJeuActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activite_ajouter_jeux);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Spinner listeJ = (Spinner) findViewById(R.id.spinner_jeux);

        listeJ.setAdapter(new ChoisirJeuAdapter(this, MainActivity.jeux));
        final TextInputEditText tj = (TextInputEditText) findViewById(R.id.temps_jeu);
        final Button valider = (Button) findViewById(R.id.ajouter_jeu_valider);
        valider.setOnClickListener(v -> {
            Joueur joueur = (Joueur) Persistant.obtenirUtilisateur(getIntent().getExtras().getString("pseudo"));
            String temps = tj.getText().toString();
            Jeu j = MainActivity.jeux.get(listeJ.getSelectedItemPosition());
            joueur.ajouterJeu(temps, j);
            finish();
        });
    }
}

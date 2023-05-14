package fr.quique.projetjava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AjouterCritiqueActivity extends AppCompatActivity {
    public AjouterCritiqueActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_critique);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Invite i = Persistant.obtenirUtilisateur(getIntent().getExtras().getString("pseudo"));
        Testeur testeur = (Testeur) i;

        Spinner listeJ = (Spinner) findViewById(R.id.spinner_jeux);
        listeJ.setAdapter(new ChoisirJeuAdapter(this, testeur.getJeux()));

        final TextInputEditText texte = (TextInputEditText) findViewById(R.id.texte_eval);
        final TextInputEditText version = (TextInputEditText) findViewById(R.id.version_eval);
        final TextInputEditText noteGameplay = (TextInputEditText) findViewById(R.id.note_gameplay);
        final TextInputEditText noteInterface = (TextInputEditText) findViewById(R.id.note_interface);
        final TextInputEditText noteOptimisation = (TextInputEditText) findViewById(R.id.note_optimisation);

        final Button valider = (Button) findViewById(R.id.valider);

        valider.setOnClickListener(v -> {
            Jeu j = testeur.getJeux().get((listeJ.getSelectedItemPosition()));

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            String date = dateFormat.format(cal.getTime());

            testeur.ajouterCritique(date, version.getText().toString(), texte.getText().toString(), noteInterface.getText().toString(), noteGameplay.getText().toString(), noteInterface.getText().toString());
            j.setJetonsPlaces(0);
            testeur.ajouterJetons(5);
            finish();
        });
    }
}

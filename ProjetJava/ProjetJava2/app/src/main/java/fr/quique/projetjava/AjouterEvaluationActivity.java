package fr.quique.projetjava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class AjouterEvaluationActivity extends AppCompatActivity {
    public AjouterEvaluationActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ajouter_evaluation);
    }

    @Override
    protected void onResume() {
        super.onResume();

        Invite i = Persistant.obtenirUtilisateur(getIntent().getExtras().getString("pseudo"));
        Joueur joueur = (Joueur) i;

        Spinner listeJ = (Spinner) findViewById(R.id.spinner_jeux);
        listeJ.setAdapter(new ChoisirJeuAdapter(this, joueur.getJeux()));

        final TextInputEditText texte = (TextInputEditText) findViewById(R.id.texte_eval);
        final TextInputEditText version = (TextInputEditText) findViewById(R.id.version_eval);
        final Button valider = (Button) findViewById(R.id.valider);

        valider.setOnClickListener(v -> {
            Jeu j = joueur.getJeux().get((listeJ.getSelectedItemPosition()));

            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            Calendar cal = Calendar.getInstance();
            String date = dateFormat.format(cal.getTime());

            joueur.ajouterEval(new Evaluation(
                    date, texte.getText().toString(), version.getText().toString(), j
            ));
            finish();
        });
    }
}

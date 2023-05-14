package fr.quique.projetjava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListerEvaluationsSignaleesActivity extends AppCompatActivity {
    public ListerEvaluationsSignaleesActivity() {
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
        ArrayList<Evaluation> evals =  Evaluation.obtenirEvaluations();

        evals.sort(new EvaluationSignaleesComparator());
        listeJ.setAdapter(new ListerEvaluationAdapter(this, evals));

        final Button retour = (Button) findViewById(R.id.bouton_retour);
        retour.setOnClickListener(v -> {
            finish();
        });
    }
}

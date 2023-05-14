package fr.quique.projetjava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ListerEvaluationActivity extends AppCompatActivity {
    public ListerEvaluationActivity() {
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
        int numJeu = getIntent().getExtras().getInt("numJeu");
        ArrayList<Evaluation> evals =  Evaluation.obtenirEvaluations(MainActivity.jeux.get(numJeu));
        evals.sort(new EvaluationComparator());
        listeJ.setAdapter(new ListerEvaluationAdapter(this, evals));

        final Button retour = (Button) findViewById(R.id.bouton_retour);
        retour.setOnClickListener(v -> {
            finish();
        });
    }
}

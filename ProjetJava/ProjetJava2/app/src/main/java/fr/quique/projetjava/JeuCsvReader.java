package fr.quique.projetjava;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JeuCsvReader {
    public ArrayList<Jeu> readCsv(InputStream inputStream) {
        ArrayList<Jeu> jeux = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        try {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",", -1);
                if (fields.length != 17) continue;
                Jeu jeu = new Jeu(fields[2], fields[1], fields[4], fields[5], fields[16], (int) versDouble(fields[3]), fields[15], versDouble(fields[10]), versDouble(fields[12]), versDouble(fields[11]), versDouble(fields[14]), versDouble(fields[13]));
                jeux.add(jeu);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return jeux;
    }

    private double versDouble(String nombre) {
        if (nombre.equals("")) {
            return Double.NaN;
        }else {
            double x;
            try {
                x = Double.parseDouble(nombre);
                return x;
            } catch (NumberFormatException e) {
                return Double.NaN;
            }
        }
    }

}

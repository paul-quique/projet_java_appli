package fr.quique.projetjava;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*Classe qui permet de charger les données persistantes de l'application, ainsi que de les sauvegarder*/
public class Persistant {
    /*Peupler les listes en paramètres avec les profils sauvegardés dans les fichiers de sauvegarde*/
    protected static  void charger(Context context) {
        /*Charger les administrateurs*/
        try {
            FileInputStream fis = context.openFileInput("admins.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            MainActivity.admins = (ArrayList<Administrateur>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            MainActivity.admins = new ArrayList<Administrateur>();
        }
        /*Charger les testeurs*/
        try {
            FileInputStream fis = context.openFileInput("testeurs.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            MainActivity.testeurs = (ArrayList<Testeur>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            MainActivity.testeurs = new ArrayList<Testeur>();
        }
        /*Charger les joueurs*/
        try {
            FileInputStream fis = context.openFileInput("joueurs.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            MainActivity.joueurs = (ArrayList<Joueur>) ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException | ClassNotFoundException e) {
            MainActivity.joueurs= new ArrayList<Joueur>();
        }
    }

    protected static void sauvegarder(Context context) {
        sauvegarder("admins.dat", MainActivity.admins, context);
        sauvegarder("testeurs.dat", MainActivity.testeurs, context);
        sauvegarder("joueurs.dat", MainActivity.joueurs, context);
    }

    private static void sauvegarder(String nomFichier, Object o, Context context) {
        try {
            FileOutputStream fos = context.openFileOutput(nomFichier, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(o);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected static Invite obtenirUtilisateur(String pseudo) {
        for (Joueur j : MainActivity.joueurs) {
            if (j.getPseudo().equals(pseudo)) {
                return j;
            }
        }
        for (Testeur t : MainActivity.testeurs) {
            if (t.getPseudo().equals(pseudo)) {
                return t;
            }
        }

        for (Administrateur a : MainActivity.admins) {
            if (a.getPseudo().equals(pseudo)) {
                return a;
            }
        }
        return new Invite();
    }

    protected static ArrayList<Jeu> chargerJeux(Context ctx) {
        AssetManager am = ctx.getAssets();
        InputStream inputStream = null;
        try {
            inputStream = am.open("jvdata.csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JeuCsvReader csvReader = new JeuCsvReader();
        ArrayList<Jeu> jeux = csvReader.readCsv(inputStream);
        return jeux;
    }
}

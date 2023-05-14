package fr.quique.projetjava;

import java.util.ArrayList;

public class Critique {
    private String date;
    private String version;
    private String texte;
    private int noteInterface, noteGameplay, noteOptimisation;

    public Critique(String date, String version, String texte, int noteInterface, int noteGameplay, int noteOptimisation) {
        this.date = date;
        this.version = version;
        this.texte = texte;
        this.noteInterface = noteInterface;
        this.noteGameplay = noteGameplay;
        this.noteOptimisation = noteOptimisation;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public int getNoteInterface() {
        return noteInterface;
    }

    public void setNoteInterface(int noteInterface) {
        this.noteInterface = noteInterface;
    }

    public int getNoteGameplay() {
        return noteGameplay;
    }

    public void setNoteGameplay(int noteGameplay) {
        this.noteGameplay = noteGameplay;
    }

    public int getNoteOptimisation() {
        return noteOptimisation;
    }

    public void setNoteOptimisation(int noteOptimisation) {
        this.noteOptimisation = noteOptimisation;
    }


}

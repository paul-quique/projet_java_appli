package fr.quique.projetjava;

import java.io.Serializable;

public class Administrateur extends Testeur implements Serializable {
    public Administrateur (String pseudo) {
        super(pseudo);
        this.pseudo = pseudo;
    }

    protected Administrateur promouvoir() {
        return this;
    }
}

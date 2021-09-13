package com.dam.damsport;



public class Exercice {

    String titre;
    String typeExercice;
    long chrono;
    int media;

    public Exercice(){

    }

    public Exercice(String titre, String typeExercice, long chrono, int media) {
        this.titre = titre;
        this.typeExercice = typeExercice;
        this.chrono = chrono;
        this.media = media;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getTypeExercice() {
        return typeExercice;
    }

    public void setTypeExercice(String typeExercice) {
        this.typeExercice = typeExercice;
    }

    public long getChrono() {
        return chrono;
    }

    public void setChrono(long chrono) {
        this.chrono = chrono;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }
}

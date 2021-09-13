package com.dam.damsport;

import androidx.annotation.NonNull;

class ExerciceString {
    private String nom, type, chrono, image;

    public ExerciceString(String nom, String type, String chrono, String image) {
        this.nom = nom;
        this.type = type;
        this.chrono = chrono;
        this.image = image;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}

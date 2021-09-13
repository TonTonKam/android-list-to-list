package com.dam.damsport;

import java.util.ArrayList;

public class StokageExercice {

    /** endroit qui sort les attributs **/
    private String[] titre = {"Bodybuilding", "powerlifting", "Haltérophilie", "Crossfit", "Endurence Cardiovasculaire", "Souplesse",
            "Equilibre", "Explosivité", "Vitesse", "Précision", "Agilité", "pushup", "abdo", "renforcement musculaire", "squat"};

    private String[] typeExercice = {"Musculation", "Musculation", "Musculation", "Cardio", "Cardio", "renforcement Musculaire",
            "renforcement Musculaire", "Cardio", "Cardio", "Musculation", "renforcement musculaire", "Musculation",
            "Musculation", "renforcement musculaire", "renforcement musculaire"};

    private int[] chrono = {900000, 600000, 300000, 900000, 1800000, 900000, 300000, 300000, 300000, 300000, 300000, 300000, 300000,
            300000, 300000};

    private int[] media = {R.drawable.exercice_01, R.drawable.exercice_02, R.drawable.exercice_03, R.drawable.exercice_04,
            R.drawable.exercice_05, R.drawable.exercice_06, R.drawable.exercice_07, R.drawable.exercice_08,
            R.drawable.exercice_09, R.drawable.exercice_010, R.drawable.exercice_011, R.drawable.exercice_012,
            R.drawable.exercice_013, R.drawable.exercice_014, R.drawable.exercice_01};

    private ArrayList<Exercice> exoList = new ArrayList<>();

    /** introduire les donnees dans une liste et mettre une position pour la liste **/
    public StokageExercice() {
        for(int index = 0; index < media.length; index++){
            exoList.add(index, new Exercice(titre[index], typeExercice[index], chrono[index], media[index]));
        }
    }

    public ArrayList<Exercice> getExoList() {
        return exoList;
    }

    public void setExoList(ArrayList<Exercice> exoList) {
        this.exoList = exoList;
    }
}
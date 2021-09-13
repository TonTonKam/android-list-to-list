package com.dam.damsport;

import android.content.Context;
import android.view.View;

import java.util.ArrayList;

class TestStokageExterneFail {

//    Afficheur afficheur;
    Context mContext;

    private ArrayList<Exercice> listExerciceSelect = new ArrayList<>();
    private ArrayList<Exercice> listExerciceTempo = new ArrayList<>();

    private String titre, type;
    private long chrono;
    private int media;

    /**
     * l'index se synchronise bien avec celui de la liste mais le contenu ne s'affiche pas
     * le contenu est null
     */
    protected static int index = -1;
//    int indexList = index -1;

    /** la liste que le recycleur prend est celui du constructeur
     * la liste que le constructeur a, ne s'alimente pas
     */
    public TestStokageExterneFail(ArrayList<Exercice> list){
        this.listExerciceTempo = list;
        listExerciceSelect = listExerciceTempo;
//        init();
    }

    public TestStokageExterneFail(Context context){
        this.mContext = context;
    }

    public TestStokageExterneFail() {
//        ArrayList<Exercice> listExerciceSelect = new ArrayList<Exercice>();
//        listExerciceSelect = new ArrayList<Exercice>();

//        titre = "salut";
//        type = "muscu";
//        chrono = 600000;
//        media = R.drawable.chrono_icone;
//        Exercice exercice = new Exercice(titre, type, chrono, media);
//        listExerciceSelect.add(0 , exercice);
        listExerciceTempo = listExerciceSelect;
//        init();
    }

    private void init(){
        titre = "salut";
        type = "muscu";
        chrono = 600000;
        media = R.drawable.chrono_icone;
        Exercice exercice = new Exercice(titre, type, chrono, media);
        listExerciceSelect.add(index , exercice);
    }

    public void ajoutItem(String titre, String type, long chrono, int media){
        index++;
        listExerciceSelect.add(index, new Exercice(titre, type, chrono, media));
    }

    public void ajoutItem(Exercice exercice){
        index++;
        listExerciceSelect.add(index, exercice);
    }

    public ArrayList<Exercice> getListExerciceSelect() {
        return listExerciceSelect;
    }

    public ArrayList<Exercice> getListExerciceTempo() {
        return listExerciceTempo;
    }

    public void setListExerciceSelect(ArrayList<Exercice> listExerciceSelect) {
        this.listExerciceSelect = listExerciceSelect;
    }

//    public static int getIndex() {
//        return index;
//    }
//
//    public static void setIndex(int index) {
//        StockageExoFaire.index = index;
//    }

}

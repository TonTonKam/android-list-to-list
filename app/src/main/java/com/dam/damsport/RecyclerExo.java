package com.dam.damsport;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerExo extends AppCompatActivity {
    /** Attributs globaux **/
    private RecyclerView recyclerView;
    private StokageExercice stokageExercice = new StokageExercice();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle(R.string.listeExercices);
        setContentView(R.layout.activity_recycler_exo);
        /** Appel des méthodes **/
        initUI();
        remplissageRecycler();

    }

    /**
     * l'objet donne les informations d'affichage
     */
    public void initUI(){
        recyclerView = (RecyclerView) findViewById(R.id.mRecyclerView);

    }

    public void remplissageRecycler(){
        // Déclaration de l'adapter

        /** l'adapter a les donnees du la partie de stockage */
        ExoAdapter exoAdapter = new ExoAdapter(this, stokageExercice.getExoList());

        // Ajout de l'adapteur au recyclerView
        recyclerView.setAdapter(exoAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

    }

//    /**
//     * instruction avec un objet
//     */
//    public void remplissageRecycler(){
//        // Déclaration de l'adapter
//        ExoAdapter exoAdapter = new ExoAdapter(this, titre, typeExercice, chrono, media);
//        // Ajout de l'adapteur au recyclerView
//        recyclerView.setAdapter(exoAdapter);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
//
//        recyclerView.setLayoutManager(layoutManager);
//
//    }




}

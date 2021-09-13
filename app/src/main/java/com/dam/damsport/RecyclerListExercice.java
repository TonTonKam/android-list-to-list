package com.dam.damsport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RecyclerListExercice extends AppCompatActivity {

//    private TestStokageExterneFail stock;
    private FloatingActionButton fab;
    private Button lect;
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;

    protected static ArrayList<Exercice> listExoADefinir = new ArrayList<>();

    //reception
    private String receptionTitre, receptionType;
    private long receptionTempsChrono;
    private int receptionImage;

    protected static int indexList = -1;

    ArrayList<Exercice> listTempo = new ArrayList<>();
//    ArrayList<Exercice> listExerciceFaire = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(R.string.vosActivity);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_exercice);


        /*
        si le recycleur est vide => creer un objet stock avec son contenu
                                 => sinon utiliser l'objet stock deja existant
         */
//        addItemList();
//        stock = new StockageExoFaire(listTempo);

//        ajouteListe(getData());

//        listTempo = ajouteListe(getData());
//        listExerciceFaire.add(indexList, listTempo.get(0));

        initUI();
        remplissageRecycler();

        // afficher le recycler si la liste contient un item
        if(indexList != -1){
            getData();
        }

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** pour que le context de l'activity puisse aller vers une autre activity il lui
                 * faut un getApplicationContext et non un this ou un context
                 */
                Intent intent = new Intent(getApplicationContext(), RecyclerExo.class);
                startActivity(intent);

//                Toast.makeText(getApplicationContext(), "les valeurs Recycler : " + stock.getListExerciceSelect().size(), Toast.LENGTH_LONG).show();
//                if(stock.getListExerciceTempo().size() == 0){
//                    Toast.makeText(getApplicationContext(), "recyler tempo vide", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(getApplicationContext(), "recyler tempo " + stock.getListExerciceTempo().size(), Toast.LENGTH_SHORT).show();
//                }
            }
        });

        lect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** dans un 1er temps, ce bouton servira de test pour voir la taille de la liste
                 * dans un second temps il servira a lire le contenu de la liste
                 */
                Toast.makeText(getApplicationContext(), "nombre d'elements dans la liste " +
                        listExoADefinir.size(),Toast.LENGTH_LONG).show();
            }
        });

    }

    public void initUI(){
        recyclerView = (RecyclerView) findViewById(R.id.lRecyclerView);
        fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        lect = (Button) findViewById(R.id.lecture);
    }

    public void remplissageRecycler(){
        // Déclaration de l'adapter
//        stock = new StockageExoFaire(this);
        /** l'adapter a les donnees du la partie de ca liste creer par l'utilisateur */
//        ListAdapter listAdapter = new ListAdapter(this, stock.getListExerciceSelect());

        // test de l'integration de la liste à lire dans l'activité
        listAdapter = new ListAdapter(this, listExoADefinir);
        listAdapter.notifyDataSetChanged();

        // Ajout de l'adapteur au recyclerView
        recyclerView.setAdapter(listAdapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL,false);

        recyclerView.setLayoutManager(layoutManager);
    }

//    public ArrayList<Exercice> getListExoADefinir() {
//        return listExoADefinir;
//    }
//
//    public void setListExoADefinir(ArrayList<Exercice> listExoADefinir) {
//        this.listExoADefinir = listExoADefinir;
//    }

        private ArrayList<Exercice> getData(){

        Intent intent = getIntent();
        receptionTitre = intent.getStringExtra("envoieTitle");
        receptionType = intent.getStringExtra("envoieTypeSport");
        receptionTempsChrono = intent.getLongExtra("envoieTempsChrono", 0);
        receptionImage = intent.getIntExtra("envoieImage",0);
        Exercice exo = new Exercice(receptionTitre, receptionType, receptionTempsChrono, receptionImage);
        listExoADefinir.add(indexList, exo);

        listAdapter.notifyDataSetChanged();

        return listExoADefinir;
//        listTempo.add(indexList, exo);
//        return listTempo;
    }

    /* Zone d'ancien essais */
//    private ArrayList<Exercice> ajouteListe(Exercice data){
//        ArrayList<Exercice> listTempo = new ArrayList<>();
//        listTempo.add(data);
//        indexList++;
//        return listTempo;
//    }
//
//    public ArrayList<Exercice> getListExerciceFaire() {
//        return listExerciceFaire;
//    }
//
//    public ArrayList<Exercice> getListTempo() {
//        return listTempo;
//    }

    //    public ArrayList<Exercice> getListExerciceFaire() {
//        return listExerciceFaire;
//    }
//
//    public void setListExerciceFaire(ArrayList<Exercice> listExerciceFaire) {
//        this.listExerciceFaire = listExerciceFaire;
//    }
//
//    private void addItemList(){
//        String titre = "salut";
//        String type = "muscu";
//        long chrono = 600000;
//        int media = R.drawable.chrono_icone;
//        Exercice exercice = new Exercice(titre, type, chrono, media);
//        listExerciceFaire.add(0, exercice);
//    }
//
//    public void addItemDistance(int index, Exercice exo){
//        listExerciceFaire.add(index,exo);
//    }

//    public void transit(){
//        /** receptionner l'intent du bouton de l'adapteur
//         * seul l'activite arrive a recevoir le bundle de l'intent
//         */
//        bundle = getIntent().getExtras();
//        receptionTitre = bundle.getString("envoieTitle");
//        receptionType = bundle.getString("envoieTypeSport");
//        receptionTempsChrono = bundle.getLong("envoieTempsChrono");
//        receptionImage = bundle.getInt("envoieImage");
//
//        Exercice exo = new Exercice();
//        exo.titre = receptionTitre;
//        exo.typeExercice = receptionType;
//        exo.chrono = receptionTempsChrono;
//        exo.media = receptionImage;
//
//        listExerciceSelect.add(exo);
//
//        /** argument sert de transporteur comme le bunble
//         * l'argument permet d'envoyer les donnees vers un fragment
//         * pour envoyer l'argument il ne faut pas oublier d'instancier l'objet (fragment) */
//
//        /** integrer le contenu du bouton dans un TextView
//         * le textTest.setText(titre) de l'activite recoit bien l'info
//         */
//    }

    //    /**
//     * instruction avec un objet
//     */
//    public void remplissageRecycler(){
//        /** Déclaration de l'adapter */
//        ListExerciceAdapter exoAdapter = new ListExerciceAdapter(this, titre,typeExercice,chrono,media);
//        /** Ajout de l'adapteur au recyclerView */
//        recyclerView.setAdapter(exoAdapter);
//
//        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
//
//        recyclerView.setLayoutManager(layoutManager);
//
//    }
//
//    private void getData(){
//        if(getIntent().hasExtra("listTitres") && getIntent().hasExtra("listTypeExercice")
//                && getIntent().hasExtra("listChrono") && getIntent().hasExtra("listMedia")){
//
//            /**
//             *on recupere la donnee du tag et on la stock dans la table qui correspond
//             */
//            titre = getIntent().getStringExtra("listTitres");
//            typeExercice = getIntent().getStringExtra("listTypeExercice");
//            chrono = getIntent().getIntExtra("listChrono",1);
//            media = getIntent().getIntExtra("listMedia", 1);
//            listExo.add(new Exercice(titre, typeExercice, chrono, media));
//
//
//        }else{
//
//            /**
//            sinon envoyer un message d'erreur pour dire que la donnee est vide
//             */
//            Toast.makeText(this,"No data dans le recyclerList", Toast.LENGTH_SHORT).show();
//        }
//    }

}
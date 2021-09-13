package com.dam.damsport;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class Afficheur extends AppCompatActivity {

    private ExerciceDefini exerciceDefini;
    private FragmentTransaction fragmentTransaction;

    private ListAdapter listAdapter;

//    private StockageExoFaire stock;
//    RecyclerListExercice activityListExo = new RecyclerListExercice();
//    private RecyclerListExercice recyclerListExo;
//    private ArrayList<Exercice> listTempo = new ArrayList<>();

    private Button ajouterExo;
    private FloatingActionButton fab1;
    private FloatingActionButton fab2;

//    private int indexTest = -1;

    private String titre, type;
    private long tempsChrono;
    private int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(R.string.choixExercice);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afficheur);

        exerciceDefini = new ExerciceDefini();

//        stock = new StockageExoFaire();

//        listAdapter = new ListAdapter(this, listTempo);

//        recyclerListExo = new RecyclerListExercice();

//        stock = new StockageExoFaire(listTempo);
//        listAdapter = new ListAdapter(this, stock.getListExerciceSelect());
//        activityListExo = new RecyclerListExercice();

        //cellule de test --------------------------------------
        // permet de voir si la liste demandé a bien un ajout d'element
        fab1 = findViewById(R.id.fab3);
        fab2 = findViewById(R.id.fab2);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Valeur indexList" + RecyclerListExercice.indexList ,Toast.LENGTH_SHORT).show();

//                Toast.makeText(getApplicationContext(),"afficher nb item : " + recyclerListExo.getListExerciceFaire().size() + " item Tempo : " + recyclerListExo.getListTempo().size(), Toast.LENGTH_SHORT).show();

//                if(stock.getListExerciceSelect().size() == 0){
//                    Toast.makeText(getApplicationContext(), "Valeur null",Toast.LENGTH_SHORT).show();
//                }else {
//                    Toast.makeText(getApplicationContext(), "Verifier taille du tableau : " + stock.getListExerciceSelect().size() +
//                            " item : " + stock.getListExerciceSelect().get(indexTest).titre +
//                            " second list : " + stock.getListExerciceTempo().size(), Toast.LENGTH_LONG).show();
//                }
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "taille " + RecyclerListExercice.listExoADefinir.size(),Toast.LENGTH_LONG).show();

//                Exercice exercice = new Exercice(titre, type, tempsChrono, image);
//                stock.ajoutItem(exercice);
//                indexTest++;

//                listAdapter.notifyDataSetChanged();
                /*
                 * le Toast ne fonctionne pas mais l'ajout d'objet dans la liste fonctionne
                 * on peut voir le resultat avec le 1er Toast qui lit le contenu
                 */
//                Toast.makeText(getApplicationContext(), "Ajouter contenu au tableau : "+ stock.getListExerciceSelect().get(stock.getListExerciceSelect().size()).titre, Toast.LENGTH_LONG).show();
            }
        });

        // fin de cellule de test -----------------------------


        /** afficher le fragment dans l'activite */
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        /** integrer le layout qui va representer le fragment
         * integrer la classe qui represente le fragment
         * inserer un tag
         */
        fragmentTransaction.add(R.id.idLayoutAdd, exerciceDefini, "fragmentExerciceDefini");
        fragmentTransaction.commit();

        transit();
        init();

        ajouterExo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * ajouterExo va permettre d'envoyer le contenu du fragment dans la liste du recycler
                 * et de retourner dans la liste presente
                 */


                /** envoie des informations sous forme d'intent à l'activité qui contient la liste
                 * à afficher
                 * incrementation de l'index
                 */
                RecyclerListExercice.indexList++;
                Intent intent = new Intent(getApplicationContext(), RecyclerListExercice.class);
//                Intent intent = new Intent(getApplicationContext(), RecyclerExo.class);

                intent.putExtra("envoieTitle", titre);
                intent.putExtra("envoieTypeSport", type);
                intent.putExtra("envoieTempsChrono", tempsChrono);
                intent.putExtra("envoieImage", image);

                startActivity(intent);

//                stock = new StockageExoFaire();
//                StockageExoFaire.index++;
//                StockageExoFaire.setIndex(StockageExoFaire.getIndex());

//                stock.ajoutItem(titre, type, tempsChrono, image);

//                Exercice exo = new Exercice(titre, type, tempsChrono, image);

//                recyclerListExo.addItemDistance(index, exo);
//                index++;

//                stock.ajoutItem(exo);
//                listTempo.add(listTempo.size(), exo);
//                stock = new StockageExoFaire(listTempo);

//                stock.setListExerciceSelect(listTempo);
//                stock = new StockageExoFaire(listTempo);

//                listAdapter.notifyDataSetChanged();
//                ArrayList<Exercice> listExercicetempo = new ArrayList<>();


//                Exercice exercice = new Exercice(titre, type, tempsChrono, image);
//                stock.ajoutItem(exercice);
//                RecyclerListExercice.indexList++;
//                listExercicetempo.add(RecyclerListExercice.indexList, exercice);
//                activityListExo.setListExoADefinir(listExercicetempo);

            }
        });
    }

    private  void init(){
        ajouterExo = (Button) findViewById(R.id.idButtonAjout);
    }

    public void transit(){
        /** receptionner l'intent du bouton de l'adapteur
         * seul l'activite arrive a recevoir le bundle de l'intent
         */
        Bundle bundle = getIntent().getExtras();
        titre = bundle.getString("title");
        type = bundle.getString("typeSport");
        tempsChrono = bundle.getLong("tempsChrono");
        image = bundle.getInt("image");


        /** argument sert de transporteur comme le bunble
         * l'argument permet d'envoyer les donnees vers un fragment
         * pour envoyer l'argument il ne faut pas oublier d'instancier l'objet (fragment) */
        exerciceDefini.setArguments(bundle);

        /** integrer le contenu du bouton dans un TextView
         * le textTest.setText(titre) de l'activite recoit bien l'info
         */
    }

//    public ArrayList<Exercice> getListTempo() {
//        return listTempo;
//    }
}
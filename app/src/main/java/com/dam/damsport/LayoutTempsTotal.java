package com.dam.damsport;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.UiThread;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Timer;
import java.util.TimerTask;

public class LayoutTempsTotal extends FragmentActivity {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    ExerciceDefini fragmentExo;

    //parti graphique
    private Button btPlay, btPause, btStop;
    private TextView textChrono;

    //chrono
    Timer temps = new Timer();
//    Runnable runnable = new Runnable() {
//        @Override
//        public void run() {
//
//        }
//    }
    private long initTime = System.currentTimeMillis();
    private Boolean isTrue = null;

    TimerTask timerTask = new TimerTask() {

        @Override
        public void run() {
            long duree = 0;
            while(isLaunch()) {

                /*
                System.currentTimeMillis() est un compteur de temps depuis le lancement de linux
                on soustrait cette valeur par lui meme en dehors de la methode
                 */
                duree = System.currentTimeMillis() - initTime ;

               /*
                apres 1000 millisecond il ajoute 1 seconde
                apres 60000 millisecond il ajoute 1 minute
                apres 3600000 millisecond il ajoute 1 heure
                 */
                int millis = (int) duree % 1000;
                int seconds = (int) (duree / 1000) % 60;
                int minutes = (int) (duree / 60000) % 60;
                int hours = (int) duree / 3600000;

                //reprendre selon les regles de l'arts a traiter dans le thread UI
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        textChrono.setText(Long.toString(hours)+":"+ Long.toString(minutes)+":"+
                                Long.toString(seconds)+":"+Long.toString(millis));
                    }
                });
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_temps_total);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        fragmentExo = new ExerciceDefini();


        addEtChargerFragment();

        init();


        btPlay.setOnClickListener(view -> {

            temps.schedule(timerTask, 0);
            isTrue = true;
            fragmentExo.start();

        });

        btPause.setOnClickListener(view -> {
            isTrue = false;
            fragmentExo.pause();
        });

        btStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isTrue = false;
                fragmentExo.stop();

            }
        });
    }

    private void addEtChargerFragment(){

        Fragment fragmentExo;
        fragmentExo = fragmentManager.findFragmentById(R.id.idDuFragActivity);

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentExo = fragmentManager.findFragmentByTag("fragExo");

        fragmentExo = new ExerciceDefini();
        fragmentTransaction.add(R.id.idDuFragActivity, fragmentExo, "fragExo");
        fragmentTransaction.commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        TextView textFrag = (TextView) findViewById(R.id.idTimerFrag);
        fragmentExo.setTextChronoFrag(textFrag);

    }

    private void init(){
        btPlay = (Button) findViewById(R.id.idLecture);
        btPause = (Button) findViewById(R.id.idPause);
        btStop = (Button) findViewById(R.id.idStop);

        textChrono = (TextView) findViewById(R.id.idTimer);
    }

    private Boolean isLaunch(){
        return isTrue;
    }


}
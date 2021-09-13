package com.dam.damsport;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.dam.damsport.Interface.ITimer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExerciceDefini#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExerciceDefini extends Fragment implements ITimer {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    View view;

    //partie graphique
    private TextView textTitre, textViewTimer, spinerType;
    private VideoView video;
    private ImageView image;


    /** tempsChrono doit recevoir le temps de la selection du recycler */
    private long tempsChrono = 0;
    private long tempsDuFragment;

    //Chrono
    private Timer decompte = new Timer();
    private Boolean isLancer(){
        return isTrain;
    }

    private Boolean isTrain = null;
    private long initTime = System.currentTimeMillis();

    TimerTask task = new TimerTask() {
        @Override
        public void run() {

            while(isLancer()) {

                /**
                System.currentTimeMillis() est un compteur de temps depuis le lancement de linux
                on soustrait cette valeur par lui meme en dehors de la methode
                 */
                tempsChrono = tempsDuFragment - (System.currentTimeMillis() - initTime);

               /**
                apres 1000 millisecond il ajoute 1 seconde
                apres 60000 millisecond il ajoute 1 minute
                apres 3600000 millisecond il ajoute 1 heure
                 */
                conversionChrono(tempsChrono);
            }
        }
    };


    public ExerciceDefini() {

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ExerciceDefini.
     */
    // TODO: Rename and change types and number of parameters
    public static ExerciceDefini newInstance(String param1, String param2) {
        ExerciceDefini fragment = new ExerciceDefini();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_exercice_defini, container, false);


        tempsDuFragment = getArguments().getLong("tempsChrono");

        /** on recupere non pas l'intent mais l'argument qui integre le bundle */
        String titreActivity = getArguments().getString("title");
        String typeActivity = getArguments().getString("typeSport");

        int imageActivity = getArguments().getInt("image");

        textTitre = (TextView) view.findViewById(R.id.idTextTitre);
        /** on alimente le TextView avec l'argument */
        textTitre.setText(titreActivity);

        spinerType = (TextView) view.findViewById(R.id.idSpinnerType);
        spinerType.setText(typeActivity);

        textViewTimer = (TextView) view.findViewById(R.id.idTimerFrag);
        conversionChrono(tempsDuFragment);

        video = (VideoView) view.findViewById(R.id.idVideoDef);

        image = (ImageView) view.findViewById(R.id.idImageFrag);
        image.setImageResource(imageActivity);

        return view;
    }

    @Override
    public void start() {
        decompte.schedule(task,0);
        isTrain = true;

    }

    @Override
    public void pause() {
        isTrain = false;
    }

    @Override
    public void stop() {
        isTrain = false;
    }

    @Override
    public void setTextChronoFrag(TextView tv) {
        textViewTimer = tv;
    }

    /** methode qui prend une valeur en long
     * @param tempsChrono
     * la transforme pour etre presentable dans le setText du chrono
     */
    private void conversionChrono(long tempsChrono){
        long millis = tempsChrono % 1000;
        long seconds = (tempsChrono / 1000) % 60;
        long minutes = (tempsChrono / 60000) % 60;
        long hours = tempsChrono / 3600000;

        textViewTimer.setText(Long.toString(hours)+":"+ Long.toString(minutes)+":"+
                Long.toString(seconds)+":"+Long.toString(millis));
    }
}
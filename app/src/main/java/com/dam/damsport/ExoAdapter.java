package com.dam.damsport;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExoAdapter extends RecyclerView.Adapter<ExoViewHolder> {

    private ArrayList<Exercice> listExo;
    private Context context;

    /**
     * Constructeur avec 2 paramètres le contexte, et la liste qui contient les exercices
     **/
    public ExoAdapter(Context context, ArrayList<Exercice> mesData) {
        this.context = context;
        this.listExo = mesData;

    }

    /**
     * Méthodes ajoutées automatiquement lors de la création de la classe
     *
     * @return */
    @NonNull
    @Override
    public ExoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /** Création du layout inflater dans le context où il est créé */
        LayoutInflater inflater = LayoutInflater.from(context);

        /** on va remplir layout avec notre custom layout 4 params
         * le fichier layout // la vue parent // à false pour ne pas être attaché à son parent
         * On va insérer cette inflater dans une view */
        View view = inflater.inflate(R.layout.item_recycler_exo, parent, false);

        /** comme ça on peut renvoyer la nouvelle vue - il faut l'instancier la vue en
         paramètre de MyRecyclerViewHolder vue que l'on est dans la méthode du MyRecyclerViewHolder **/
        return new ExoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExoViewHolder holder, int position) {
        /** On utilise object holder qui hérite de MyRecyclerViewHolder pour peupler nos
         items
         listExo prend ses elements de la liste de Stockage */
//        /** Ajout du texte **/
//        holder.titre.setText(titre[position]);
//        holder.typeExercice.setText(typeExercice[position]);
//        /** Ajout de l'image avec setImagesRessouces **/
//        holder.chrono.setText(Integer.toString(chrono[position]));
//        holder.media.setImageResource(media[position]);

        holder.titre.setText(listExo.get(position).titre);
        holder.typeExercice.setText(listExo.get(position).typeExercice);
        holder.chrono.setText(conversionChrono(listExo.get(position).chrono));
        holder.media.setImageResource(listExo.get(position).media);

        /** utilisation de position pour ajout dynamique
         * Ajout du listener sur tout le container (contenant) de notre viewHolder */

        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /** ajout d'un Intent pour passer à la seconde vue **/
                Intent intent = new Intent(context, Afficheur.class);

                /** on charge(envoie) l'intent avec le contenu du bundle */
                Bundle bundle = new Bundle();
                bundle.putString("title", listExo.get(position).titre);
                bundle.putString("typeSport", listExo.get(position).typeExercice);
                bundle.putLong("tempsChrono", listExo.get(position).chrono);
                bundle.putInt("image", listExo.get(position).media);
                intent.putExtras(bundle);

                /** on lance l'activité depuis le context en lui passant l'intent **/
                context.startActivity(intent);

//                afficheur = new Afficheur();
//                fragExercice = new ExerciceDefini();
//                stock = new StokageExercice();

//                afficheur.setTextTitreFrag(listExo.get(position).titre);
//                fragExercice.recevoirSetText(afficheur.envoieTitre(stock.getExoList().get(position).titre));



//                /** on envoie nos datas avec putextra la clé et la valeur à transmettre */
//                intent.putExtra("listTitres", stock.getExoList().get(position).titre);
//                intent.putExtra("listTypeExercice", stock.getExoList().get(position).typeExercice);
//                intent.putExtra("listChrono", stock.getExoList().get(position).chrono);
//                intent.putExtra("listMedia", stock.getExoList().get(position).media);

//                Toast.makeText(context, "position : "+ position + " donnees : "+
//                        listExo.get(position).typeExercice, Toast.LENGTH_LONG).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        /** Nombre d'item de la liste en comptant le nombre d'images avec lenght **/
        return listExo.size();
    }

    /** methode qui permet de convertir la variable en long en string pour l'integrer dans un setText */
    private String conversionChrono(long tempsChrono) {
        String resultat;

        long millis = tempsChrono % 1000;
        long seconds = (tempsChrono / 1000) % 60;
        long minutes = (tempsChrono / 60000) % 60;
        long hours = tempsChrono / 3600000;

        return resultat = (Long.toString(hours) + ":" + Long.toString(minutes) + ":" +
                Long.toString(seconds) + ":" + Long.toString(millis));
    }
}
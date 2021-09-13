package com.dam.damsport;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class ListAdapter extends RecyclerView.Adapter<ExoViewHolder> {

    private ArrayList<Exercice> exerciceSelect;
    private ArrayList<Exercice> exerciceOriginal;
    private Context context;

    public ListAdapter(Context context, ArrayList<Exercice> mesDatas){
        this.context = context;
        this.exerciceSelect = mesDatas;
        this.exerciceOriginal = mesDatas;
    }

    @NonNull
    @Override
    public ExoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_recycler_exo, parent, false);
        return new ExoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExoViewHolder holder, int position) {

        /** pareil que l'adapter des exo sauf qu'il y a un changement dans le clic par rpport a l'intent */
        holder.titre.setText(exerciceSelect.get(position).titre);
        holder.typeExercice.setText(exerciceSelect.get(position).typeExercice);
        holder.chrono.setText(conversionChrono(exerciceSelect.get(position).chrono));
        holder.media.setImageResource(exerciceSelect.get(position).media);

//        holder.titre.setText(exerciceOriginal.get(position).titre);
//        holder.typeExercice.setText(exerciceOriginal.get(position).typeExercice);
//        holder.chrono.setText(conversionChrono(exerciceOriginal.get(position).chrono));
//        holder.media.setImageResource(exerciceOriginal.get(position).media);

        exerciceOriginal.clear();
        exerciceOriginal.addAll(exerciceSelect);

//        exerciceSelect.clear();
//        exerciceSelect.addAll(RecyclerListExercice.listExoADefinir);

//        notifyDataSetChanged();

//        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(context, Afficheur.class);
//
//                Bundle bundle = new Bundle();
//                bundle.putString("title", exerciceSelect.get(position).titre);
//                bundle.putString("typeSport", exerciceSelect.get(position).typeExercice);
//                bundle.putLong("tempsChrono", exerciceSelect.get(position).chrono);
//                bundle.putInt("image", exerciceSelect.get(position).media);
//                intent.putExtras(bundle);
//
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return exerciceSelect.size();
    }

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

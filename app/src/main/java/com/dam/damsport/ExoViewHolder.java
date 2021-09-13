package com.dam.damsport;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class ExoViewHolder extends RecyclerView.ViewHolder {

    TextView titre, typeExercice, chrono;
    ImageView media;

    ConstraintLayout mainLayout;

    public ExoViewHolder(@NonNull View itemView) {
        super(itemView);
        /** Le contenu **/
        titre = itemView.findViewById(R.id.tv_titreExo);
        typeExercice = itemView.findViewById(R.id.tv_typeSport);
        chrono = itemView.findViewById(R.id.tv_temps);
        media = itemView.findViewById(R.id.iv_media);

        /** Le contenant **/
        mainLayout = itemView.findViewById(R.id.mainLayout);
    }

}



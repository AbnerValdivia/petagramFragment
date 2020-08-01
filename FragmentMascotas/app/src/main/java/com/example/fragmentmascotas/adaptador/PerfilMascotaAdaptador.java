package com.example.fragmentmascotas.adaptador;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentmascotas.R;
import com.example.fragmentmascotas.pojo.Mascota;

import java.util.ArrayList;

public class PerfilMascotaAdaptador extends RecyclerView.Adapter<PerfilMascotaAdaptador.PMViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfilMascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PerfilMascotaAdaptador.PMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.perfil_cardview_mascota, parent, false);
        int width = parent.getMeasuredWidth()/2;
        v.setMinimumWidth(width);

        return new PMViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PerfilMascotaAdaptador.PMViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvRating.setText(mascota.getRating());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PMViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvRating;
        private ImageView imgHueso;

        public PMViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto = itemView.findViewById(R.id.imgCVMascotaPerfil);
            tvRating = itemView.findViewById(R.id.tvRatingPerfil);
            imgHueso = itemView.findViewById(R.id.imgHuesoAmarillo);
        }
    }
}


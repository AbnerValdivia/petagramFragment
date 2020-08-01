package com.example.fragmentmascotas.adaptador;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentmascotas.R;
import com.example.fragmentmascotas.pojo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaAdaptador.MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaAdaptador.MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgFoto.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombre());
        holder.tvRating.setText(mascota.getRating());
        final int y[] = {Integer.parseInt(mascota.getRating())};
        holder.btnHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                y[0] += 1;
                Toast.makeText(activity,mascota.getNombre()+" ahora tiene "+y[0]+" puntos",Toast.LENGTH_SHORT).show();
                holder.tvRating.setText(Integer.toString(y[0]));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgFoto;
        private TextView tvNombre;
        private TextView tvRating;
        private ImageButton btnHueso;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFoto =itemView.findViewById(R.id.imgFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvRating = itemView.findViewById(R.id.tvRating);
            btnHueso = itemView.findViewById(R.id.btnHueso);
        }
    }
}

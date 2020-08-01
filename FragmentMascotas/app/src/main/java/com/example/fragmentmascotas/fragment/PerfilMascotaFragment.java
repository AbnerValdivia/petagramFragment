package com.example.fragmentmascotas.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentmascotas.GridSpacingItemDecoration;
import com.example.fragmentmascotas.R;
import com.example.fragmentmascotas.adaptador.PerfilMascotaAdaptador;
import com.example.fragmentmascotas.pojo.Mascota;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.ArrayList;

public class PerfilMascotaFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    CircularImageView imgFoto;
    TextView tvNombre;
    private RecyclerView rvMascotasFotos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfilmascota, container, false);
        rvMascotasFotos = v.findViewById(R.id.rvMascotaPerfil);
        imgFoto = v.findViewById(R.id.imgFotoPerfil);
        tvNombre = v.findViewById(R.id.tvNombrePerfil);

        //imgFoto.setCircleColor(Color.rgb(29,203,172));
        imgFoto.setBorderWidth(10f);
       // imgFoto.setBorderColor(Color.BLUE);
        imgFoto.setShadowEnable(true);

        rvMascotasFotos.addItemDecoration(new GridSpacingItemDecoration(3, 10, true));

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3, GridLayoutManager.VERTICAL, false);
        rvMascotasFotos.setLayoutManager(glm);
        InicializarMascotas();
        InicializarAdaptador();

        return v;
    }
    public void InicializarAdaptador(){
        PerfilMascotaAdaptador adaptador = new PerfilMascotaAdaptador(mascotas,getActivity());
        rvMascotasFotos.setAdapter(adaptador);
    }
    public void InicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"8"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"2"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"4"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"7"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"1"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"0"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"4"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"3"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"5"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"2"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"9"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"12"));
    }
}

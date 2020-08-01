package com.example.fragmentmascotas.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentmascotas.R;
import com.example.fragmentmascotas.adaptador.MascotaAdaptador;
import com.example.fragmentmascotas.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {
    ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvMascotas = v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        InicializarMascotas();
        InicializarAdaptador();

        return v;
    }
    public void InicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,getActivity());
        rvMascotas.setAdapter(adaptador);
    }
    public void InicializarMascotas(){
        mascotas = new ArrayList<>();

        mascotas.add(new Mascota(R.drawable.icons8_gorila_48,"Gorila","5"));
        mascotas.add(new Mascota(R.drawable.icons8_jaguar_negro_48,"Jaguar","2"));
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"Jake","8"));
        mascotas.add(new Mascota(R.drawable.icons8_perro_48,"Perro","12"));
        mascotas.add(new Mascota(R.drawable.icons8_gorila_48,"Gorila","5"));
        mascotas.add(new Mascota(R.drawable.icons8_jaguar_negro_48,"Jaguar","2"));

    }
}

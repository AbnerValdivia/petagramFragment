package com.example.fragmentmascotas;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentmascotas.adaptador.MascotaAdaptador;
import com.example.fragmentmascotas.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotasFavoritas;
    private Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        toolbar = findViewById(R.id.miActionBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvMascotasFavoritas = findViewById(R.id.rvMascotasFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotasFavoritas.setLayoutManager(llm);
        InicializarMascotas();
        InicializarAdaptador();

    }
    public void InicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        rvMascotasFavoritas.setAdapter(adaptador);
    }
    public void InicializarMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota(R.drawable.icons8_jake_48,"Jake M","8"));
        mascotas.add(new Mascota(R.drawable.icons8_perro_48,"Perro M","12"));
        mascotas.add(new Mascota(R.drawable.icons8_gorila_48,"Gorila M","5"));
        mascotas.add(new Mascota(R.drawable.icons8_jaguar_negro_48,"Jaguar M","2"));

    }
}
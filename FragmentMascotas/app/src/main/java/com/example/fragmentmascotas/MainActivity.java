package com.example.fragmentmascotas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fragmentmascotas.adaptador.PageAdapter;
import com.example.fragmentmascotas.fragment.PerfilFragment;
import com.example.fragmentmascotas.fragment.PerfilMascotaFragment;
import com.example.fragmentmascotas.fragment.RecyclerViewFragment;
import com.example.fragmentmascotas.pojo.Mascota;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        toolbar = findViewById(R.id.miActionBar);

        setUpViewPager();
        setSupportActionBar(toolbar);
       // getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemFav:
                Intent intentFavoritas =new Intent(this,MascotasFavoritas.class);
                startActivity(intentFavoritas);
                break;
            case R.id.itemContacto:
                Intent intentContacto = new Intent(this,Contacto.class);
                startActivity(intentContacto);
                break;
            case R.id.itemAcerca:
                Intent intentAcerca = new Intent(this,AcercaDe.class);
                startActivity(intentAcerca);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilMascotaFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.icons8_casa_100);
        tabLayout.getTabAt(1).setIcon(R.drawable.icons8_contactos_100);
    }
}

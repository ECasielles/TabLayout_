package com.example.usuario.tablayout;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    //Toolbar debe ser de librería support
    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        //Aquí nos muestra la toolbar con el nombre de la Activity
        setSupportActionBar(toolbar);
        viewPager = findViewById(R.id.vpgContent);
        //Se puebla con un Adapter personalizado de Fragments
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        tabLayout = findViewById(R.id.tabLayout);
    }


}

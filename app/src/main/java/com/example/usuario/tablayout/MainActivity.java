package com.example.usuario.tablayout;

import android.content.res.TypedArray;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * OPCION 1.- Crea un TabLayout de forma independiente al elemento ViewPager.
 * Para ello hay que implementar el listener del TabLayout y el
 * listener en ViewPager y vincularlos de forma que se actualice
 * el otro elemento.
 * OPCION 2.- Vincular el Tablayout al ViewPager con el método setupWithViewPager().
 * se debe cumplir ÚNICAMENTE el siguiente requisito:
 *
 *  * EL TÍTULO DE LAS PESTAÑAS DEL TAB SE INICIALIZAN MEDIANTE EL MÉTODO GETPAGETITLE  *
 *
 */
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

        /**
         * Configurar TabLayout:
         * 1.- Añadir el modo.
         * 2.- Añadir títulos.
         */
        tabLayout = findViewById(R.id.tabLayout);
        //Permite movimiento por pestañas
        //tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        //Añadir el título a las pestañas mediante un array.string
        for (String title: getResources().getStringArray(R.array.tabs)) {
            //tabLayout.addTab(tabLayout.newTab().setText(title));
            tabLayout.addTab(tabLayout.newTab());
        }
        /**
         * Configurar View Pager
         */
        ArrayList<String> titulos = new ArrayList<>();
        titulos.addAll(Arrays.asList(getResources().getStringArray(R.array.tabs)));
        viewPager = findViewById(R.id.vpgContent);
        //Se puebla con un Adapter personalizado de Fragments
        viewPager.setAdapter(new ViewPagerAdapter(
                getSupportFragmentManager(),
                tabLayout.getTabCount(),
                titulos
                )
        );
        viewPager.setPageTransformer(true, new DepthPageTransformer());

        //Opción 2
        tabLayout.setupWithViewPager(viewPager);
        //Personalizar las pestañas del TabLayout después del setupWithTabLayout
        setupTabIcons();


        //Opción 1
        /*
        //Se selecciona la pestaña
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //Se selecciona la página
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                tabLayout.setScrollPosition(position, 0f, true);
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        */

    }

    private void setupTabIcons() {
        TypedArray typedArrayIcons = getResources().obtainTypedArray(R.array.icons);
        for (int i = 0; i < tabLayout.getTabCount(); i++)
            tabLayout.getTabAt(i).setIcon(typedArrayIcons.getDrawable(i));
        typedArrayIcons.recycle();
    }

    @Override
    public void onBackPressed() {
        //Es uno de los pocos comportamientos correctos para tocar back
        if(viewPager.getCurrentItem() == 0)
            super.onBackPressed();
        else
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tab, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_show:
                Toast.makeText(this, getResources().getString(R.string.action_show), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_title:
                Toast.makeText(this, getResources().getString(R.string.action_title), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}

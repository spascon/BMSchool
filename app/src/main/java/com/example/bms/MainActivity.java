package com.example.bms;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.bms.entidades.TemaVo;
import com.example.bms.fragments.FragmentDetalleTema;
import com.example.bms.fragments.FragmentListaTema;
import com.example.bms.interfaces.IComunicaFragments;
import com.example.bms.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity  implements  FragmentListaTema.OnFragmentInteractionListener,
        FragmentDetalleTema.OnFragmentInteractionListener, IComunicaFragments {

    FragmentListaTema listaFragment;
    FragmentDetalleTema detalleFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Condicion para modo de pantalla
        if(findViewById(R.id.contenedorFragment)!= null){
            Utilidades.portatrait=true;
            if(savedInstanceState != null){
                return;
            }



            //Costructor
            listaFragment = new FragmentListaTema();

            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.contenedorFragment, listaFragment).commit();

        }
        else{
            Utilidades.portatrait=false;
        }



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void enviarTema(TemaVo tema) {

        detalleFragment= (FragmentDetalleTema)
                this.getSupportFragmentManager().findFragmentById(R.id.fragDetalle);

        if(detalleFragment !=null && findViewById(R.id.contenedorFragment)==null){
            detalleFragment.asignarInformacion(tema);

        }else{
            detalleFragment = new FragmentDetalleTema();
            Bundle bundleEnvio = new Bundle();
            bundleEnvio.putSerializable("objeto", tema);
            detalleFragment.setArguments(bundleEnvio);

            //Cargar fragment en activity
            getSupportFragmentManager().
                    beginTransaction().
                    replace(R.id.contenedorFragment, detalleFragment).addToBackStack(null).commit();

        }
    }
}

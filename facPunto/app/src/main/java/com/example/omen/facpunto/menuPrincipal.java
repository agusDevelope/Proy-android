package com.example.omen.facpunto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class menuPrincipal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    TextView tvNombre, tvCorreo, tvEmpresa;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        tvNombre= (TextView)findViewById(R.id.tv_Nombre);
        tvCorreo= (TextView)findViewById(R.id.tv_Correo);
        tvEmpresa= (TextView)findViewById(R.id.tv_Empresa);

        Bundle bundle = this.getIntent().getExtras();

        String nombre= bundle.getString("nombre");
        String correo= bundle.getString("email");
        String empresa= bundle.getString("empresa");
        Log.d("TUAPP", nombre);

        tvNombre.setText(nombre);
        tvCorreo.setText(correo);
        tvEmpresa.setText(empresa);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
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
            Intent i= new Intent(getApplicationContext(),config.class);
            startActivity(i);
        }
        if (id == R.id.action_acerca_de) {
            Intent i= new Intent(getApplicationContext(),acerca_de.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

       if (id == R.id.nav_begin) {
           Intent i= new Intent(getApplicationContext(),infoEmpresa.class);
           startActivity(i);

        } else if (id == R.id.nav_sold) {
           Intent i= new Intent(getApplicationContext(),ventasProductos.class);
           startActivity(i);

        } else if (id == R.id.nav_products) {
           Intent i= new Intent(getApplicationContext(),productos.class);
           startActivity(i);

        } else if (id == R.id.nav_sales) {
           Intent i= new Intent(getApplicationContext(),ventas.class);
           startActivity(i);

        } else if (id == R.id.nav_reports) {
           Intent i= new Intent(getApplicationContext(),reportes.class);
           startActivity(i);

        }else if (id == R.id.nav_exportImport) {
           Intent i= new Intent(getApplicationContext(),ExportarImportar.class);
           startActivity(i);


        }else if (id == R.id.nav_logout) {
           finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

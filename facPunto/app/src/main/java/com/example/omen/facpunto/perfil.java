package com.example.omen.facpunto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class perfil extends AppCompatActivity {
    TextView tvNombre, tvCorreo, tvEmpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
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

    }
}

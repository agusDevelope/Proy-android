package com.example.omen.facpunto;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class agregarProductos extends AppCompatActivity implements View.OnClickListener {
    Button btnAgregarProd;
    EditText etClave, etDescripcion, etPrecio, etExistencias, etCodBarras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_productos);

        etClave = (EditText) findViewById(R.id.etClave);
        etDescripcion = (EditText) findViewById(R.id.etDescripcion);
        etPrecio = (EditText) findViewById(R.id.etPrecio);
        etExistencias = (EditText) findViewById(R.id.etExistencias);
        etCodBarras = (EditText) findViewById(R.id.etCodBarras);


        btnAgregarProd = (Button) findViewById(R.id.btnAgregar);
        btnAgregarProd.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

            final int clave =Integer.parseInt( etClave.getText().toString());
            final String descripcion = etDescripcion.getText().toString();
            final float precio = Float.parseFloat(etPrecio.getText().toString());
            final int existencias = Integer.parseInt(etExistencias.getText().toString());
            final int codigo_barras = Integer.parseInt(etCodBarras.getText().toString());

            Response.Listener<String> respoListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        Log.d("TUAPP", response);

                        JSONObject jsonResponse = new JSONObject(response);
                        boolean success = jsonResponse.getBoolean("success");

                        if (success) {
                            Intent intent = new Intent(agregarProductos.this, listaProductos.class);
                            agregarProductos.this.startActivity(intent);

                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(agregarProductos.this);
                            builder.setMessage("Error al insertar producto").
                                    setNegativeButton("Reintentar", null).create().show();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            };

            AgregarRequest agregarRequest = new AgregarRequest(clave, descripcion, precio, existencias, codigo_barras, respoListener);
            RequestQueue queue = Volley.newRequestQueue(agregarProductos.this);
            queue.add(agregarRequest);


    }
}

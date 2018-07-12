package com.example.omen.facpunto;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class productos extends AppCompatActivity {
   Button añadir,verProd;
   /*TextView clave_producto, desc_producto,precio2,existencias1, codigo_barras2;*/

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);

      añadir =(Button)findViewById(R.id.activity_ibAñadir);//Aqui marca el error
      verProd=(Button)findViewById(R.id.activity_bBuscar);





       añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent añadir= new Intent(getApplicationContext(),agregarProductos.class);
                startActivity(añadir);
            }
        });


        verProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent verProd = new Intent(getApplicationContext(), listaProductos.class);
                startActivity(verProd);*/
               //Estos elementos no estan declarados, pero entonces de esta pantalla te manda al listado? si
                /*final int clave=Integer.parseInt(clave_producto.getText().toString());
                final String descripcion=desc_producto.getText().toString();
                final float precio=Float.parseFloat(precio2.getText().toString());
                final int existencias=Integer.parseInt(existencias1.getText().toString());
                final int codigo=Integer.parseInt(codigo_barras2.getText().toString());*/

                Response.Listener<String> respoListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            //Aqui es donde tendras todos tus productos, pero deberia estar en la otra pantalla, de momento lo dejamos asi
                            Log.d("TUAPP", response);

                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");

                            if(success){
                                Intent intent= new Intent(productos.this,listaProductos.class);
                                intent.putExtra("productos", jsonResponse.toString());
                                productos.this.startActivity(intent);

                            }else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(productos.this );
                                builder.setMessage("Error al registrarse").
                                        setNegativeButton("Reintentar",null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //Tu lista necesita esos parametros?? si, son los que comentaste arriba
                ListaRequest listaRequest = new ListaRequest(respoListener);
                RequestQueue queue= Volley.newRequestQueue(productos.this);
                queue.add(listaRequest);








            }

        });


    }
}

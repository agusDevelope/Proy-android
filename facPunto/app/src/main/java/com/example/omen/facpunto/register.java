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

public class register extends AppCompatActivity implements View.OnClickListener {
    Button btn_registrar;
    EditText etNombre,etApellidos,etEmpresa,etCorreo,etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etNombre=(EditText)findViewById(R.id.etNombre);
        etApellidos=(EditText)findViewById(R.id.etApellidos);
        etEmpresa=(EditText)findViewById(R.id.etEmpresa);
        etCorreo=(EditText)findViewById(R.id.etCorreo);
        etPassword=(EditText)findViewById(R.id.etPass);

        btn_registrar=(Button)findViewById(R.id.btnRegistrarUsu);
        btn_registrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final String nombre=etNombre.getText().toString();
        final String apellidos=etApellidos.getText().toString();
        final String empresa=etEmpresa.getText().toString();
        final String email=etCorreo.getText().toString();
        final String pass=etPassword.getText().toString();

        Response.Listener<String> respoListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.d("TUAPP", response);

                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success=jsonResponse.getBoolean("success");

                    if(success){
                        Intent intent= new Intent(register.this,login.class);
                        register.this.startActivity(intent);

                    }else{
                        AlertDialog.Builder builder= new AlertDialog.Builder(register.this );
                        builder.setMessage("Error al registrarse").
                                setNegativeButton("Reintentar",null).create().show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };

        RegisterRequest registerRequest = new RegisterRequest(nombre,apellidos,empresa,email,pass,respoListener);
        RequestQueue queue= Volley.newRequestQueue(register.this);
        queue.add(registerRequest);


    }
}

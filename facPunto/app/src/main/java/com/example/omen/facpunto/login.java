package com.example.omen.facpunto;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class login extends AppCompatActivity {
    TextView tv_reg;
    EditText etCorreo,etPassword;
    Button btn_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tv_reg=(TextView)findViewById(R.id.tv_registar);
        btn_log=(Button)findViewById(R.id.btnIniciar);
        etCorreo = (EditText)findViewById(R.id.etEmail);
        etPassword = (EditText)findViewById(R.id.etPass);

        tv_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             Intent i=new Intent(getApplicationContext(),register.class);
             startActivity(i);
            }
        });

        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String email= etCorreo.getText().toString();
                final String password = etPassword.getText().toString();
                Log.d("TUAPP", "PRESIONANDO INICIAR");
                Response.Listener<String> responseListener = new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("TUAPP", response);
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success=jsonResponse.getBoolean("success");
                            if(success){
                                String nombre= jsonResponse.getString("nombre");

                                String empresa= jsonResponse.getString("empresa");
                                Intent i= new Intent(login.this,menuPrincipal.class);
                                i.putExtra("nombre", nombre);
                                i.putExtra("email", email);
                                i.putExtra("empresa", empresa);

                                login.this.startActivity(i);


                            }else{
                                AlertDialog.Builder builder= new AlertDialog.Builder(login.this );
                                builder.setMessage("Error de logueo").
                                        setNegativeButton("Reintentar",null).create().show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                Log.d("TUAPP", email);
                Log.d("TUAPP", password);
                LoginRequest loginRequest = new LoginRequest(email,password,responseListener);
                RequestQueue queue= Volley.newRequestQueue(login.this);
                queue.add(loginRequest);

            }
        });
    }

}

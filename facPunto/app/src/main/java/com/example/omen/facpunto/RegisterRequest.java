package com.example.omen.facpunto;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Omen on 13/03/2018.
 */

public class RegisterRequest extends StringRequest {
    private static final String REGISTER_REQUEST_URL="http://192.168.1.70/factuwin/Register.php";
    private Map<String, String> params;
    public RegisterRequest(String nombre, String apellidos, String empresa, String email, String pass, Response.Listener<String> listener){
        super(Method.POST,REGISTER_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("nombre",nombre);
        params.put("apellidos",apellidos);
        params.put("empresa",empresa);
        params.put("email",email);
        params.put("password",pass);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

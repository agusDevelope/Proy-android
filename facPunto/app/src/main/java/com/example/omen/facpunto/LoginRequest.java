package com.example.omen.facpunto;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Omen on 13/03/2018.
 */

public class LoginRequest extends StringRequest {
    private static final String LOGIN_REQUEST_URL="http://192.168.1.70/factuwin/Login.php";
    private Map<String, String> params;
    public LoginRequest(String email, String pass, Response.Listener<String> listener){
        super(Method.POST, LOGIN_REQUEST_URL, listener, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error.getMessage());
            }
        });
        params=new HashMap<>();
        params.put("email",email);
        params.put("password",pass);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}

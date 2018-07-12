package com.example.omen.facpunto;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import java.util.HashMap;
import java.util.Map;

public class ListaRequest extends StringRequest {
    private static final String LISTA_REQUEST_URL="http://192.168.1.70/factuwin/productos.php";
    private Map<String, String> params;
    public ListaRequest(Response.Listener<String> listener){
        super(Method.POST,LISTA_REQUEST_URL,listener,null);
        params=new HashMap<>();

    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}

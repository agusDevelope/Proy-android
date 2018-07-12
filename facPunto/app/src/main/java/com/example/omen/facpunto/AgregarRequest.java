package com.example.omen.facpunto;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class AgregarRequest extends StringRequest {
    private static final String AGREGAR_REQUEST_URL="http://192.168.1.70/factuwin/agregarProductos.php";
    private Map<String, String> params;
    public AgregarRequest(int clave, String descripcion, float precio, int existencias, int codigo_barras, Response.Listener<String> listener){
        super(Method.POST,AGREGAR_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("clave_producto",clave+"");
        params.put("desc_producto",descripcion);
        params.put("precio",precio+"");
        params.put("existencias",existencias+"");
        params.put("codigo_barras",codigo_barras+"");
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }

}

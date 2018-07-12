package com.example.omen.facpunto;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class listaProductos extends AppCompatActivity {


    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        Bundle bundle = this.getIntent().getExtras();
        JSONObject productos_base = null;
        try {
            productos_base = new JSONObject(bundle.getString("productos"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        listView = (ListView)findViewById(R.id.lvProductos);
        final List<String> names = new ArrayList<String>();
        JSONArray json_array = productos_base.optJSONArray("productos");
        for (int i = 0; i < json_array.length(); i++) {
            try {
                names.add(json_array.getJSONObject(i).getString("clave_producto")+" - "+json_array.getJSONObject(i).getString("desc_producto")
                        +" - "+json_array.getJSONObject(i).getString("precio")+" - "+json_array.getJSONObject(i).getString("existencias")
                        +" - "+json_array.getJSONObject(i).getString("codigo_barras")); //creamos un objeto Fruta y lo insertamos en la lista
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        /*names.add("1111 Epura 600 ml 8.00  60 1236541");
        names.add("1234 coca 600 ml 12.00 800 123654789");
        names.add("1235 sabritas saladas 60g  11.00 60 13556568");
        names.add("1236 marias 80g 10.00 30 123654 ");
        names.add("1237 chocho chispas 80g 15.00 50 23548965");
        names.add("1238 Takis Fuego 80g 12.00 40 1236544");
        names.add("1240 Takis salsa brava 60g 12.00 100 12365848");
        names.add("1241 Pepsi 1lt 15.00 100 12365849");
        names.add("1242 Chocoroles 60g 14.00 1 12365850");
        names.add("1243 Gansito 40g 10.00 80 12365851 ");
        names.add("1244 Coca 3lt 35.00 60 12365847");*/




        ArrayAdapter<String> adapter =new ArrayAdapter<String >(this, android.R.layout.simple_expandable_list_item_1, names);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(listaProductos.this,"click"+names.get(position),Toast.LENGTH_LONG).show();

            }
        });
        AdaptadorProductos adaptadorProductos = new AdaptadorProductos(this, R.layout.listitem, names);
        listView.setAdapter(adaptadorProductos);


    }
}

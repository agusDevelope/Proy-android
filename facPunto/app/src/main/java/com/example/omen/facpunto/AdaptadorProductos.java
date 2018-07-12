package com.example.omen.facpunto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class AdaptadorProductos extends BaseAdapter{
    private Context context;
    private int layout;
    private List<String> names;

    public AdaptadorProductos (Context context, int layout, List<String> names){
        this.context =context;
        this.layout = layout;
        this.names  = names;
    }

    @Override
    public int getCount() {
        return this.names.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(R.layout.listitem, null);

            holder = new ViewHolder();

            holder.nameTextView = (TextView) convertView.findViewById(R.id.clave_producto);
            holder.nameTextView = (TextView) convertView.findViewById(R.id.desc_producto);
            holder.nameTextView = (TextView) convertView.findViewById(R.id.precio2);
            holder.nameTextView = (TextView) convertView.findViewById(R.id.existencias1);
            holder.nameTextView = (TextView) convertView.findViewById(R.id.codigo_barras2);
            convertView.setTag(holder);


        }else {
            holder = (ViewHolder)convertView.getTag();
        }

        View v =  convertView;

        LayoutInflater layoutInflater = LayoutInflater.from(this.context);
        v = layoutInflater.inflate(R.layout.listitem, null);

        String currentName = names.get(position);

        holder.nameTextView .setText(currentName);

        return convertView;
    }
    static class ViewHolder{
        private TextView nameTextView;
    }
}

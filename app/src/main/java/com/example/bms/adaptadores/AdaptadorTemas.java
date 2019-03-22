package com.example.bms.adaptadores;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bms.R;
import com.example.bms.entidades.TemaVo;

import java.util.ArrayList;

public class AdaptadorTemas extends
        RecyclerView.Adapter<AdaptadorTemas.TemasViewHolder> implements View.OnClickListener{


    ArrayList<TemaVo> listaTemas;
    private  View.OnClickListener listener;


    public AdaptadorTemas(ArrayList<TemaVo> listaTemas) {
        this.listaTemas = listaTemas;
    }

    @NonNull
    @Override
    public TemasViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null , false);
        view.setOnClickListener(this);
        return new TemasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TemasViewHolder temasViewHolder, int i) {
        temasViewHolder.txtTitulo.setText(listaTemas.get(i).getTitulo());
        temasViewHolder.txtInformacion.setText(listaTemas.get(i).getInfo());
        temasViewHolder.imagen.setImageResource(listaTemas.get(i).getImgID());

    }

    @Override
    public int getItemCount() {
        return listaTemas.size();
    }


    public  void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }


    @Override
    public void onClick(View v) {

        if(listener!=null){
            listener.onClick(v);
        }

    }

    public class TemasViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitulo, txtInformacion;
        ImageView imagen;

        public TemasViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitulo = (TextView) itemView.findViewById(R.id.idTitulo);
            txtInformacion = (TextView) itemView.findViewById(R.id.idInfo);
            imagen = (ImageView) itemView.findViewById(R.id.idImagen);
}}}

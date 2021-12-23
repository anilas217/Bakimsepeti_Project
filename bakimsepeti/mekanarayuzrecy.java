package com.example.roko;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class mekanarayuzrecy extends RecyclerView.Adapter<mekanarayuzrecy.MyviewHolder4> {

    Context context;
    ArrayList<yazilacakmusteriler> yazmus;
    public mekanarayuzrecy(Context c,ArrayList<yazilacakmusteriler> ym){
        context=c;
        yazmus=ym;
    }



    @NonNull
    @Override
    public MyviewHolder4 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyviewHolder4(LayoutInflater.from(context).inflate(R.layout.mekanarayuzrecycler,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder4 holder, int position) {
holder.geleceksaat.setText(yazmus.get(position).getGeliceksaat());
holder.isimsoy.setText(yazmus.get(position).getIsimsoy());
holder.telno.setText(yazmus.get(position).getTelno());
holder.islem.setText(yazmus.get(position).getIslem());
    }

    @Override
    public int getItemCount() {
        return yazmus.size();
    }

    class MyviewHolder4 extends RecyclerView.ViewHolder{

TextView isimsoy,telno,islem,geleceksaat;

        public MyviewHolder4(@NonNull View itemView) {
            super(itemView);

            isimsoy=(TextView)itemView.findViewById(R.id.isimsoy);
            telno=(TextView)itemView.findViewById(R.id.telno);
            islem=(TextView)itemView.findViewById(R.id.islem);
            geleceksaat=(TextView)itemView.findViewById(R.id.geliceksaat);

        }
    }
}

package com.example.roko;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class customerselecttime extends RecyclerView.Adapter<customerselecttime.MyViewHolder5> {
    String TAG;
    Context context;
    ArrayList<Secilebilecekzamanlar> seczaman=new ArrayList<>();
    public customerselecttime(Context c,ArrayList<Secilebilecekzamanlar> S){
        context= c;
        seczaman = S;
    }
    @NonNull
    @Override
    public MyViewHolder5 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder5(LayoutInflater.from(context).inflate(R.layout.musaitzamanaralik,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder5 holder, int position) {
     holder.baslangic.setText( seczaman.get(position).getGiris()+"----->");
     holder.bitis.setText( seczaman.get(position).getCikis());
    }

    @Override
    public int getItemCount() {
        return seczaman.size();
    }

    class MyViewHolder5 extends RecyclerView.ViewHolder {

        TextView baslangic,bitis;
        public MyViewHolder5(@NonNull View itemView) {
            super(itemView);
            baslangic=(TextView)itemView.findViewById(R.id.baslangicsaati);
            bitis=(TextView)itemView.findViewById(R.id.bitissaati);
        }
    }
}

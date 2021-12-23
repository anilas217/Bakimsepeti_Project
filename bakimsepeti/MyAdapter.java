package com.example.roko;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
String TAG;
    Context context;
    ArrayList<Profile> profiles;


    public MyAdapter(Context c,ArrayList<Profile> p){
        context = c;
        profiles =  p;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.telno.setText(profiles.get(position).getTelno());
    holder.puan.setText(profiles.get(position).getPuan());
    holder.calisanisim.setText(profiles.get(position).getCalisanisim());
    holder.mekanisim.setText(profiles.get(position).getMekanisim());
    holder.mekanadresi.setText(profiles.get(position).getMekanadresi());
   // Picasso.get().load(profiles.get(position).getProfilepic()).into(holder.profilepic);
    holder.onClick(position);
    }

    @Override
    public int getItemCount() {
        return profiles.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mekanisim,telno,mekanadresi,calisanisim,puan;
        ImageView profilepic;
        Button btn;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mekanisim=itemView.findViewById(R.id.mekanisim);
            telno=itemView.findViewById(R.id.telno);
            mekanadresi=itemView.findViewById(R.id.mekanisim);
            calisanisim=itemView.findViewById(R.id.calisanisim);
            puan=itemView.findViewById(R.id.puan);
            profilepic=itemView.findViewById(R.id.profilpic);
            btn=itemView.findViewById(R.id.tamam);
        }
        public void onClick(final int position){
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String idesi=profiles.get(position).getIdesi();
                    Context context = v.getContext();
                    Intent intentalaq = new Intent(context, Tiklanmaolursaeger.class);
                    intentalaq.putExtra("idisi",idesi);
                    context.startActivity(intentalaq);

                }
            });
        }
    }


}

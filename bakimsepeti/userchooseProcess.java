package com.example.roko;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class userchooseProcess extends RecyclerView.Adapter<userchooseProcess.MyViewHolder3> {
String TAG;
    Context context;
    ArrayList<Normalislemlerclassi> CheckedPlayers=new ArrayList<>();
    ArrayList<Normalislemlerclassi> normalislemlerclassis=new ArrayList<>();
    public userchooseProcess(Context c,ArrayList<Normalislemlerclassi> n){
        context= c;
        normalislemlerclassis = n;
    }

    @NonNull
    @Override
    public MyViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder3(LayoutInflater.from(context).inflate(R.layout.userprocess,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder3 holder, final int position) {
        holder.işlem.setText(normalislemlerclassis.get(position).getIşlemintürü());
        holder.fiyat.setText(normalislemlerclassis.get(position).getFiyati()+" Tl");
        holder.sure.setText(normalislemlerclassis.get(position).getSüresi()+" Dakika");
        holder.işlem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox chk=(CheckBox) v;
                if(chk.isChecked()){

                    CheckedPlayers.add(normalislemlerclassis.get(position));

                }
                else if(!(chk.isChecked())){
                    CheckedPlayers.remove(normalislemlerclassis.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return normalislemlerclassis.size();
    }

    class MyViewHolder3 extends RecyclerView.ViewHolder
    {
        CheckBox işlem;
        TextView fiyat,sure;

        public MyViewHolder3(@NonNull View itemView) {
            super(itemView);
            işlem=(CheckBox)itemView.findViewById(R.id.Yapilanisi);
            fiyat=(TextView)itemView.findViewById(R.id.Fiyatı);
            sure=(TextView)itemView.findViewById(R.id.Suresi);

        }
    }
}



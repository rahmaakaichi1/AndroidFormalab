package com.example.myexpenses;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter {

    private ArrayList<Expense> array ;
    private Context context ;
    private int item ;


    public Adapter( @NonNull Context context, int resource,ArrayList<Expense> array) {
        super(context, resource,array);
        this.array= array ;
        this.context=context ;
        this.item= resource ;
    }

    @NonNull
    @Override
    public  boolean isEnabled(int position){return true;}
    @Override
    public View getView(int position , @Nullable View convertView, @NonNull ViewGroup parent){
        convertView = LayoutInflater.from(context).inflate(item,parent,false);
        TextView expense = convertView.findViewById(R.id.expense);
        TextView price = convertView.findViewById(R.id.price);



        expense.setText(array.get(position).getName());
        price.setText(Float.valueOf(array.get(position).getPrice()).toString());

        return  convertView;
    }


}

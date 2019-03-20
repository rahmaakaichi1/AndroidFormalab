package com.example.myexpenses;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ShowExpense extends AppCompatActivity {

    ListView mylistview ;
    ArrayList<Expense> arraylist;
    Adapter arrayadapter;
    public static DataBaseAdapter db ;
    ArrayList<Expense> arrayList ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_expense);
        db= new DataBaseAdapter(this);
        mylistview =(ListView) findViewById(R.id.liste);
        arrayList = db.DisplayExpense();
        arrayadapter = new Adapter(this , R.layout.item,arrayList);

        mylistview.setAdapter(arrayadapter);
     //   Toast.makeText(this," number "+Integer.toString(arrayList.size()) , Toast.LENGTH_LONG).show();
        mylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){
                new AlertDialog.Builder(ShowExpense.this)
                        .setTitle("Delete entry")
                        .setMessage("Are you sure you want to delete this item?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                db.deleteExpense(arrayList.get(position).getId());
                                arrayList=db.DisplayExpense();

                                arrayadapter = new Adapter(ShowExpense.this , R.layout.item,arrayList);

                                mylistview.setAdapter(arrayadapter);
                                Toast.makeText(ShowExpense.this, "deleted", Toast.LENGTH_SHORT).show(); }})
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }

        }     );




    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true ;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId() == R.id.add){
            Intent intent = new Intent(ShowExpense.this,MainActivity.class);
            startActivity(intent);

        }
        if(item.getItemId() == R.id.total){
            Intent intent = new Intent(ShowExpense.this , Total.class);
            startActivity(intent);
        }
        return  true ;
    }

    @Override
    public void onResume(){
        super.onResume();
        // put your code here...
           arrayList = db.DisplayExpense();
        arrayadapter = new Adapter(this , R.layout.item,arrayList);

        mylistview.setAdapter(arrayadapter);
    }



}
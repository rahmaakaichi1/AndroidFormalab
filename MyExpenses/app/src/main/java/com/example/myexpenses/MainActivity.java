package com.example.myexpenses;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.example.myexpenses.ShowExpense.db;

public class MainActivity extends AppCompatActivity {



    Button btn ;
    EditText name , price ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Expense.total= 0d;

        name =findViewById(R.id.expense);
        price=findViewById(R.id.price);

        btn=findViewById(R.id.add);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Expense e = new Expense(name.getText().toString(),Float.valueOf(price.getText().toString()));

                db.addExpense(e);
               Toast.makeText(MainActivity.this," Expense Added!" , Toast.LENGTH_LONG).show();
            }
        });

    }
}
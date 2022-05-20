package com.example.aplikasia_pa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    TextView textView;
    int hari, bulan, tahun;
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView listView;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Calendar calendar = Calendar.getInstance();

        hari = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
        bulan = Calendar.getInstance().get(Calendar.MONTH);
        tahun = Calendar.getInstance().get(Calendar.YEAR);

        String finalTanggal = hari + "/" + bulan + "/" + tahun;


        TextView textView =(TextView) findViewById(R.id.tanggal);
        textView.setText(finalTanggal);

        listView = findViewById(R.id.listView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addItem(view);
            }

        });

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(itemsAdapter);
        setUpListviewListener();
    }
        private void setUpListviewListener() {

            listView.setOnItemLongClickListener( new AdapterView.OnItemLongClickListener() {
                @Override
                public boolean onItemLongClick(AdapterView<?> parent, View view, int i, long l) {
                    Context context = getApplicationContext();
                    Toast.makeText(context, "Finished", Toast.LENGTH_LONG).show();
                    items.remove(i);
                    itemsAdapter.notifyDataSetChanged();
                    return true;
                }


            });
        }
        private void addItem(View view){

        EditText input = findViewById(R.id.editText);
        String itemText = input.getText().toString();

        if (!(itemText.equals(""))){
            itemsAdapter.add(itemText);
            input.setText("");

        }else{
            Toast.makeText(getApplicationContext(), "Input Activity Today", Toast.LENGTH_SHORT).show();
        }
    }

}


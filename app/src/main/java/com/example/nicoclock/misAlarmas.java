package com.example.nicoclock;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class misAlarmas extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;
    public  ArrayList <String> names = new ArrayList<>();

    private String [] nombres = {""+ajustar_alarma.ajuste};


    private String edades [] = {"15","24"};

    private Button btn1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_alarmas);
        btn1 =(Button)findViewById(R.id.mis_alarmas_btn1) ;
        lv1 = (ListView)findViewById(R.id.mis_alarmas_lv1);



        //ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_alarmas, nombres);

        MyAdapter adapter = new MyAdapter(this, nombres);

        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view, ""+lv1.getItemAtPosition(position), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
               // Toast.makeText(misAlarmas.this, ""+lv1.getItemIdAtPosition(position),Toast.LENGTH_SHORT).show();
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(misAlarmas.this,ajustar_alarma.class);
                startActivity(i);
            }
        });
    }



    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];

        int rImgs;

        MyAdapter (Context c, String title[]) {
            super(c, R.layout.list_item_alarmas,    R.id.textView, nombres);
            this.context = c;
            this.rTitle = title;
            this.rImgs =   R.drawable.despertador;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.list_item_alarmas, parent, false);
            ImageView images = row.findViewById(R.id.image1);

            TextView myTitle = row.findViewById(R.id.item);


            // now set our resources on views
            images.setImageResource(rImgs);
            myTitle.setText(rTitle[position]);





            return row;
        }
    }

}



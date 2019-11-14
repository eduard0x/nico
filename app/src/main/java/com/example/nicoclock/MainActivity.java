package com.example.nicoclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        btn1 = (Button)findViewById(R.id.main_btn1);
        btn2 = (Button)findViewById(R.id.main_btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        entrar();
                                    }
                                    });
                btn2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        registrar();
                    }
                });



    }

    public void registrar (){
        Intent a = new Intent(this,registro.class);
        startActivity(a);
        finish();
    }

    public void entrar(){
        Intent a = new Intent(this,alarmas.class);
        startActivity(a);
        finish();
    }
}

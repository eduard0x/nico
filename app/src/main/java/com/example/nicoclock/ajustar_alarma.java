package com.example.nicoclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;


public class ajustar_alarma extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private Button btn1;
    private TextView tv1;
    public static  String ajuste = "00:00 am";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajustar_alarma);

        btn1 = (Button)findViewById(R.id.ajustar_btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker = new TimePickerFragment();
                timepicker.show(getSupportFragmentManager(),"time Picker");

            }
        });
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        tv1 = (TextView)findViewById(R.id.ajustar_tv1);
        tv1.setText("Hora: "+hourOfDay+" Minuto: "+minute+ "Jornado :");
        ajuste = hourOfDay+":"+minute;
        Intent i = new Intent(ajustar_alarma.this,misAlarmas.class);
        startActivity(i);
        finish();
    }
}

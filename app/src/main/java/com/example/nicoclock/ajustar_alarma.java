package com.example.nicoclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.Calendar;


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
        int hora = hourOfDay;
        int minuto = minute;

        long milisegundos = hora * 3600000 + minuto* 60000;
        ajuste = hourOfDay+":"+minute;
        setAlarm(milisegundos);
        Intent i = new Intent(ajustar_alarma.this,misAlarmas.class);
        startActivity(i);
        finish();
    }

    public void setAlarm(long milisegundos){
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(this,myAlarm.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,i,0);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,milisegundos,AlarmManager.INTERVAL_DAY,pendingIntent);

        Toast.makeText(this,"La alarma ha sido ajustada", Toast.LENGTH_SHORT).show();
    }
}

package com.example.nicoclock;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class alarma2 extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {
    private TimePickerFragment timepicker;
    private TimePicker time;
    public static  String ajuste = "00:00 am";
    private Button btn3, btn4;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_alarma2);
        getSupportActionBar().hide();
        tv1 = (TextView)findViewById(R.id.alarmas2_tv1);

        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timepicker = new TimePickerFragment();
                timepicker.show(getSupportFragmentManager(),"time Picker");
            }
        });


        btn3 = (Button)findViewById(R.id.alarmas2_btnAjustar);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar =  Calendar.getInstance();

                if(Build.VERSION.SDK_INT >= 23){
                    calendar.set(
                            calendar.get(Calendar.YEAR),
                            calendar.get(Calendar.MONTH),
                            calendar.get(Calendar.DAY_OF_MONTH)


                    );
                }else{

                }
            }
        });

    }

    public void setAlarm(long milisegundos){
        AlarmManager alarmManager = (AlarmManager)getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(this,myAlarm.class);

        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,i,0);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,milisegundos,AlarmManager.INTERVAL_DAY,pendingIntent);

        Toast.makeText(this,"La alarma ha sido ajustada", Toast.LENGTH_SHORT).show();
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
        Intent i = new Intent(alarma2.this,misAlarmas.class);
        startActivity(i);
        finish();
    }
}

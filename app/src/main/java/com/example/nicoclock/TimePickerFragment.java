package com.example.nicoclock;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment{

    Calendar calendar = Calendar.getInstance();
    long milis = calendar.getTimeInMillis();
    int hora = calendar.get(Calendar.HOUR_OF_DAY);
    int minuto = calendar.get(Calendar.MINUTE);
    int jornada = calendar.get(Calendar.AM_PM);


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return new TimePickerDialog(getActivity(),(TimePickerDialog.OnTimeSetListener)getActivity(),hora,minuto, DateFormat.is24HourFormat(getActivity()));
    }
}

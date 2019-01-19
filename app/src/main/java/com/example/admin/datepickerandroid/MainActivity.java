package com.example.admin.datepickerandroid;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DatePickerDialog.OnDateSetListener mOnDateSetListener;
    int year;
    int month;
    int dayOfMonth;
    Calendar calendar;

    private TextView tvSelectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSelectedDate = (TextView)findViewById(R.id.tvSelectedDate);

        tvSelectedDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    calendar = Calendar.getInstance();
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    year = calendar.get(Calendar.YEAR);
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    month = calendar.get(Calendar.MONTH);
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                }

                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        android.R.style.Theme_DeviceDefault_Dialog,
                        mOnDateSetListener,
                        year,month,dayOfMonth
                );
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });

        mOnDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month +1;
                String date = month + "/" + dayOfMonth + "/" + year;
                tvSelectedDate.setText(date);
            }
        };


    }
}

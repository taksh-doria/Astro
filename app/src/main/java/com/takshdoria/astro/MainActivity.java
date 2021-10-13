package com.takshdoria.astro;

import android.app.DatePickerDialog;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import de.hdodenhof.circleimageview.CircleImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    final Calendar myCalendar = Calendar.getInstance();
    private EditText birthdate;
    AstroCalc astro=new AstroCalc();
    private Button submit;
    private ProgressBar progressBar;
    private CircleImageView imageView;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        birthdate=(EditText) findViewById(R.id.birthdate);
        submit=(Button) findViewById(R.id.submit);
        progressBar=(ProgressBar)findViewById(R.id.progressBar);
        imageView=(CircleImageView)findViewById(R.id.title_image);
        imageView.setImageDrawable(getDrawable(R.drawable.astrology));
        progressBar.setVisibility(View.GONE);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(birthdate.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Enter a valid birthdate",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    progressBar.setVisibility(View.VISIBLE);
                    System.out.println(birthdate.getText().toString());
                    String dates[]=birthdate.getText().toString().split("/");
                    System.out.println(astro.getZodiacSign(Integer.parseInt(dates[1]),Integer.parseInt(dates[0])));
                    BackgroudTask task=new BackgroudTask();
                    task.context=MainActivity.this;
                    task.bar=progressBar;
                    task.execute(astro.getZodiacSign(Integer.parseInt(dates[1]),Integer.parseInt(dates[0])));
                }
            }
        });

        DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }
        };

        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                DatePickerDialog dialog=new DatePickerDialog(MainActivity.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH));
                dialog.getDatePicker().setMaxDate(new Date().getTime());
                dialog.show();
            }
        });
    }
    // set date to edittext
    private void updateLabel() {
        String myFormat = "MM/dd/yy";
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        birthdate.setText(sdf.format(myCalendar.getTime()));
    }
}
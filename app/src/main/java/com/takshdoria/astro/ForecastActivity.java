package com.takshdoria.astro;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.takshdoria.astro.model.Forecast;
import de.hdodenhof.circleimageview.CircleImageView;

public class ForecastActivity extends AppCompatActivity {

    private TextView sign;
    private TextView date;
    private TextView description;
    private TextView mood;
    private TextView compatibility;
    private TextView color;
    private TextView number;
    private TextView time;
    private Button button;
    private CircleImageView imageView;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forecast_layout);
        sign=(TextView)findViewById(R.id.sign);
        date=(TextView) findViewById(R.id.date);
        description=(TextView) findViewById(R.id.description);
        mood=(TextView) findViewById(R.id.mood);
        compatibility=(TextView) findViewById(R.id.compatibility);
        color=(TextView)findViewById(R.id.color);
        time=(TextView)findViewById(R.id.lucky_time);
        number=(TextView)findViewById(R.id.lucky_number);
        button=(Button)findViewById(R.id.close);
        imageView=(CircleImageView)findViewById(R.id.zodiac_sign);
        Intent intent=getIntent();
        sign.setText(intent.getStringExtra("sign"));
        date.setText(intent.getStringExtra("current_date"));
        description.setText(intent.getStringExtra("description"));
        mood.setText(Html.fromHtml("<br>Mood: </br>"+intent.getStringExtra("mood")));
        compatibility.setText(Html.fromHtml("<br>Compatibility: </br>"+intent.getStringExtra("compatiblity")));
        color.setText(Html.fromHtml("Color: "+intent.getStringExtra("color")));
        number.setText("Lucky Number: "+intent.getStringExtra("lucky_number"));
        time.setText("Lucky Time: "+intent.getStringExtra("lucky_time"));
        switch (sign.getText().toString().toLowerCase())
        {
            case "aries":
                imageView.setImageDrawable(getDrawable(R.drawable.aries));
                break;
            case "taurus":
                imageView.setImageDrawable(getDrawable(R.drawable.aries));
                break;
            case "gemini":
                imageView.setImageDrawable(getDrawable(R.drawable.gemini));
                break;
            case "cancer":
                imageView.setImageDrawable(getDrawable(R.drawable.cancer));
                break;
            case "leo":
                imageView.setImageDrawable(getDrawable(R.drawable.leo));
                break;
            case "virgo":
                imageView.setImageDrawable(getDrawable(R.drawable.virgo));
                break;
            case "libra":
                imageView.setImageDrawable(getDrawable(R.drawable.libra));
                break;
            case "scorpio":
                imageView.setImageDrawable(getDrawable(R.drawable.scorpio));
                break;
            case "sagittarius":
                imageView.setImageDrawable(getDrawable(R.drawable.sagittarius));
                break;
            case "capricorn":
                imageView.setImageDrawable(getDrawable(R.drawable.capricorn));
                break;
            case "aquarius":
                imageView.setImageDrawable(getDrawable(R.drawable.aquarius));
                break;
            case "pisces":
                imageView.setImageDrawable(getDrawable(R.drawable.pisces));
                break;
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });



    }
}

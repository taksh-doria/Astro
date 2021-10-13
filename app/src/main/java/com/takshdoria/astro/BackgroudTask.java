package com.takshdoria.astro;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import com.takshdoria.astro.model.Forecast;
import org.json.JSONException;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class BackgroudTask extends AsyncTask<String,Integer,String> {
    public Context context;
    public ProgressBar bar;
    public String sign;
    @Override
    protected String doInBackground(String... strings)
    {
        try {
            sign=strings[0];
            URL url=new URL("https://aztro.sameerkumar.website/?sign="+strings[0].toLowerCase()+"&day=today");
            HttpURLConnection connection=(HttpURLConnection) url.openConnection();
            //connection.setRequestProperty("sign","aries");
            //connection.setRequestProperty("day","today");
            connection.setRequestMethod("POST");
            connection.connect();
            InputStream stream=connection.getInputStream();
            BufferedReader reader=new BufferedReader(new InputStreamReader(stream));
            String line="";
            StringBuilder builder=new StringBuilder();
            while ((line=reader.readLine())!=null)
            {
                builder.append(line);
            }
            String data=builder.toString();
            reader.close();
            return  data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String data) {
        if(data!=null)
        {
            System.out.println(data);
            try {
                Forecast forecast=new Forecast();
                JSONObject object=new JSONObject(data);
                forecast.setCurrent_date(object.getString("current_date"));
                forecast.setDescription(object.getString("description"));
                forecast.setCompatibility(object.getString("compatibility"));
                forecast.setMood(object.getString("mood"));
                Intent intent=new Intent(context,ForecastActivity.class);
                intent.putExtra("sign",sign);
                intent.putExtra("current_date",forecast.getCurrent_date());
                intent.putExtra("description",forecast.getDescription());
                intent.putExtra("compatiblity",forecast.getCompatibility());
                intent.putExtra("mood",forecast.getMood());
                intent.putExtra("color",object.getString("color"));
                intent.putExtra("lucky_number",object.getString("lucky_number"));
                intent.putExtra("lucky_time",object.getString("lucky_time"));
                bar.setVisibility(View.GONE);
                context.startActivity(intent);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }
}

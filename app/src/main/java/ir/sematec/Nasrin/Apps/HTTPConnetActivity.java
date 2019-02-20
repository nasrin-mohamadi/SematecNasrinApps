package ir.sematec.Nasrin.Apps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPConnetActivity extends AppCompatActivity {

    TextView txtSunrise;
    TextView txtAsr;
    TextView txtMaghreb;
    TextView txtIsha;
    TextView txtFajr;
    TextView txtSunset;
    TextView txtImsak;
    TextView txtMidnight;
    TextView txtDhuhr;
    Button btnShow;
    String m1;
    String m2;
    String m3;
    String m4;
    String m5;
    String m6;
    String m7;
    String m8;
    String responsBuff;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_httpconnet);

        final String url = "http://api.aladhan.com/v1/timingsByCity?city=tehran&country=Iran&method=8";

        txtSunrise = findViewById(R.id.txtSunrise);
        txtAsr=findViewById(R.id.txtAsr);
        txtDhuhr=findViewById(R.id.txtDhuhr);
        txtMaghreb=findViewById(R.id.txtMaghreb);
        txtFajr=findViewById(R.id.txtFajr);
        txtSunset=findViewById(R.id.txtSunset);
        txtImsak=findViewById(R.id.txtImsak);
        txtMidnight=findViewById(R.id.txtMidnight);
        btnShow=findViewById(R.id.btnShowTimes);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            URL obj = new URL(url);

                            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

                            con.setRequestMethod("GET");

                            con.setRequestProperty("User-Agent", "Mozilla/5.0");

                            int responseCode = con.getResponseCode();

                            if (responseCode == HttpURLConnection.HTTP_OK) {

                                BufferedReader in = new BufferedReader(new InputStreamReader(
                                        con.getInputStream()));

                                String inputLine;
                                StringBuffer response = new StringBuffer();
                                while ((inputLine = in.readLine()) != null) {
                                    response.append(inputLine);
                                }

                                responsBuff=response.toString();


                             //   System.out.println(response.toString());


                                JSONObject object = new JSONObject(response.toString());
                                String s = object.getString("data");
                                JSONObject object1 = new JSONObject(s);
                                String s1 = object1.getString("timings");
                                JSONObject object2 = new JSONObject(s1);

                                m1= ( object2.getString("Maghrib"));
                                m2=(object2.getString("Sunrise"));
                                m3=(object2.getString("Fajr"));
                                m4=(object2.getString("Sunset"));
                                m5=(object2.getString("Dhuhr"));
                                m6=(object2.getString("Isha"));
                                m7=(object2.getString("Imsak"));
                                m8=(object2.getString("Midnight"));


                                Log.d("MAGHRIB",s1);

                            }

                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                txtMaghreb.setText(m1);
                                txtSunrise.setText(m2);
                                txtFajr.setText(m3);
                                txtSunset.setText(m4);
                                txtDhuhr.setText(m5);
                                txtIsha.setText(m6);
                                txtImsak.setText(m7);
                                txtMidnight.setText(m8);
                            }
                        });



                    }
                }).start();
            }
        });



    }
}

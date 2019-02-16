package ir.sematec.Nasrin.Apps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConnectionActivity extends AppCompatActivity {

    TextView txtSunrise;
    TextView txtAsr;
    TextView txtMaghreb;
    TextView edtCityName;
    String CityTimesURL;
    Button btnShowTimes;

    static final String TimesURL = "http://api.aladhan.com/v1/timingsByCity?city=";
    static final String CountryName = "&country=Iran&method=8";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http_connection);

        txtSunrise = findViewById(R.id.txtSunrise);
        txtAsr=findViewById(R.id.txtAsr);
        txtMaghreb=findViewById(R.id.txtMaghreb);
        btnShowTimes=findViewById(R.id.btnShowTimes);

        btnShowTimes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        try {
                            CityTimesURL = TimesURL + edtCityName.getText()  + CountryName;
                            URL obj = new URL(CityTimesURL);

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

                                JSONObject objResponse = new JSONObject(response.toString());
                                String strData = objResponse.getString("data");
                                JSONObject objData = new JSONObject(strData);
                                String strTimings = objData.getString("timings");
                                JSONObject objTimings = new JSONObject(strTimings);
                                txtSunrise.setText(objTimings.getString("Sunrise"));
                                txtAsr.setText(objTimings.getString("Asr"));
                                txtMaghreb.setText(objTimings.getString("Maghrib"));


                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }

                    }
                }).start();



            }
        });


    }
}

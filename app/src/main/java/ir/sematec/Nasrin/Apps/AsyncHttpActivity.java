package ir.sematec.Nasrin.Apps;

import androidx.appcompat.app.AppCompatActivity;
import cz.msebera.android.httpclient.Header;
import ir.sematec.Nasrin.Apps.praymodel.PrayTimesClass;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONObject;

public class AsyncHttpActivity extends AppCompatActivity {


    TextView txtmaghrib;
    TextView txtfajr;
    TextView txtsunset;
    TextView txtsunrise;
    TextView txtisha;
    TextView txtimsak;
    TextView txtmidnight;
    TextView txtasr;
    TextView txtdhour;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_http);

        txtmaghrib=findViewById(R.id.txtMaghrib);
        txtfajr=findViewById(R.id.txtFFajr);
        txtsunrise=findViewById(R.id.txtSSunrise);
        txtdhour=findViewById(R.id.txtDDhuhr);
        txtasr=findViewById(R.id.txtAAsr);
        txtsunset=findViewById(R.id.txtSSunset);
        txtisha=findViewById(R.id.txtIIsha);
        txtimsak=findViewById(R.id.txtIImsak);
        txtmidnight=findViewById(R.id.txtMMidnight);


        String url="http://api.aladhan.com/v1/timingsByCity?city=tehran&country=Iran&method=8";

        AsyncHttpClient client=new AsyncHttpClient();
        client.get(url,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                Gson gson=new Gson();
                PrayTimesClass pray=gson.fromJson(response.toString(),PrayTimesClass.class);

                String  f=pray.getData().getTimings().getFajr();
                String  s=pray.getData().getTimings().getSunrise();
                String  d=pray.getData().getTimings().getDhuhr();
                String  a=pray.getData().getTimings().getAsr();
                String  ss=pray.getData().getTimings().getSunset();
                String  m=pray.getData().getTimings().getMaghrib();
                String  i=pray.getData().getTimings().getIsha();
                String  ii=pray.getData().getTimings().getImsak();
                String  mm=pray.getData().getTimings().getMidnight();


                 txtfajr.setText(f);
                 txtsunrise.setText(s);
                 txtdhour .setText(d);
                 txtasr.setText(a);
                 txtsunset.setText(ss);
                 txtmaghrib.setText(m);
                 txtisha.setText(i);
                 txtimsak.setText(ii);
                 txtmidnight.setText(mm);
                 Log.d("Response",m);
            }


            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });

    }
}

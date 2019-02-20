package ir.sematec.Nasrin.Apps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

public class HandlerActivity extends AppCompatActivity {
    Boolean hasUserClickedOnback=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
    }

    @Override
    public void onBackPressed() {
        if(!hasUserClickedOnback){
            Toast.makeText(this,"",Toast.LENGTH_SHORT).show();
            hasUserClickedOnback=true;
            new Handler().postDelayed( new Runnable() {
                @Override
                public void run() {
                   hasUserClickedOnback=false;
                }
            },2000);
        }else {
            super.onBackPressed();
        }

    }
}

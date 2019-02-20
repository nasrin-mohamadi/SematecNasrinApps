package ir.sematec.Nasrin.Apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     

        Button btnTaskS2 = findViewById(R.id.btnTaskS2);
        btnTaskS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });

        Button btnTaskS4=findViewById(R.id.btnTaskS4);
        btnTaskS4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SubmitActivity.class);
                startActivity(intent);

            }
        });

        Button btnTaskS5=findViewById(R.id.btnTaskS5);
        btnTaskS5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,UserActivity.class);
                startActivity(intent);
            }
        });

        Button btnTaskS6=findViewById(R.id.btnTaskS6);
        btnTaskS6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RecycleViewActivity.class);
                startActivity(intent);
            }
        });

        Button btnTaskS71=findViewById(R.id.btnTaskS71);
        btnTaskS71.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,DrawerActivity.class);
                startActivity(intent);

            }
        });

        Button btnTask81=findViewById(R.id.btnTaskS81);
        btnTask81.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AsyncHttpActivity.class);
                startActivity(intent);
            }
        });

        Button btnTask82=findViewById(R.id.btnTaskS82);
        btnTask82.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,PermissionActivity.class);
                startActivity(intent);
            }
        });

        Button btnTask83=findViewById(R.id.btnTaskS83);
        btnTask83.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });

        Button btnTask84=findViewById(R.id.btnTaskS84);
        btnTask84.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,HandlerActivity.class);
                startActivity(intent);
            }
        });
    }

}

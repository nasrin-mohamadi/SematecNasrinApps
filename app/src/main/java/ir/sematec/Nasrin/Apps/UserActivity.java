package ir.sematec.Nasrin.Apps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);



        Button btnShowInfo =findViewById(R.id.btnShowInfo);
        TextView txtUser = findViewById(R.id.txtUser);

        String Name= PreferenceManager.getDefaultSharedPreferences(UserActivity.this).getString("Name","UnKnown");
        txtUser.setText(Name);


        btnShowInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(UserActivity.this,ShowInfoActivity.class);
                startActivityForResult(intent,150);

            }
        });


        Button btnChangeInfo =findViewById(R.id.btnChangeInfo);

        btnChangeInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(UserActivity.this,ChangeInfoActivity.class);
                startActivityForResult(intent,200);

            }
        });

    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        TextView txtUser = findViewById(R.id.txtUser);

        if (requestCode==200){
            if (resultCode== Activity.RESULT_OK){

                String Name= PreferenceManager.getDefaultSharedPreferences(UserActivity.this).getString("Name","UnKnown");
               // String Name=data.getStringExtra("Name");
                txtUser.setText(Name);
               // Toast.makeText(UserActivity.this,Name,Toast.LENGTH_LONG).show();
            }
        }

    }

}

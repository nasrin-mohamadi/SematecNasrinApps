package ir.sematec.Nasrin.Apps;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class ChangeInfoActivity extends AppCompatActivity {

    String Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_info);


        Button btnOk = findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {

            EditText edtName=findViewById(R.id.edtName);

            @Override
            public void onClick(View v) {

                Name=edtName.getText().toString();
                getDefaultSharedPreferences(ChangeInfoActivity.this).edit().putString("Name",Name).apply();
                Intent intent=new Intent();
               // intent.putExtra("Name",Name);
                setResult(Activity.RESULT_OK,intent);
                finish();

            }
        });

    }

}

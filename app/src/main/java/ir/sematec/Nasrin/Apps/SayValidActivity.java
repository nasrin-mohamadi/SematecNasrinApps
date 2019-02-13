package ir.sematec.Nasrin.Apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SayValidActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_say_valid);


        TextView txtName = findViewById(R.id.txtName);
        Intent intent=getIntent();
        String s = intent.getStringExtra("Name");
        txtName.setText(s);

    }
}

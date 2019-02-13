package ir.sematec.Nasrin.Apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SubmitActivity extends AppCompatActivity {

    String Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);


        Button btnSub = findViewById(R.id.btnSubmit);


        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                EditText edtName=findViewById(R.id.edtName);
                Name=edtName.getText().toString();

                Intent intent=new Intent(SubmitActivity.this,SayValidActivity.class);

                intent.putExtra("Name", Name);
                startActivity(intent);


            }
        });


    }
}

package ir.sematec.Nasrin.Apps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

public class SQLActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        DBOpenHelper openHelper=new DBOpenHelper(this,"mohamadi",null,1);
        openHelper.insertScore("Pouya",17);
        openHelper.insertScore("Maryam",20);
        openHelper.insertScore("Zahra",12);
        openHelper.insertScore("Mohamad",2);
        openHelper.insertScore("Ali",8);

        String allNames=openHelper.getALLNames();
        Toast.makeText(this,allNames,Toast.LENGTH_SHORT).show();

    }
}

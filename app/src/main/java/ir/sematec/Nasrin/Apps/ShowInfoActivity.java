package ir.sematec.Nasrin.Apps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.TextView;

public class ShowInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        TextView txtName = findViewById(R.id.txtName);

        String Name= PreferenceManager.getDefaultSharedPreferences(ShowInfoActivity.this).getString("Name","UnKnown");
        txtName.setText(Name);

    }
}

package ir.sematec.Nasrin.Apps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Switch;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        IntentFilter filter =new IntentFilter();
        filter.addAction("android.intent.action.AIRPLANE_MODE");
        TestBroadCastReceiver receiver=new TestBroadCastReceiver();
        registerReceiver(receiver,filter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case R.id.first_item:
                Toast.makeText(this,"First Item",Toast.LENGTH_SHORT).show();
                break;
            case R.id.second_item:
                Toast.makeText(this,"Second Item",Toast.LENGTH_SHORT).show();
                break;
            case R.id.Third_item:
                Toast.makeText(this,"Third Item",Toast.LENGTH_SHORT).show();
                break;

        }

        return true;
    }
}

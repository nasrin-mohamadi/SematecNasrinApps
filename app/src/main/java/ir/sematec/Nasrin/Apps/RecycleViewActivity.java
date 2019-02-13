package ir.sematec.Nasrin.Apps;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecycleViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        RecyclerView recycler =findViewById(R.id.recycler);

        TestAddapter adapter =new TestAddapter();

        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(RecycleViewActivity.this,RecyclerView.VERTICAL,false));
    }
}

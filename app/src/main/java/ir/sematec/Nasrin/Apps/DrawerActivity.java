package ir.sematec.Nasrin.Apps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class DrawerActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override


    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);


        final Button btnOpen = findViewById(R.id.btnOpen);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {

                mDrawerLayout = findViewById(R.id.drawerLayout);
                //mDrawerLayout.openDrawer(Gravity.START);
                if (mDrawerLayout.isDrawerOpen(Gravity.RIGHT)) {
                    mDrawerLayout.closeDrawer(Gravity.RIGHT);
                } else {
                    mDrawerLayout.openDrawer(Gravity.RIGHT);
                }

                TextView txtInternetCon =findViewById(R.id.txtInternetCon);
                txtInternetCon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(DrawerActivity.this,HttpConnectionActivity.class);
                        startActivity(intent);
                    }
                });



              /*  switch (v.getId()) {
               //     case R.id.txtDrawer:
               //         Toast.makeText(DrawerActivity.this, "Drawer Clicked!", Toast.LENGTH_LONG).show();

             //           break;

               // }*/


            }
        });
    }


}

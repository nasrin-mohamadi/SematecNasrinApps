package ir.sematec.Nasrin.Apps;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class TestBroadCastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"AirPlaneMode Activated!",Toast.LENGTH_SHORT).show();
    }
}

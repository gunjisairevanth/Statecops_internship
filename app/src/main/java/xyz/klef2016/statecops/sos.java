package xyz.klef2016.statecops;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class sos extends Compliant_status {

    static  final int REQUEST_LOCATION=1;
    LocationManager locationManager;
    String log1,late1;
    TextView log,late;
    Button SOS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sos);

        locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        log=(TextView)findViewById(R.id.longitude);
        late=(TextView)findViewById(R.id.latitude);
        getLocation();
        SOS=(Button)findViewById(R.id.SOS_compliant);
        SOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s="SOS "+"("+log1+","+late1+")";
                if(Compliants.contains(s))
                {
                    Toast.makeText(sos.this,"Already An SOS Compliant is Registered",Toast.LENGTH_LONG).show();
                }
                else {
                    Compliants.add(s);
                    saveData();
                    loadData();
                    Toast.makeText(sos.this,"SOS Compliant is Registered Sucessfully",Toast.LENGTH_LONG).show();
                }


            }
        });
    }
    void getLocation()
    {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)!=
                PackageManager.PERMISSION_GRANTED &&  ActivityCompat.checkSelfPermission(this,Manifest.permission.ACCESS_COARSE_LOCATION)!=
        PackageManager.PERMISSION_GRANTED )
        {
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.ACCESS_FINE_LOCATION},REQUEST_LOCATION);
        }
        else
        {
            Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

            if(location!=null)
            {
                double lati=location.getLatitude();
                double loni=location.getLongitude();
                log1=Double.toString(loni);
                late1=Double.toString(lati);
                log.setText(""+lati);
                late.setText(""+loni);
            }
            else
            {
                log.setText("Unable to get your location");
                late.setText("Unable to get your location");
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode)
        {
            case REQUEST_LOCATION:
                getLocation();
                break;
        }
    }
}

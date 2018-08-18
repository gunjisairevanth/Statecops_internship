package xyz.klef2016.statecops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class Dashbord extends Compliant_status {

    LinearLayout sos,compliant,compliant_status,echallan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashbord);

        sos=(LinearLayout)findViewById(R.id.sos);
        compliant=(LinearLayout)findViewById(R.id.compliant);
        compliant_status=(LinearLayout) findViewById(R.id.compliant_status);
        echallan=(LinearLayout)findViewById(R.id.echallan);

        sos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
   sos();
            }
        });
        compliant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                com();
            }
        });

        compliant_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadData();
           sts();
            }
        });
        echallan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              echal();
            }
        });
    }

    public void  com()
    {
        Intent intent = new Intent(this,Compliant.class);
        startActivity(intent);
    }
    public void  sts()
    {
        Intent intent = new Intent(this,Compliant_status.class);
        startActivity(intent);
    }
    public void  sos()
    {
        Intent intent = new Intent(this,sos.class);
        startActivity(intent);
    }
    public void echal()
    {
        Intent intent = new Intent(this,Echallan.class);
        startActivity(intent);

    }
}

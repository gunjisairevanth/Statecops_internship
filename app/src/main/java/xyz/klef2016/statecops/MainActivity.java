package xyz.klef2016.statecops;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class    MainActivity extends AppCompatActivity {

    Button click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        click=(Button)findViewById(R.id.Click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun();
            }
        });
    }

    public void fun()
    {
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}

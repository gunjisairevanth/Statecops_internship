package xyz.klef2016.statecops;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Echallan extends AppCompatActivity {

    EditText v_number;
    String ve_number,vee_number="27AX4014";
    TextView number,Violation,amount,found;
    Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echallan);

        check=(Button)findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v_number=(EditText)findViewById(R.id.v_number);
                ve_number=v_number.getText().toString();
                fun();
            }
        });
    }

    void fun()
    {
        if(ve_number.equals(vee_number))
        {
            number=(TextView)findViewById(R.id.number);
            number.setText("AP"+ve_number);
            Violation=(TextView)findViewById(R.id.Violation);
            Violation.setText("No Helmet found");
            amount=(TextView)findViewById(R.id.amount);
            amount.setText("Rs.150");
            found=(TextView)findViewById(R.id.found);
            found.setText("Record Found");
            found.setTextColor(getResources().getColor(R.color.green));
        }
        else
        {
            number=(TextView)findViewById(R.id.number);
            number.setText("");
            Violation=(TextView)findViewById(R.id.Violation);
            Violation.setText("");
            amount=(TextView)findViewById(R.id.amount);
            amount.setText("");
            found=(TextView)findViewById(R.id.found);
            found.setText("No Records Found");
            found.setTextColor(getResources().getColor(R.color.red));
        }
    }
}

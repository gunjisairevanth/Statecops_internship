package xyz.klef2016.statecops;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Compliant extends Compliant_status {

   Spinner spin,g,s;
   EditText n,editText11,p,editText14,editText15,editText16;
   Button button;
   String District,name,gender,dob,phone,subject,occur,p_occur,Description;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compliant);
        spin=(Spinner)findViewById(R.id.spin);
        District=spin.getSelectedItem().toString();
        n=(EditText)findViewById(R.id.name);
        name=n.getText().toString();
        g=(Spinner)findViewById(R.id.gender);
        gender=g.getSelectedItem().toString();
        editText11=(EditText)findViewById(R.id.editText11);
        dob=editText11.getText().toString();
        p=(EditText)findViewById(R.id.phone);
        phone=p.getText().toString();
        s=(Spinner)findViewById(R.id.subject);
        subject=s.getSelectedItem().toString();
        editText14=(EditText)findViewById(R.id.editText14);
        occur=editText14.getText().toString();
        editText15=(EditText)findViewById(R.id.editText15);
        p_occur=editText15.getText().toString();
        editText16=(EditText)findViewById(R.id.editText16);
        Description=editText16.getText().toString();
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fun();
            }
        });


    }

    private void fun()
    {
        spin=(Spinner)findViewById(R.id.spin);
        District=spin.getSelectedItem().toString();
        n=(EditText)findViewById(R.id.name);
        name=n.getText().toString();
        g=(Spinner)findViewById(R.id.gender);
        gender=g.getSelectedItem().toString();
        editText11=(EditText)findViewById(R.id.editText11);
        dob=editText11.getText().toString();
        p=(EditText)findViewById(R.id.phone);
        phone=p.getText().toString();
        s=(Spinner)findViewById(R.id.subject);
        subject=s.getSelectedItem().toString();
        editText14=(EditText)findViewById(R.id.editText14);
        occur=editText14.getText().toString();
        editText15=(EditText)findViewById(R.id.editText15);
        p_occur=editText15.getText().toString();
        editText16=(EditText)findViewById(R.id.editText16);
        Description=editText16.getText().toString();

        if(District.isEmpty()|| name.isEmpty()||gender.isEmpty()||dob.isEmpty()||phone.isEmpty()||subject.isEmpty()||occur.isEmpty()||p_occur.isEmpty()||Description.isEmpty())
        {
            Toast.makeText(this, "Please Enter All Fields", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Compliants.add("Online Compliant"+"  "+"("+name+","+subject+")");
            saveData();
            loadData();
            Toast.makeText(this, "Registered Sucessfully", Toast.LENGTH_SHORT).show();
        }
    }
}

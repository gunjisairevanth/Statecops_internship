package xyz.klef2016.statecops;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Login {

    EditText f,l,e,p,r;
    Button Reg;
    String first,last,email,password,repassword;
    CheckBox check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        f=(EditText)findViewById(R.id.first);
        l=(EditText)findViewById(R.id.last);
        e=(EditText)findViewById(R.id.email);
        p=(EditText)findViewById(R.id.password);
        r=(EditText)findViewById(R.id.repassword);
        Reg=(Button)findViewById(R.id.Reg);
        check=(CheckBox)findViewById(R.id.checkBox);
        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check.isChecked())
                {
                    ok();
                }
                else
                {
                    Toast.makeText(Register.this, "Please Tick on Check Box", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void ok()
    {

        first=f.getText().toString();
        last=l.getText().toString();
        email=e.getText().toString();
        password=p.getText().toString();
        repassword=r.getText().toString();
        if(first.isEmpty() || last.isEmpty()||email.isEmpty()||password.isEmpty() || repassword.isEmpty())
        {
            Toast.makeText(this, "Please All Your details", Toast.LENGTH_SHORT).show();
        }
        else
        {
            if(password.equals(repassword))
            {
                if(Email.contains(email))
                {
                    Toast.makeText(this, "User Already Exits", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Email.add(email);
                    Password.add(password);
                    saveData();
                    Toast.makeText(this, "You Register Sucessfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Register.this,Login.class);
                    startActivity(intent);
                }

            }
            else
            {
                Toast.makeText(this, "Passwords are Not Matched", Toast.LENGTH_SHORT).show();
            }
        }
    }


}

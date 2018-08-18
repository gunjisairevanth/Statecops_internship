package xyz.klef2016.statecops;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Login extends AppCompatActivity {

    Button Register,Login;
    EditText id1,id_password;
    String Auth_id,Auth_pass;
    public ArrayList<String> Email = new ArrayList<String>();
    public ArrayList<String> Password= new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Register=(Button)findViewById(R.id.register);
        loadData();
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });
        Login=(Button)findViewById(R.id.login);
        id1=(EditText)findViewById(R.id.id);
        id_password=(EditText)findViewById(R.id.id_password);

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                loadData();

    Auth_id=id1.getText().toString();
    Auth_pass=id_password.getText().toString();
    if(Email.contains(Auth_id) && Password.contains(Auth_pass))
    {
      Intent intent = new Intent(Login.this,Dashbord.class);
      startActivity(intent);
    }
    else
    {
        Toast.makeText(Login.this,"Id (or) Password is Incorrect",Toast.LENGTH_LONG).show();
    }
            }
        });


    }

    public void saveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared Preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Email);
        String json1 = gson.toJson(Password);
        editor.putString("email",json);
        editor.putString("password",json1);
        editor.apply();
    }
    public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared Preferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("email",null);
        String json1 = sharedPreferences.getString("password",null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        Email = gson.fromJson(json,type);
        Password = gson.fromJson(json1,type);
        if(Email == null)
        {
            Email = new ArrayList<String>();
        }
        if(Password == null)
        {
            Password = new ArrayList<String>();
        }
    }



}

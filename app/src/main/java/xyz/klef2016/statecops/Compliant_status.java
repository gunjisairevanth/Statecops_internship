package xyz.klef2016.statecops;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Compliant_status extends AppCompatActivity {

    public ArrayList<String> Compliants = new ArrayList<String>();
    ListView List_names;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compliant_status);
        loadData();
        List_names=(ListView)findViewById(R.id.List_names);

                    ArrayAdapter<String> adapter = new ArrayAdapter<String >(Compliant_status.this,android.R.layout.simple_list_item_1,Compliants);
                    List_names.setAdapter(adapter);
                    saveData();

    }
    public void saveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared Preferences",MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(Compliants);
        editor.putString("task list",json);
        editor.apply();
    }
    public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences("shared Preferences",MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("task list",null);
        Type type = new TypeToken<ArrayList<String>>(){}.getType();
        Compliants = gson.fromJson(json,type);

        if(Compliants == null)
        {
            Compliants = new ArrayList<String>();
        }
    }
}

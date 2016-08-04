package com.myapps.amrith.renovild_test;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText password=(EditText)findViewById(R.id.phn);
        final EditText name=(EditText)findViewById(R.id.Name);
        final EditText user=(EditText)findViewById(R.id.Username);
        final EditText phone=(EditText)findViewById(R.id.Phone);
        final EditText mail=(EditText)findViewById(R.id.Email);
        final Button reg=(Button)findViewById(R.id.Register);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Uploading Data To Server. This Might Take A While", Toast.LENGTH_LONG).show();
                Response.Listener<String>responselistener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json=new JSONObject(response);
                            boolean success=json.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(),"Data Uploaded To Server,Please Login Using Credentials",Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            }
                            else
                            {
                                AlertDialog.Builder builder=new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Failed To Register")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                String na=name.getText().toString();
                String un=user.getText().toString();
                String ps=password.getText().toString();
                String ph=phone.getText().toString();
                String em=mail.getText().toString();
                RegisterReq registerReq=new RegisterReq(na,un,ps,ph,em,responselistener);
                RequestQueue requestQueue= Volley.newRequestQueue(RegisterActivity.this);
                requestQueue.add(registerReq);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

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
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final EditText user=(EditText)findViewById(R.id.Username);
        final EditText pass=(EditText)findViewById(R.id.password);
        final Button Login=(Button)findViewById(R.id.Login);
        final TextView reg=(TextView)findViewById(R.id.textView);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(intent);
            }
        });
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Please Wait", Toast.LENGTH_SHORT).show();
                Response.Listener<String>responselistener=new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonresponse=new JSONObject(response);
                            boolean success=jsonresponse.getBoolean("success");
                            if(success){
                                Toast.makeText(getApplicationContext(),"Successfullu Logged In", Toast.LENGTH_SHORT).show();
                                String name=jsonresponse.getString("Name");
                                String Phone=jsonresponse.getString("Phone");
                                String Email=jsonresponse.getString("Email");
                                Intent intent=new Intent(LoginActivity.this,UserActivity.class);
                                intent.putExtra("Pname",name);
                                intent.putExtra("Pph",Phone);
                                intent.putExtra("Pem",Email);
                                LoginActivity.this.startActivity(intent);
                            }
                            else{
                                AlertDialog.Builder builder=new AlertDialog.Builder(LoginActivity.this);
                                builder.setMessage("Login Failed")
                                        .setNegativeButton("Retry",null)
                                        .create()
                                        .show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                String user_name=user.getText().toString();
                String pass_word=pass.getText().toString();
                LoginReq loginReq=new LoginReq(user_name,pass_word,responselistener);
                RequestQueue requestQueue= Volley.newRequestQueue(LoginActivity.this);
                requestQueue.add(loginReq);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
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

package com.myapps.amrith.renovild_test;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        final TextView user=(TextView)findViewById(R.id.Name);
        final TextView phn=(TextView)findViewById(R.id.phn);
        final TextView mail=(TextView)findViewById(R.id.mailtext);
        final TextView tv=(TextView)findViewById(R.id.Welcome);
        Intent intent=getIntent();
        String name=intent.getStringExtra("Pname");
        String phone=intent.getStringExtra("Pph");
        String email=intent.getStringExtra("Pem");
        user.setText(name.toString());
        phn.setText(phone.toString());
        mail.setText(email.toString());
        String message=name+" Welcome To This Application";
        tv.setText(message);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user, menu);
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

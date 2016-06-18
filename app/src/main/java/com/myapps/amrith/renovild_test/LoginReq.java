package com.myapps.amrith.renovild_test;

/**
 * Created by hp on 17-06-2016.
 */
import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class LoginReq extends StringRequest {
    private static final String URL="http://amrith98.hostingsiteforfree.com/login.php";
    private Map<String,String> params;
    public LoginReq(String Username,String Password,Response.Listener<String>listener)
    {   super(Method.POST,URL,listener,null);
        params=new HashMap<>();
        params.put("Username",Username);
        params.put("Password",Password);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}

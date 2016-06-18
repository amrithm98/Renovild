package com.myapps.amrith.renovild_test;

/**
 * Created by hp on 17-06-2016.
 */

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class RegisterReq extends StringRequest {
    private static final String URL="http://amrith98.hostingsiteforfree.com/register.php";
    private Map<String,String> params;

    public RegisterReq(String Name,String Username,String Password,String Phone,String Email,Response.Listener<String>listener)
    {   super(Method.POST,URL,listener,null);
        params=new HashMap<>();
        params.put("Name",Name);
        params.put("Username",Username);
        params.put("Password",Password);
        params.put("Phone",Phone);
        params.put("Email",Email);
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}

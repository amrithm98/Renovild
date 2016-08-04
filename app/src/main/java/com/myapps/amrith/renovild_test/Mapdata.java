package com.myapps.amrith.renovild_test;

/**
 * Created by hp on 19-06-2016.
 */

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class Mapdata extends StringRequest {
    private static final String URL="http://amrith98.hostingsiteforfree.com/saveloc.php";
    private Map<String,String> params;
    public Mapdata(String Name,String lat,String lon, Response.Listener<String> listener)
    {   super(Method.POST,URL,listener,null);
        params=new HashMap<>();
        params.put("Name",Name);
        params.put("Lat", String.valueOf(lat));
        params.put("Long",String.valueOf(lon));
    }

    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return params;
    }
}
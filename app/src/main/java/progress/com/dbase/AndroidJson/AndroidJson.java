package progress.com.dbase.AndroidJson;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import android.os.Handler;

import org.json.JSONException;
import org.json.JSONObject;

import progress.com.dbase.R;

public class AndroidJson extends AppCompatActivity {
    RequestQueue rq;
    TextView nametxt,descriptiontxt,fbtxt,youtubetxt,plustxt;
    String name,description,facebook,youtube,plus;
    String url="http://192.168.201.1/Dbase/dbase.json";
    private Context mContext = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidjson);
        rq= Volley.newRequestQueue(this);
        final SwipeRefreshLayout swipe = (SwipeRefreshLayout)findViewById(R.id.swipeview);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipe.setRefreshing(false);
                        sendjsonrequest();
                    }

                },4000);
            }
        });

        nametxt=(TextView)findViewById(R.id.nameurl);
        descriptiontxt=(TextView)findViewById(R.id.descriptionurl);
        fbtxt=(TextView)findViewById(R.id.facebookurl);
        youtubetxt=(TextView)findViewById(R.id.youtubeurl);
        plustxt=(TextView)findViewById(R.id.plusurl);

        sendjsonrequest();
    }
    public void sendjsonrequest(){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try{

                    name=response.getString("name");
                    description=response.getString("description");
                    facebook=response.getString("facebook");
                    youtube=response.getString("youtube");
                    plus=response.getString("googleplus");


                    nametxt.setText(name);
                    descriptiontxt.setText(description);
                    fbtxt.setText(facebook);
                    youtubetxt.setText(youtube);
                    plustxt.setText(plus);
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        rq.add(jsonObjectRequest);
    }
}

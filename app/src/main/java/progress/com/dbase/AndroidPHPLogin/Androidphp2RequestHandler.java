package progress.com.dbase.AndroidPHPLogin;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Umar Saidu Auna on 8/20/2017.
 */

public class Androidphp2RequestHandler {
    private static Androidphp2RequestHandler mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    private Androidphp2RequestHandler(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();

    }

    public static synchronized Androidphp2RequestHandler getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Androidphp2RequestHandler(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
        }
        return mRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}

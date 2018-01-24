package progress.com.dbase.AndroidReaadingTextFile;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import progress.com.dbase.AndroidDownloadFile.DownloadFile;
import progress.com.dbase.R;

public class ReadingTextFile extends AppCompatActivity {
    Activity context;
    TextView txtView;
    ProgressDialog pd;
    ViewFile viewfile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_text_file);
        context = this;
        final SwipeRefreshLayout swipe = (SwipeRefreshLayout)findViewById(R.id.swipe);

        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipe.setRefreshing(false);
                       onStart();
                    }

                },4000);
            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        viewfile = new ViewFile();
        viewfile.execute("http://192.168.201.1/readfile/message.txt");
    }

    //background download from server
    private class ViewFile extends AsyncTask<String,Integer,Void>{
        String rubutu="";

        protected void onPreExecute(){
            super.onPreExecute();
            //displays dialog
            pd = new ProgressDialog(context);
            pd.setTitle("Fetching the file");
            pd.setMessage("Please wait....");
            pd.setCancelable(true);
            pd.setIndeterminate(false);
            pd.show();
        }

        @Override
        protected Void doInBackground(String... strings) {
            URL url;
            try{
                //create url object to point to file location on server
                url = new URL(strings[0]);
                //make request to the server
                HttpURLConnection con = (HttpURLConnection)url.openConnection();
                //get InputStream Instance
                InputStream inputStream = con.getInputStream();
                //create BufferedReader Object;
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                //read content of the file line by line
                while((line=br.readLine())!=null){
                    rubutu+=line;
                }
                br.close();
            }catch(Exception e){
                e.printStackTrace();
                //close dialog if errors occurs

                if(pd!=null)
                    pd.dismiss();
            }
            return null;
        }

        protected void onPostExecute(Void result){
            //close dialog
            if(pd!=null) {
                pd.dismiss();
                txtView = (TextView) findViewById(R.id.readfile);
                txtView.setText(rubutu);
                }
            }
        }
}

package progress.com.dbase.AndroidPHPLogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import progress.com.dbase.R;

public class Androidphp2ProfileActivity extends AppCompatActivity {
    private TextView txtUsername, txtUserEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_androidphp2_profile);
        if(!Androidphp2SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this,Androidphp2Login.class));
        }
        txtUsername = (TextView)findViewById(R.id.textUsername);
        txtUserEmail = (TextView)findViewById(R.id.textEmail);

        txtUsername.setText(Androidphp2SharedPrefManager.getInstance(this).getUsername());
        txtUserEmail.setText(Androidphp2SharedPrefManager.getInstance(this).getUserEmail());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id== R.id.menulogout){
            Androidphp2SharedPrefManager.getInstance(this).logout();
            finish();
            startActivity(new Intent(this,Androidphp2.class));
        }else if(id==R.id.menuSettings){
            Toast toast = Toast.makeText(this,"Settings Selected", Toast.LENGTH_LONG);
            toast.show();
        }
        return true;
    }
}

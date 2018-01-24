package progress.com.dbase.AndroidDangerousPermission;

import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import progress.com.dbase.MainActivity;
import progress.com.dbase.R;

public class Dangerous_Permissions extends AppCompatActivity {
    private static final int MY_PERMISSION_CALL1 = 2;
    private static final int MY_PERMISSION_CALL2 = 4;
    private static final int SEND_SMS=6;
    EditText locationField;
    private LinearLayout linear;
    private Button button1,button2,sms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangerous__permissions);
        button1 = (Button) findViewById(R.id.call);
        button2 = (Button) findViewById(R.id.call2);
        linear=(LinearLayout)findViewById(R.id.linearlayout);
        sms = (Button) findViewById(R.id.sms);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale(Dangerous_Permissions.this, Manifest.permission.CALL_PHONE)) {
                        new AlertDialog.Builder(Dangerous_Permissions.this)
                                .setTitle("Permission Required")
                                .setMessage("This permission is required to call from app .So,in order to use this feature please allow this permission by clicking allow.")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    @TargetApi(Build.VERSION_CODES.M)
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSION_CALL1);
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int which) {
                                        dialog.dismiss();
                                    }
                                })
                                .setIcon(R.mipmap.ic_launcher)
                                .show();
                    }else{
                        requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSION_CALL1);
                    }

                } else {
                    //Start Calling
                    Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:08183000"));
                    startActivity(call);

                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.CALL_PHONE}, MY_PERMISSION_CALL2);
                } else {
                    //start download
                    Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:08120000"));
                    startActivity(call);

                }
            }
        });
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 23 && checkSelfPermission(Manifest.permission.SEND_SMS)
                        != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(new String[]{Manifest.permission.SEND_SMS},SEND_SMS);
                }else{
                    EditText locationField = (EditText) findViewById(R.id.locationid);
                    String location = locationField.getText().toString();
                    CheckBox withArm = (CheckBox) findViewById(R.id.armedbox);
                    boolean armedbox = withArm.isChecked();
                    String content = smsSummary(location, armedbox);
                    String number = "1";
                    SmsManager smsManager = SmsManager.getDefault();
                    Toast.makeText(getApplicationContext(), "Thank You for Reporting, Dispatch Team will be sent Immediately", Toast.LENGTH_LONG).show();
                    smsManager.sendTextMessage(number, null, content, null, null);
                    Intent close = new Intent(getApplicationContext(), Dangerous_Permissions.class);
                    startActivity(close);
                    }
            }
        });
    }

    private String smsSummary(String location, boolean armedbox) {
        String content = "Flooding is currently occuring at " + location;
        content += "\nCasualty Status = " + armedbox;
        return content;

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSION_CALL1: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                    Snackbar.make(linear, "Permission granted", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:08183000"));
                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    startActivity(call);
                }else{
                    //Toast.makeText(this,"Permission not granted",Toast.LENGTH_SHORT).show();
                    Snackbar.make(linear, "Permission not granted", Snackbar.LENGTH_LONG).setAction("Action", null).show();

                }
                break;
            }
            case MY_PERMISSION_CALL2: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                    Snackbar.make(linear, "Permission granted", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    Intent call = new Intent(Intent.ACTION_CALL, Uri.parse("tel:08120000"));
                    startActivity(call);
                } else {
                    //Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
                    Snackbar.make(linear, "Permission not granted", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                }
                break;
            }
            case SEND_SMS:{
                if(grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    //Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
                    Snackbar.make(linear, "Permission granted", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    locationField = (EditText) findViewById(R.id.locationid);
                    String location = locationField.getText().toString();
                    CheckBox withArm = (CheckBox) findViewById(R.id.armedbox);
                    boolean armedbox = withArm.isChecked();
                    String content = smsSummary(location, armedbox);
                    String number = "1";
                    SmsManager smsManager = SmsManager.getDefault();
                    Toast.makeText(getApplicationContext(), "Thank You for Reporting, Dispatch Team will be sent Immediately", Toast.LENGTH_LONG).show();
                    smsManager.sendTextMessage(number, null, content, null, null);
                    Intent close = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(close);
                }else{
                    //Toast.makeText(this, "Permission not granted", Toast.LENGTH_SHORT).show();
                    Snackbar.make(linear, "Permission not granted", Snackbar.LENGTH_LONG).setAction("Click",null).show();
                }
                break;
            }
        }
    }
}

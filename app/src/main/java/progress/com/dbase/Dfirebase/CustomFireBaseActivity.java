package progress.com.dbase.Dfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import progress.com.dbase.Dfirebase.firemodel.firemodel;
import progress.com.dbase.R;

public class CustomFireBaseActivity extends AppCompatActivity {
    EditText names,surnames,phones,emails;
    Button SendFirebase,viewrecords;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_fire_base);
        names = findViewById(R.id.entername);
        surnames = findViewById(R.id.entersurname);
        phones = findViewById(R.id.enterphonenumber);
        emails = findViewById(R.id.enteremail);
        SendFirebase = findViewById(R.id.sendfires);
        viewrecords =findViewById(R.id.viewfiles);
        firebaseDatabase = FirebaseDatabase.getInstance();
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        databaseReference= firebaseDatabase.getReference().child("CustomList");


        viewrecords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),CustomFireBaseDisplay.class));
            }
        });

        SendFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = names.getText().toString().trim() ;
                String surname = surnames.getText().toString().trim();
                String phone = phones.getText().toString().trim();
                String email = emails.getText().toString().trim();
                firemodel firemodel = new firemodel();
                firemodel.setName(name);
                firemodel.setSurname(surname);
                firemodel.setPhonenum(phone);
                firemodel.setEmail(email);
                String autoid = databaseReference.push().getKey();
                databaseReference.child(autoid).setValue(firemodel);
                Toast.makeText(CustomFireBaseActivity.this, "Data Has been Inserted", Toast.LENGTH_SHORT).show();
                names.setText(" ");
                surnames.setText(" ");
                phones.setText(" ");
                emails.setText(" ");
            }
        });
    }
}

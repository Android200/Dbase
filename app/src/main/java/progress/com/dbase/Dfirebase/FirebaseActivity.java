package progress.com.dbase.Dfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import progress.com.dbase.Dfirebase.firemodel.firemodel;
import progress.com.dbase.R;

public class FirebaseActivity extends AppCompatActivity {
    EditText EnterFireMessage;
    EditText EnterFireSubject;
    Button SendFirebase,Custom;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;
    ListView listviewitem; // Display list of items
    ArrayList<String> list=new ArrayList<>(); // Displays the Contents of the ListView
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firebase);
        EnterFireMessage = findViewById(R.id.entermessage);
        SendFirebase = findViewById(R.id.sendfire);
        Custom = findViewById(R.id.custom);
        listviewitem = findViewById(R.id.listView);
        //FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference= firebaseDatabase.getReference().child("NormalList");
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list); // Displaying the list datas
        listviewitem.setAdapter(adapter);
        SendFirebase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Message = EnterFireMessage.getText().toString().trim() ;
                String autoid = databaseReference.push().getKey();
                databaseReference.child(autoid).setValue(Message);
                Toast.makeText(FirebaseActivity.this, "Data Has been Inserted", Toast.LENGTH_SHORT).show();
                EnterFireMessage.setText(" ");
            }
        });

        Custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(),CustomFireBaseActivity.class));
            }
        });


        databaseReference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                list.add(dataSnapshot.getValue(String.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                list.remove(dataSnapshot.getValue(String.class));
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"The Read Failed: "+databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }
        });


    }
}

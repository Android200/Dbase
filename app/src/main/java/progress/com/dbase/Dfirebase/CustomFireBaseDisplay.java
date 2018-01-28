package progress.com.dbase.Dfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import progress.com.dbase.Dfirebase.firemodel.firemodelreceive;
import progress.com.dbase.R;

public class CustomFireBaseDisplay extends AppCompatActivity {
    private FirebaseRecyclerAdapter<firemodelreceive, BlogViewHolder> firebaserecyclerAdapter;
    private RecyclerView recyclerView;
    private DatabaseReference myref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_fire_base_display);
        recyclerView = findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        myref = FirebaseDatabase.getInstance().getReference().child("CustomList");
        myref.keepSynced(true);
        FirebaseRecyclerOptions<firemodelreceive> options = new FirebaseRecyclerOptions.Builder<firemodelreceive>().setQuery(myref,firemodelreceive.class).build();
        firebaserecyclerAdapter = new FirebaseRecyclerAdapter<firemodelreceive, BlogViewHolder>(options) {

            @Override
            protected void onBindViewHolder(BlogViewHolder viewholder, int position,firemodelreceive model) {
                viewholder.setName(model.getName());
                viewholder.setSurname(model.getSurname());
                viewholder.setEmail(model.getEmail());
                viewholder.setPhone(model.getPhone());
            }

            @Override
            public BlogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.firebase_cardview,parent,false);
                return new BlogViewHolder(v);
            }
        };
        recyclerView.setAdapter(firebaserecyclerAdapter);
    }


    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mView;
        TextView name;
        TextView surname;
        TextView email;
        TextView phone;

        public BlogViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            name = (TextView) itemView.findViewById(R.id.vname);
            surname = (TextView) itemView.findViewById(R.id.vsurname);
            email= (TextView) itemView.findViewById(R.id.vemail);
            phone= (TextView) itemView.findViewById(R.id.vphone);
        }

        public void setName(String names) {
            name.setText(names);
        }

        public void setSurname(String surnames) {
            surname.setText(surnames);
        }
        public void setEmail(String emails) {
            email.setText(emails);
        }
        public void setPhone(String phones) {
            phone.setText(phones);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaserecyclerAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        firebaserecyclerAdapter.stopListening();
    }
}
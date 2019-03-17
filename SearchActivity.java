package com.example.rishi.moviedb;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class SearchActivity extends AppCompatActivity {
    private FirebaseFirestore db;
    private EditText searchterm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        db=FirebaseFirestore.getInstance();
        searchterm=findViewById(R.id.SearchText);
    }


    public void SearchDB(View view) {
        String key=searchterm.getText().toString();
        key.toLowerCase();
        Query Search=db.collection("Movies").whereEqualTo("Name",key);
        Search.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){
                    if(task.getResult().isEmpty()){
                        Toast.makeText(SearchActivity.this, "Movie Doesn't Exist", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        for(QueryDocumentSnapshot document : task.getResult()){
                            if(document.exists()){
                                startActivity(new Intent(getApplicationContext(),PlayActivity.class));
                                break;
                            }
                        }
                    }
                }
            }
        });
    }
}

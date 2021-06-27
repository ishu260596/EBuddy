package com.ishwar_arcore.explorebuddy.views.activities.users;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.ishwar_arcore.explorebuddy.R;
import com.ishwar_arcore.explorebuddy.databinding.ActivityUsersBinding;
import com.ishwar_arcore.explorebuddy.utils.Traveller;
import com.ishwar_arcore.explorebuddy.utils.UsersAdapter;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class UsersActivity extends AppCompatActivity {

    ActivityUsersBinding binding;
    FirebaseDatabase database;
    ArrayList<Traveller> travellers;
    UsersAdapter usersAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUsersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        database = FirebaseDatabase.getInstance();
        travellers = new ArrayList<>();
        usersAdapter = new UsersAdapter(this, travellers);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(usersAdapter);

        database.getReference("Users").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull @NotNull DataSnapshot snapshot) {
                travellers.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    Traveller traveller = dataSnapshot.getValue(Traveller.class);
                    Log.d("TAG",traveller.getUserName());
                    travellers.add(traveller);
                }
                usersAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull @NotNull DatabaseError error) {

            }
        });

    }
}
package com.example.rooms;



import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.rooms.db.AppDatabase;
import com.example.rooms.db.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNewUserButton = findViewById(R.id.add_new_user);
        addNewUserButton.setOnClickListener(view -> {
            startActivityForResult(new Intent(MainActivity.this, AddNewUserActivity.class),
                    100);
        });

        initRecyclerView();
        loadUserList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration decoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(decoration);
        adapter = new UserListAdapter(this);
        recyclerView.setAdapter(adapter);

    }

    private void loadUserList() {
        AppDatabase database = AppDatabase.getDbInstance(this.getApplicationContext());
        List<User> users = database.userDao().getAllUsers();
        adapter.setUsers(users);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            loadUserList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
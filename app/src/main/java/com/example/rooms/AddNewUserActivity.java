package com.example.rooms;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.rooms.db.AppDatabase;
import com.example.rooms.db.User;


public class AddNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_user);

        final EditText firstName = findViewById(R.id.firstNameInput);
        final EditText lastName = findViewById(R.id.lastNameInput);
        Button saveButton = findViewById(R.id.save_user);
        saveButton.setOnClickListener(view -> saveNewUser(firstName.getText().toString(),
                lastName.getText().toString()));
    }

    private void saveNewUser(String firstName, String lastName) {
        AppDatabase database = AppDatabase.getDbInstance(getApplicationContext());
        database.userDao().insertUser(new User(firstName, lastName));

        finish();
    }
}
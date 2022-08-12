package com.example.rooms.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select * from user")
    List<User> getAllUsers();

    @Insert
    void insertUser(User... users);

    @Delete
    void deleteUser(User user);
}

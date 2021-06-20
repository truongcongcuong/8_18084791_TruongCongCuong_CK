package com.example.a8_18084791_truongcongcuong;

import androidx.room.Dao;
import androidx.room.Insert;

@Dao
public interface UserDAO {

    @Insert
    void insert(User... users);

}

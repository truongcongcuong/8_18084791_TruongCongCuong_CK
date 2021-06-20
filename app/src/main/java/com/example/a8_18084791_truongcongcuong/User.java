package com.example.a8_18084791_truongcongcuong;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String email;

    @ColumnInfo(name = "history_login")
    public String historyLogin;

    public User() {
    }

    public User(int id, String email, String historyLogin) {
        this.id = id;
        this.email = email;
        this.historyLogin = historyLogin;
    }

    public User(String email, String historyLogin) {
        this.email = email;
        this.historyLogin = historyLogin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHistoryLogin() {
        return historyLogin;
    }

    public void setHistoryLogin(String historyLogin) {
        this.historyLogin = historyLogin;
    }
}

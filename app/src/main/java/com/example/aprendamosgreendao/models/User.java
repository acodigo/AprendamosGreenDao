package com.example.aprendamosgreendao.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "users",
        indexes = {
                @Index(value = "user")
        })
public class User {

    @Id(autoincrement = true)
    private Long id;
    private String user;
    private String name;
    private String firtsName;
    private String lastName;
    private String email;
    private int age;

    @Generated(hash = 322687691)
    public User(Long id, String user, String name, String firtsName,
                String lastName, String email, int age) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.firtsName = firtsName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    @Generated(hash = 586692638)
    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirtsName() {
        return this.firtsName;
    }

    public void setFirtsName(String firtsName) {
        this.firtsName = firtsName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

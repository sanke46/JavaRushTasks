package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilafedoseev on 23.05.17.
 */
public class ModelData {
    private List<User> users;

    //getter
    public List<User> getUsers() {
        return users;
    }

    //setter
    public void setUsers(List<User> users) {
        this.users = users;
    }
}

package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ilafedoseev on 23.05.17.
 */
public class ModelData {
    private List<User> users;
    private User activeUser;
    private boolean displayDeletedUserList;

    //getter
    public List<User> getUsers() {
        return users;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public boolean getDispalyDeletedUserList(){
        return displayDeletedUserList;
    }

    //setter
    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public void setDisplayDeletedUserList(boolean displayDeletedUserList){
        this.displayDeletedUserList = displayDeletedUserList;
    }
}

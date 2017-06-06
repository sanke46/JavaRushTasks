package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

/**
 * Created by ilafedoseev on 06.06.17.
 */
public class Controller {

    private Model model ;
    private UsersView usersView;
    private EditUserView editUserView;



    public void onShowAllUsers() {
        model.loadUsers();
        usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        model.loadDeletedUsers();
        usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long id){
        model.loadUserById(id);
        editUserView.refresh(model.getModelData());
    }

    public void onUserDelete(long id){
        model.deleteUserById(id);
        usersView.refresh(model.getModelData());
    }

    public void onUserChange(String name, long id, int level){
        model.changeUserData(name,id,level);
        usersView.refresh(model.getModelData());
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public EditUserView getEditUserView() {
        return editUserView;
    }

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

}

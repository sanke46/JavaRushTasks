package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by ilafedoseev on 23.05.17.
 */
public class UsersView implements View{
    private Controller controller;

    public void refresh(ModelData modelData){
        System.out.println("All users:");
        for(User x : modelData.getUsers()){
            System.out.println("\t" + x);
        }

        System.out.println("==================================================");
    }

    //setter
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void fireEventShowAllUsers(){
        controller.onShowAllUsers();
    }
}

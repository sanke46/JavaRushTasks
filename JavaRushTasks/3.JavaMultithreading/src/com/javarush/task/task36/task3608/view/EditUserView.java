package com.javarush.task.task36.task3608.view;

import com.javarush.task.task36.task3608.controller.Controller;
import com.javarush.task.task36.task3608.model.ModelData;

/**
 * Created by ilafedoseev on 31.05.17.
 */
public class EditUserView implements View{
    private Controller controller;

    @Override
    public void refresh(ModelData modelData) {
        System.out.println("User to be edited: ");
        System.out.println("===================================================");
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

}

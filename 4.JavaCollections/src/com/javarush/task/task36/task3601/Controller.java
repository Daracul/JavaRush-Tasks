package com.javarush.task.task36.task3601;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by AMalakhov on 24.08.2017.
 */
public class Controller {
    Model model = new Model();
    public List<String> onDataListShow() {
        return model.getStringDataList();
    }

}


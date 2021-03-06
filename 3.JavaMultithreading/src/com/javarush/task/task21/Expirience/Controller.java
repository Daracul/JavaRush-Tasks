package com.javarush.task.task21.Expirience;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amalakhov on 02.05.2017.
 */

public class Controller {
    // Класс из пакета java.util для хранения событий Event::
    private List<Event> eventList = new ArrayList<Event>();
    public void addEvent(Event c) { eventList.add(c); }
    public void run() {
        while(eventList.size() > 0)
            // Make a copy so you're not modifying the list
            // while you're selecting the elements in it:
            for(Event e : new ArrayList<Event>(eventList))
                if(e.ready()) {
                    System.out.println(e);
                    e.action();
                    eventList.remove(e);
                }
    }
}

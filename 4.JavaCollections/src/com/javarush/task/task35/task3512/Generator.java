package com.javarush.task.task35.task3512;

public class Generator<T> {
    Class<T> event;
    public Generator(Class<T> eventClass) {
        this.event=eventClass;
    }

    T newInstance() throws IllegalAccessException, InstantiationException {
        return (T)event.newInstance();
    }
}

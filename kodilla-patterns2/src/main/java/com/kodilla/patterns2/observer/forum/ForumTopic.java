package com.kodilla.patterns2.observer.forum;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ForumTopic implements Observable {
    private List<Observer> observers;
    private final List<String> messages;
    private final String name;

    public ForumTopic(String name) {
        this.observers = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.name = name;
    }

    public void addPost(String post) {
        messages.add(post);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
}

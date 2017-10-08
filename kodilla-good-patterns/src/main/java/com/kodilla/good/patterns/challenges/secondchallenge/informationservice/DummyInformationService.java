package com.kodilla.good.patterns.challenges.secondchallenge.informationservice;

import com.kodilla.good.patterns.challenges.secondchallenge.orderprocessing.User;

public class DummyInformationService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println(">>MAILTO:" + user.getEmail() + " >Drogi " + user.getUsername() + " dziękujemy za zakupy i zapraszamy ponownie.\n");
    }
}

package com.kodilla.good.patterns.challenges.secondChallenge;

public class DummyInformationService implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println(">>MAILTO:"+user.getEmail()+" >Drogi " + user.getUsername() + " dziękujemy za zakupy i zapraszamy ponownie.\n");
    }
}

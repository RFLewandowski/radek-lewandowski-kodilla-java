package com.kodilla.patterns2.adapter.company.oldhrsystem;

import lombok.Getter;

@Getter
public class Workers {
    private String[][] workers = {
            {"87101010001", "John", "Smith"},
            {"81101010002", "Ivone", "Novak"},
            {"83101010003", "Jessie", "Pinkman"},
            {"85101010004", "Walter", "White"},
            {"80101010005", "Calra", "Lanson"}
    };
    private double[] salaries = {
            4500.00,
            3700.00,
            4350.00,
            9000.00,
            6200.00
    };

    public String getWorker(int n) {
        if (n > salaries.length) {
            return "";
        }

        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }
}

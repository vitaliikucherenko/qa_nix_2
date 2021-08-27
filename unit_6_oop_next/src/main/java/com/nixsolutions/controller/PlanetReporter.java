package com.nixsolutions.controller;

import com.nixsolutions.data.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlanetReporter {

    public void start() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("select your option");
        String position;
        try {
            runNavigation();
            while ((position = reader.readLine()) != null) {
                result(position, reader);
                position = reader.readLine();
                if (position.equals("0")) {
                    System.exit(0);
                }
                result(position, reader);
            }
        } catch (IOException e) {
            System.out.println("problem: = " + e.getMessage());
        }
    }

    private void runNavigation() {
        System.out.println();
        System.out.println("if you want to get the acceleration of gravity for the Mercury, please enter 1");
        System.out.println("if you want to get the acceleration of gravity for the Venus, please enter 2");
        System.out.println("if you want to get the acceleration of gravity for the Earth, please enter 3");
        System.out.println("if you want to get the acceleration of gravity for the Mars, please enter 4");
        System.out.println("if you want to get the acceleration of gravity for the Jupiter, please enter 5");
        System.out.println("if you want to get the acceleration of gravity for the Saturn, please enter 6");
        System.out.println("if you want to get the acceleration of gravity for the Uranus, please enter 7");
        System.out.println("if you want to get the acceleration of gravity for the Neptune, please enter 8");
        System.out.println("if you want to get the acceleration of gravity for the Pluto, please enter 9");
        System.out.println("if you want to get the acceleration of gravity for all planets, please enter 10");
        System.out.println("if you want exit, please enter 0");
        System.out.println();
    }

    private void result(String position, BufferedReader reader) {
        BasePlanet mercury = new Mercury();
        BasePlanet venus = new Venus();
        BasePlanet earth = new Earth();
        BasePlanet mars = new Mars();
        BasePlanet jupiter = new Jupiter();
        BasePlanet saturn = new Saturn();
        BasePlanet uranus = new Uranus();
        BasePlanet neptune = new Neptune();
        BasePlanet pluto = new Pluto();
        switch (position) {
            case "1":
                dataPlanets(mercury);
                break;
            case "2":
                dataPlanets(venus);
                break;
            case "3":
                dataPlanets(earth);
                break;
            case "4":
                dataPlanets(mars);
                break;
            case "5":
                dataPlanets(jupiter);
                break;
            case "6":
                dataPlanets(saturn);
                break;
            case "7":
                dataPlanets(uranus);
                break;
            case "8":
                dataPlanets(neptune);
                break;
            case "9":
                dataPlanets(pluto);
                break;
            case "10":
                dataPlanets(mercury);
                dataPlanets(venus);
                dataPlanets(earth);
                dataPlanets(mars);
                dataPlanets(jupiter);
                dataPlanets(saturn);
                dataPlanets(uranus);
                dataPlanets(neptune);
                dataPlanets(pluto);
                break;
        }
        runNavigation();
    }

    private void dataPlanets(BasePlanet planet) {

        System.out.println("The " + planet.getClass().getSimpleName() + " has the acceleration of gravity " + planet.calcAccelerationOfGravity() + "m/s²");
    }
}

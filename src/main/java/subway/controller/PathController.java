package subway.controller;

import java.util.List;
import java.util.Scanner;
import subway.domain.station.Station;
import subway.domain.path.Path;
import subway.util.InputHandler;
import subway.util.PathValidator;
import subway.view.OutputView;

public class PathController {


    private static final String DISTANCE_INDEX = "1";
    private static final String TIME_INDEX = "2";


    InputHandler inputHandler = new InputHandler();
    OutputView outputView = new OutputView();
    Path path = new Path();

    public void operate(Scanner scanner, List<Station> stationsList) {
        outputView.printStandard();
        String standard = inputHandler.getStandard(scanner);
        if(standard.equals(DISTANCE_INDEX)){
            operateShortestDistance(scanner, stationsList);
        }
        if(standard.equals(TIME_INDEX)){
            operateShortestTime(scanner, stationsList);
        }
    }

    private void operateShortestTime(Scanner scanner, List<Station> stationsList) {
        String startStation = inputHandler.getStartStation(scanner);
        String endStation = inputHandler.getEndStation(scanner);
        if (validateDuplicate(startStation, endStation)) {
            return;
        }
        List<String> shortestTimePath = makeShortestTimePath(stationsList, startStation, endStation);
        if (shortestTimePath == null) {
            return;
        }
        printResult(shortestTimePath);
    }

    private void printResult(List<String> shortestTimePath) {
        int distance = path.getDistance(shortestTimePath);
        int time = path.getTime(shortestTimePath);
        outputView.printResult(distance, time, shortestTimePath);
    }

    private void operateShortestDistance(Scanner scanner, List<Station> stationsList) {
        String startStation = inputHandler.getStartStation(scanner);
        String endStation = inputHandler.getEndStation(scanner);
        if (validateDuplicate(startStation, endStation)) {
            return;
        }
        List<String> shortestDistancePath = makeShortestDistancePath(stationsList, startStation, endStation);
        if (shortestDistancePath == null)
            return;
        printResult(shortestDistancePath);
    }

    private List<String> makeShortestDistancePath(List<Station> stationsList, String startStation, String endStation) {
        List<String> shortestDistancePath;
        shortestDistancePath = validateDistanceLinked(stationsList, startStation, endStation);
        if (shortestDistancePath == null) {
            return null;
        }
        return shortestDistancePath;
    }

    private List<String> validateDistanceLinked(List<Station> stationsList, String startStation, String endStation) {
        List<String> shortestPath;
        try {
            shortestPath = path.getShortestDistancePath(stationsList, startStation, endStation);
        } catch (IllegalArgumentException e) {
            outputView.printLinkedError();
            return null;
        }
        return shortestPath;
    }

    private List<String> makeShortestTimePath(List<Station> stationsList, String startStation, String endStation) {
        List<String> shortestTimePath;
        shortestTimePath = validateTimeLinked(stationsList, startStation, endStation);
        if (shortestTimePath == null) {
            return null;
        }
        return shortestTimePath;
    }

    private List<String> validateTimeLinked(List<Station> stationsList, String startStation, String endStation) {
        List<String> shortestPath;
        try {
            shortestPath = path.getShortestTimePath(stationsList, startStation, endStation);
        } catch (IllegalArgumentException e) {
            outputView.printLinkedError();
            return null;
        }
        return shortestPath;
    }

    private boolean validateDuplicate(String startStation, String endStation) {
        try {
            new PathValidator(startStation, endStation);
        } catch (IllegalArgumentException e) {
            outputView.printError(e.getMessage());
            return true;
        }
        return false;
    }
}

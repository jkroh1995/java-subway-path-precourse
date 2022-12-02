package subway.controller;

import java.util.List;
import java.util.Scanner;
import subway.domain.station.Station;
import subway.util.InputHandler;
import subway.view.OutputView;

public class SubwayController {

    private final Scanner scanner;

    InputHandler inputHandler = new InputHandler();
    OutputView outputView = new OutputView();
    PathController pathController = new PathController();
    List<Station> stationList = new StationController().getStationList();

    public SubwayController(Scanner scanner){
        this.scanner = scanner;
        run();
    }

    public void run(){
        outputView.printMain();
        String function = inputHandler.getFunction(scanner);
        if(function.equals("1")){
            pathController.operate(scanner, stationList);
            run();
        }
    }
}

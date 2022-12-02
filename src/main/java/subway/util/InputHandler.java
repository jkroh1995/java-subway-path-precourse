package subway.util;

import java.util.Scanner;
import subway.view.InputView;
import subway.view.OutputView;

public class InputHandler {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public String getFunction(Scanner scanner) {
        try{
            String function = inputView.readFunction(scanner);
            new FunctionValidator(function);
            return function;
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getFunction(scanner);
        }
    }

    public String getStandard(Scanner scanner) {
        try{
            String standard = inputView.readFunction(scanner);
            new StandardValidator(standard);
            return standard;
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getStandard(scanner);
        }
    }

    public String getStartStation(Scanner scanner) {
        try{
            return inputView.readStartStation(scanner);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getStartStation(scanner);
        }
    }

    public String getEndStation(Scanner scanner) {
        try{
            return inputView.readEndStation(scanner);
        }catch (IllegalArgumentException e){
            outputView.printError(e.getMessage());
            return getStandard(scanner);
        }
    }
}

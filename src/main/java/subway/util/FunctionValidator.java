package subway.util;

public class FunctionValidator {

    private static final String LOOKUP = "1";
    private static final String QUIT = "Q";

    String function;

    public FunctionValidator(String function) {
        this.function = function;
        validate(function);
    }

    private void validate(String function) {
        if(!function.equals(LOOKUP)&&!function.equals(QUIT)){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }
}

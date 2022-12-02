package subway.util;

public class StandardValidator {

    private static final String BACK = "B";
    private static final String LENGTH = "1";
    private static final String TIME = "2";
    String standard;

    public StandardValidator(String standard) {
        this.standard = standard;
        validate(standard);
    }

    private void validate(String standard) {
        if(!standard.equals(LENGTH)&&!standard.equals(TIME)&&!standard.equals(BACK)){
            throw new IllegalArgumentException("[ERROR] 잘못된 입력입니다.");
        }
    }
}

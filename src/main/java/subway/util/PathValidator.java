package subway.util;

import subway.domain.path.Lines;

public class PathValidator {

    private static final String ERROR_DUPLICATE = "[ERROR] 출발역과 도착역이 동일합니다.";
    String startStation;
    String endStation;

    public PathValidator(String startStation, String endStation){
        this.startStation = startStation;
        this.endStation = endStation;
        validate(startStation, endStation);
    }

    private void validate(String startStation, String endStation) {
        validateDuplicate(startStation, endStation);
    }

    private void validateDuplicate(String startStation, String endStation) {
        if(startStation.equals(endStation)){
            throw new IllegalArgumentException(ERROR_DUPLICATE);
        }
    }
}

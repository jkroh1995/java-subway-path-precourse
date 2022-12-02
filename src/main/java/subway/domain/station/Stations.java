package subway.domain.station;

public enum Stations {

    STATION_NO_1("교대역"),
    STATION_NO_2("강남역"),
    STATION_NO_3("역삼역"),
    STATION_NO_4("남부터미널역"),
    STATION_NO_5("양재역"),
    STATION_NO_6("매봉역"),
    STATION_NO_7("양재시민의숲역");

    private String station;

    Stations(String station){
        this.station = station;
    }

    public String getStation(){
        return station;
    }
}

package subway.domain.path;

public enum Lines {
    LINE_NO_1("교대역","강남역",2,3),
    LINE_NO_2("강남역","역삼역",2,3),
    LINE_NO_3("교대역","남부터미널역",3,2),
    LINE_NO_4("남부터미널역","양재역",6,5),
    LINE_NO_5("강남역","양재역",2,8),
    LINE_NO_6("양재역","매봉역",1,1),
    LINE_NO_7("양재시민의숲역","양재역",10,3);

    private final String station1;
    private final String station2;
    private final int distance;
    private final int time;

    Lines(String station1, String station2, int distance, int time) {
        this.station1 = station1;
        this.station2 = station2;
        this.distance = distance;
        this.time = time;
    }

    public String getStation1(){
        return station1;
    }

    public String getStation2(){
        return station2;
    }

    public int getDistance(){
        return distance;
    }

    public int getTime(){
        return time;
    }
}

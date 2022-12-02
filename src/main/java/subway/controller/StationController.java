package subway.controller;

import java.util.List;
import subway.domain.station.Station;
import subway.domain.station.StationRepository;
import subway.domain.station.Stations;

public class StationController {

    public List<Station>getStationList(){
        for (Stations station : Stations.values()) {
            StationRepository.addStation(new Station(station.getStation()));
        }
        return StationRepository.stations();
    }
}

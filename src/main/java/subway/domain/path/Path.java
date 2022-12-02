package subway.domain.path;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.domain.station.Station;

public class Path {

    public List<String> getShortestDistancePath(List<Station> stationList,
                                                String startStation, String endStation) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        for (int i = 0; i < stationList.size(); i++) {
            graph.addVertex(stationList.get(i).getName());
        }
        for (Lines line : Lines.values()) {
            graph.setEdgeWeight(graph.addEdge(line.getStation1(), line.getStation2()), line.getDistance());
        }
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }

    public List<String> getShortestTimePath(List<Station> stationList, String startStation, String endStation) {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph<>(DefaultWeightedEdge.class);
        for (int i = 0; i < stationList.size(); i++) {
            graph.addVertex(stationList.get(i).getName());
        }
        for (Lines line : Lines.values()) {
            graph.setEdgeWeight(graph.addEdge(line.getStation1(), line.getStation2()), line.getTime());
        }
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstraShortestPath = new DijkstraShortestPath<>(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
    }

    public int getDistance(List<String> shortestDistancePath) {
        int distance = 0;
        for (int station = 0; station < shortestDistancePath.size() - 1; station++) {
            for (Lines line : Lines.values()) {
                distance = calculateDistance(shortestDistancePath, distance, station, line);
            }
        }
        return distance;
    }

    private int calculateDistance(List<String> shortestDistancePath, int distance, int station, Lines line) {
        if (shortestDistancePath.get(station).equals(line.getStation1())) {
            if (shortestDistancePath.get(station + 1).equals(line.getStation2())) {
                distance += line.getDistance();
            }
        }
        if (shortestDistancePath.get(station).equals(line.getStation2())) {
            if (shortestDistancePath.get(station + 1).equals(line.getStation1())) {
                distance += line.getDistance();
            }
        }
        return distance;
    }

    public int getTime(List<String> shortestDistancePath) {
        int time = 0;
        for (int station = 0; station < shortestDistancePath.size() - 1; station++) {
            for (Lines line : Lines.values()) {
                time = calculateTime(shortestDistancePath, time, station, line);
            }
        }
        return time;
    }

    private int calculateTime(List<String> shortestDistancePath, int time, int station, Lines line) {
        if (shortestDistancePath.get(station).equals(line.getStation1())) {
            if (shortestDistancePath.get(station + 1).equals(line.getStation2())) {
                time += line.getTime();
            }
        }
        if (shortestDistancePath.get(station).equals(line.getStation2())) {
            if (shortestDistancePath.get(station + 1).equals(line.getStation1())) {
                time += line.getTime();
            }
        }
        return time;
    }
}

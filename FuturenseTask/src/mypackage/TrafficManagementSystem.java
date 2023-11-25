package mypackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrafficManagementSystem {
    public static void main(String[] args) {
        // Real-Time Traffic Data Storage
        List<TrafficData> realTimeData = new ArrayList<>();
        realTimeData.add(new TrafficData(50, "14:00", "Main Street"));
        realTimeData.add(new TrafficData(30, "14:15", "Second Avenue"));

        // Historical Data Analysis
        Map<String, List<TrafficData>> historicalData = new HashMap<>();
        historicalData.put("Main Street", Arrays.asList(
                new TrafficData(40, "13:00", "Main Street"),
                new TrafficData(45, "13:30", "Main Street"),
                new TrafficData(55, "14:30", "Main Street")
        ));
        historicalData.put("Second Avenue", Arrays.asList(
                new TrafficData(25, "13:00", "Second Avenue"),
                new TrafficData(35, "13:30", "Second Avenue"),
                new TrafficData(40, "14:30", "Second Avenue")
        ));

        // Incident Logging
        List<Incident> incidentLog = new ArrayList<>();
        incidentLog.add(new Incident("Accident", "15:30", "Main Street"));
        incidentLog.add(new Incident("Roadblock", "16:00", "Third Avenue"));

        // Data Synchronization
        // In a real-world scenario, you might use a database or other distributed data storage mechanisms for synchronization.

        // Displaying Results
        System.out.println("Real-Time Traffic Data:");
        realTimeData.forEach(System.out::println);

        System.out.println("\nHistorical Data Analysis:");
        historicalData.forEach((location, data) -> {
            System.out.println("\n"+location + ":\n");
            data.forEach(System.out::println);
        });

        System.out.println("\nIncident Log:");
        incidentLog.forEach(System.out::println);
    }
}

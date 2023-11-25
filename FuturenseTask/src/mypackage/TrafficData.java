package mypackage;

import java.util.*;

class TrafficData {
    private int vehicleCount;
    private String time;
    private String location;

    public TrafficData(int vehicleCount, String time, String location) {
        this.vehicleCount = vehicleCount;
        this.time = time;
        this.location = location;
    }

    public int getVehicleCount() {
        return vehicleCount;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Vehicle Count: " + vehicleCount + ", Time: " + time + ", Location: " + location;
    }
}




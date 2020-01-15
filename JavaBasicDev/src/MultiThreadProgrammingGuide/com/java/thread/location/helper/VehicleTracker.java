package MultiThreadProgrammingGuide.com.java.thread.location.helper;

import MultiThreadProgrammingGuide.com.java.thread.location.model.FinalLocation;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class VehicleTracker {
    private Map<String, FinalLocation> locMap
            =new ConcurrentHashMap<String,FinalLocation>();
    public void updateLocation(String vehicleId,FinalLocation newLocation){
        locMap.put(vehicleId,newLocation);
    }

}

import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;

public class Airport {
    private Queue<String> toTakeOff;
    private Queue<String> land;
    private ArrayList<String> storeData;

    // Default constructor 
    public Airport() {
        this.toTakeOff = new LinkedList<>();
        this.land = new LinkedList<>();
        this.storeData = new ArrayList<>();
    }

    // It gives the information for the flights that are takingoff
    public void addTakeOff(String s) {
        this.toTakeOff.add(s);
    }

    // It gives the information for the flights that are landing
    public void addLanding(String s) {
        this.land.add(s);
    }

    // it checks detail of landing and takeoff for the flights 
    public String handleNextAction() {
        String r = "";
        
        if (this.toTakeOff.isEmpty() && this.land.isEmpty()) {
            r = "No plane is waiting to land or take-off.";
            return r;
        }
        if (!this.land.isEmpty()) {
            String flight = this.land.poll();
            r = "Flight " + flight + " is land.";
            this.storeData.add("Flight " + flight + " landed.");
            return r;
        }
        if (!this.toTakeOff.isEmpty()) {
            String flight = this.toTakeOff.poll();
            r = "Flight " + flight + " is taking off.";
            this.storeData.add("Flight " + flight + " taken off.");
            return r;
        }
        return r;
    }

      // It gives information of the plains that are waiting for takeoff/landing
    public String waitingPlanes() {
        String r = "";
        if (this.toTakeOff.isEmpty() && this.land.isEmpty()) {
            r = "No plane is in the land and take-off queues.";
            return r;
        }
        if (!this.land.isEmpty()) {
            r += "Planes waiting for land\n";
            for (String s : this.land) {
                r += s + "\n";
            }
        }

        if (!this.toTakeOff.isEmpty()) {
            r += "Planes waiting for take-off\n";
            for (String s : this.toTakeOff) {
                r += s + "\n";
            }
        }
        return r;
    }
    // It gives information for all the operation that are used in this program
    public String log() {
        String r = "";
        if (this.storeData.isEmpty()) {
            r = "No activity exists.";
            return r;
        }
        
        r = "List of the land/take-off storeData\n";
        for (String s : this.storeData) {
            r += s + "\n";
        }
        return r;
    }

}

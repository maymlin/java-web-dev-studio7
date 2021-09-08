package org.launchcode.studio7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseDisc {
    private String discType;    // CD or DVD
    private String discName;        // disc name
    private int capacity;     // storage size in MB
    private int remainingCapacity;  // unused storage in MB
    private int totalTracks;    // number of tracks on disc
    private boolean readOnly = true;   // whether the disc is read-only
    private boolean rewritable = false; // whether the disc is re-writable
    private ArrayList<HashMap<String, Integer>> trackList = new ArrayList<>();

    public void setDiscType(String aDiscType) { discType = aDiscType; }

    public String getDiscType() { return discType; }

    public void setDiscName(String aDiscName) { discName = aDiscName; }

    public String getDiscName() { return discName; }

    public void setCapacity(int aCapacity) { capacity = aCapacity; }

    public int getCapacity() { return capacity; }

    public void setRemainingCapacity(int aCapacity) {
        remainingCapacity = aCapacity;
    }
    public boolean updateRemainingCapacity(int data) {
        if (remainingCapacity - data > 0) {
            remainingCapacity -= data;
            return true;
        } else {
//            System.out.println("Data exceeds remaining storage capacity");
            return false;
        }
    }

    public int getRemainingCapacity() { return remainingCapacity; };

    public void setTotalTracks() { totalTracks = trackList.size(); }

    public int getTotalTracks() { return totalTracks; }

    public void setReadOnly(boolean aReadOnly) { readOnly = aReadOnly; }

    public boolean readOnly() { return readOnly; }

    public void setRewritable(boolean aRewritable) { rewritable = aRewritable; }

    public boolean getRewritable() { return rewritable; }

    public void setTrackList(ArrayList<HashMap<String, Integer>> aTrackList) {
        trackList = aTrackList;
        for (HashMap<String, Integer> track : aTrackList) {
            for (Map.Entry<String, Integer> trackEntry: track.entrySet()) {
                updateRemainingCapacity(trackEntry.getValue());
            }

        }
    }

    public ArrayList<HashMap<String, Integer>> getTrackList() { return trackList; }

    public boolean writeData(int data) {
        if (updateRemainingCapacity(data)) {
            System.out.println("Data written successfully");
            return true;
        } else {
            System.out.println("Data exceeds remaining storage capacity");
            return false;
        }
    }

    public void readTracks(int start, int end) {
        for (int i = start; end < totalTracks && start < end; ++i) {
            System.out.println(trackList.get(i));
        }
    }
}

package org.launchcode.studio7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DVD extends BaseDisc implements OpticalDisc {

    // TODO: Implement your custom interface.

    // TODO: Determine which fields, methods, and constructors can be extended from the base class and which ones
    //  need to be declared separately.

    public DVD(String name, int capacity, boolean rewritable) {
        setDiscType("DVD");
        setDiscName(name);
        setCapacity(capacity);
        setRemainingCapacity(capacity);

        if (rewritable) {
            setRewritable(true);
            setReadOnly(false);
        } else {
            setRewritable(false);
            setReadOnly(true);
        }
    }

    public DVD(String name, int capacity, boolean rewritable, ArrayList<HashMap<String, Integer>> trackList) {
        this(name, capacity, rewritable);

        setTrackList(trackList);

        setTotalTracks();
    }

    public boolean addTrack(HashMap<String, Integer> aTrack) {
        Map.Entry<String, Integer> trackEntry = (Map.Entry)aTrack;
        if (getRewritable() && writeData(trackEntry.getValue())) {
            getTrackList().add(aTrack);
            setTotalTracks();
            return true;
        }
        return false;
    }

    public boolean removeTrack(int trackNumber) {
        if (getRewritable()) {
            getTrackList().remove(trackNumber);
            setTotalTracks();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void spinDisc() {
        System.out.println("A DVD spans at a rate of 570 - 1600 rpm.");
    }

    @Override
    public String toString() {
        String outString = "*** DVD ***\nname: " + getDiscName()
                + "\ndisc type: " + getDiscType()
                + "\nstorage capacity: " + getCapacity()
                + "\nremaining capacity: " + getRemainingCapacity()
                + "\nrewritable: " + getRewritable()
                + "\ntrack list: " + getTrackList();
        return outString;
    }
}

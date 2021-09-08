package org.launchcode.studio7;

import java.util.ArrayList;
import java.util.HashMap;

public class CD extends BaseDisc implements OpticalDisc {

    // TODO: Implement your custom interface.

    // TODO: Determine which fields, methods, and constructors can be extended from the base class and which ones
    //  need to be declared separately.

    public CD(String name, int capacity) {
        setDiscType("CD");
        setDiscName(name);
        setCapacity(capacity);
        setRemainingCapacity(capacity);
        setRewritable(false);
        setReadOnly(true);
    }

    public CD(String name, int capacity, ArrayList<HashMap<String, Integer>> trackList) {
        this(name, capacity);
        setTrackList(trackList);
        setTotalTracks();
    }

    @Override
    public void spinDisc() {
        System.out.println("A CD spins at a rate of 200 - 500 rpm.");
    }

    @Override
    public String toString() {
        String outString = "*** CD ***\nname: " + getDiscName()
                + "\ndisc type: " + getDiscType()
                + "\nstorage capacity: " + getCapacity()
                + "\nremaining capacity: " + getRemainingCapacity()
                + "\nrewritable: " + getRewritable()
                + "\ntrack list: " + getTrackList();
        return outString;
    }
}

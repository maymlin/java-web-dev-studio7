package org.launchcode.studio7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args){

        ArrayList<HashMap<String, Integer>> dataTracks = new ArrayList<>();

        ArrayList<HashMap<String, Integer>> albumTracks = new ArrayList<HashMap<String, Integer>>();

        String[] dataTrackNames = {"day planner", "cv", "bank statements"};

        String[] albumTrackNames = {"Don't Panic", "Shiver", "Spies", "Sparks",
                "Yellow", "Trouble", "Parachutes", "High Speed",
                "We Never Change", "Everything's Not Lost"};

        albumTracks = generateTrackList(albumTrackNames);
        dataTracks = generateTrackList(dataTrackNames);

        // TODO: Declare and initialize a CD and a DVD object.

        DVD loveActually = new DVD("Love Actually", 4700, false);
        DVD backupDisc = new DVD("Backup DVD", 4700, true, dataTracks);
        CD parachutes = new CD("Parachutes by Coldplay", 700, albumTracks);

        // TODO: Call each CD and DVD method to verify that they work as expected.

        System.out.println(loveActually);
        System.out.println("\n" + backupDisc);
        System.out.println("\n" + parachutes);

        System.out.println("\n" + backupDisc);
    }

    static public ArrayList<HashMap<String, Integer>> generateTrackList(String[] trackNames) {
        ArrayList<HashMap<String, Integer>> newTrackList = new ArrayList<>();
        for (int i = 0; i < trackNames.length; ++i) {
            int randomNumber1 = (int)Math.floor(Math.random() * 5);
            int randomNumber2 = (int)Math.floor(Math.random() * 3 + 5);
            HashMap<String, Integer> trackEntry = new HashMap<>();
            trackEntry.put(trackNames[i], randomNumber2 * 7 + randomNumber1);
            newTrackList.add(trackEntry);
        }
        return newTrackList;
    }
}


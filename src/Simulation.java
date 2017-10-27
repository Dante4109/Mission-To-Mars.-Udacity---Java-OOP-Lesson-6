import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;


// This class is used for reading item data off of text files and adding those items to simulated rocket ships.
public class Simulation {

    private ArrayList<Item> itemList;

    public void addItems(Scanner phase) throws Exception {

        itemList = new ArrayList<>();

        //Loop through each line of the text file and add to the list.
        while (phase.hasNextLine()) {

            //split each line
            String lineString = phase.nextLine();
            String[] arrayList = lineString.split("=");
            Item item = new Item(arrayList[0], Integer.parseInt(arrayList[1]));
            itemList.add(item);

        }
        phase.close();


    }

    /**
     * Methods to create:
     *
     * loadU1: this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
     * It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and
     * filling that one until all items are loaded.
     * The method then returns the ArrayList of those U1 rockets that are fully loaded.

        loadU2: this method also takes the ArrayList of Items and starts creating U2 rockets and filling them with
     those items the same way as with U1 until all items are loaded. The method then returns the ArrayList of those
     U2 rockets that are fully loaded.

        runSimulation: this method takes an ArrayList of Rockets and calls launch and land methods for each of the
     rockets in the ArrayList. Every time a rocket explodes or crashes (i.e if launch or land return false) it will
     have to send that rocket again. All while keeping track of the total budget required to send each rocket safely
     to Mars. runSimulation then returns the total budget required to send all rockets (including the crashed ones).
     */

    public void loadU1(Scanner scanner) {
        ArrayList<Rocket> WaveU1 = new ArrayList<>();
        int numOfRockets = 0;
        Rocket U1 = createU1Rocket();

        //Loop through item list array
        for (Item aitemList : itemList) {

            // if the carry limit has been reached then the rocket is added to the current wave.
            // A new rocket is then created in its place and its loaded with items.
            if (!U1.canCarry(aitemList)) {
                WaveU1.add(U1);
                U1 = createU1Rocket();
                numOfRockets++;
            }
            U1.carry(aitemList);
        }

        // The rockets are added to the current wave.
        // The total number of rockets is then updated to reflected each new addition.
        WaveU1.add(U1);
        numOfRockets++;

        // Launch U1 rocket wave
        System.out.println("U1 Rocket Wave Launch initiated." + "\n");
        System.out.println("Rockets launched: " + numOfRockets);
        runSimulation(WaveU1);



    }

    public void loadU2(Scanner scanner) {
        ArrayList<Rocket> WaveU2 = new ArrayList<>();
        int numOfRockets = 0;
        Rocket U2 = createU2Rocket();

        //Loop through item list array
        for (Item aitemList : itemList) {

            // if the carry limit has been reached then the rocket is added to the current wave.
            // A new rocket is then created in its place and its loaded with items.
            if (!U2.canCarry(aitemList)) {
                WaveU2.add(U2);
                U2 = createU1Rocket();
                numOfRockets++;
            }
            U2.carry(aitemList);
        }

        // The rockets are added to the current wave.
        // The total number of rockets is then updated to reflected each new addition.
        WaveU2.add(U2);
        numOfRockets++;

        // Launch U2 rocket wave
        System.out.println("U2 Rocket Wave Launch initiated." + "\n");
        System.out.println("Rockets launched: " + numOfRockets + "\n");
        runSimulation(WaveU2);



    }


    private int runSimulation(ArrayList<Rocket> rockets) {
        int budget = 0;
        int currentRocket = 0;
        int failedMissions = 0;


        //Loop through all rockets in the array
        for (Rocket aRocket : rockets) {
            budget = budget + aRocket.rocketCost;
            currentRocket++;
            System.out.println("Current budget cost: " + budget);

            //If a a failure to launch/land occurs, resend a new rocket in its place.
            if (!aRocket.launch()) {
                budget = budget + aRocket.rocketCost;
                System.out.println("Rocket Launch: " + currentRocket + " Status: Failed" + "\n");
                System.out.println("Current budget: " + budget + "\n");
                System.out.println("Initiating new launch");
                failedMissions++;
            } else if (!aRocket.land()) {
                budget = budget + aRocket.rocketCost;
                System.out.println("Rocket Landing: " + currentRocket + " Status: Failed" + "\n");
                System.out.println("Current budget: " + budget + "\n");
                System.out.println("Initiating new launch" + "\n");
                failedMissions++;
            } else {

                System.out.println("Rocket: " + currentRocket + " Status: Success" + "\n");
            }


        }

        System.out.println("Total number of successful missions " + (currentRocket - failedMissions));
        System.out.println("Total number of failed missions " + failedMissions);
        System.out.println("Total Budget Cost: " + "$" + budget + "\n");
        return budget;
    }

    private Rocket createU1Rocket(){
        return new U1();
    }

    private Rocket createU2Rocket(){
        return new U2();
    }


}

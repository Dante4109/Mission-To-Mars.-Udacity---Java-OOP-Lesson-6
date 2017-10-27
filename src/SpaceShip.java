public interface SpaceShip {

    //Determines if the rocket will launch safely or combust. Return true or false.
    boolean launch();

    //Determines if the rocket will land safely or crash. Return true or false.
    boolean land();

    //Determines if the rocket can carry the indicated item. Return true or false.
    boolean canCarry(Item item);

    // Updates the current weight of the rocket based on the items being carried.
    int carry(Item item);
}



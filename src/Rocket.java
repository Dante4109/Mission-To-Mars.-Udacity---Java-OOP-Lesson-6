public class Rocket implements SpaceShip{

    int currentWeight;
    int cargoLimit;
    int rocketCost;

    @Override
    public boolean launch() {
        return true;
    }

    @Override
    public boolean land() {
        return true;
    }

    @Override
    public boolean canCarry(Item item) {
        int startingWeight = currentWeight + item.weight;
        return startingWeight <= cargoLimit;
    }

    @Override
    public int carry(Item item) {
        currentWeight = item.weight + currentWeight;
        return currentWeight;

    }
}


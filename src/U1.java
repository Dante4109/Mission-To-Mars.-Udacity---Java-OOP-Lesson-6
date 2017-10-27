import java.util.Random;

public class U1 extends Rocket{

    public U1() {
        currentWeight = 20000; // 10 tons
        cargoLimit = 36000; // 18 tons
        rocketCost = 100000000; // $100Million
    }


// Test if the launch was successful.
@Override
public boolean launch() {
        double divided = currentWeight / cargoLimit;
        double chanceOfExplosion = 5 * (currentWeight / cargoLimit);
        int ranNum = getRanNumber();
        //If random number is greater than or equal to chanceOfExplosion, the launch will fail and return false.
    System.out.println("Cargo Limit: " + cargoLimit);
    System.out.println("Current weight: " + currentWeight);
    System.out.println(divided);
    System.out.println("Launch Fail number is " + ranNum);
    System.out.println("Launch Success number is " + chanceOfExplosion);
    return !(ranNum <= chanceOfExplosion);

}

    // Test if the landing was successful.
    @Override
    public boolean land() {
        double divided = currentWeight / cargoLimit;
        double chanceOfCrash = 1 * (currentWeight / cargoLimit);
        int ranNum = getRanNumber();
        //If random number is greater than or equal to chanceOfCrash, the launch will fail and return false.
        System.out.println("Cargo Limit: " + cargoLimit);
        System.out.println("Current weight: " + currentWeight);
        System.out.println(divided);
        System.out.println("Land Fail number is " + ranNum);
        System.out.println("Land Success number is " + chanceOfCrash);
        return !(ranNum <= chanceOfCrash);

    }


//Create random number to test for successful Launch and landing sequence.
    private int getRanNumber() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(100) + 1;

    }

}


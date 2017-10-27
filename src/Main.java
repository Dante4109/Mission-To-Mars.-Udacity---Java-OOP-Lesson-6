import java.util.Scanner;
import java.io.File;

public class Main {


    public static void main(String[] args) throws Exception {
        Simulation simulation = new Simulation();


        //Phase 1
        Scanner phase1 = null;
        phase1 = new Scanner(new File("phase1.txt"));
        simulation.addItems(phase1);
        System.out.println("U1 Phase 1 Launch");
        simulation.loadU1(phase1);
        System.out.println("U2 Phase 1 Launch");
        simulation.loadU2(phase1);

        //Phase 2
        Scanner phase2 = null;
        phase2 = new Scanner(new File("phase2.txt"));
        simulation.addItems(phase2);
        System.out.println("U1 Phase 2 Launch");
        simulation.loadU1(phase1);
        System.out.println("U2 Phase 2 Launch");
        simulation.loadU2(phase1);


    }


}



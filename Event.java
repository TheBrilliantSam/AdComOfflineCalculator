import java.util.*;
public class Event extends Balance{
    private boolean valid = true;
    public Event(String event){
        super(event);
        if(event.equals("Atlantis") || event.equals("Winter") || event.equals("Stone")){
            int length = 100;
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[3][];
            gens[0] = new Generator[6];
            for(int i = 1; i <= 6; i++){
                gens[0][i - 1] = new Generator(3 + 2 * i, (int)(Math.pow(2, i)), 5, 5);
            }
            gens[1] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[1][i - 1] = new Generator(5 + 5 * i, (int)(Math.pow(3, i)), 5, 5);
            }
            gens[2] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[2][i - 1] = new Generator(5 + 10 * i, (int)(Math.pow(4, i)), 5, 5);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> i3 = new ArrayList<Integer>();
            i3.add(3);
            rsch.add(new Researcher("prod", 1, 3, 3, i1));
            rsch.add(new Researcher("prod", 1, 3, 3, i2));
            rsch.add(new Researcher("prod", 1, 3, 3, i3));
            rsch.add(new Researcher("com", 1, 4, 2, i1));
            rsch.add(new Researcher("com", 1, 6, 2, i2));
            rsch.add(new Researcher("com", 1, 8, 2, i3));
            super.instantiate(length, gens, rsch);
        } else if(event.equals("Crusade") || event.equals("Zombie") || event.equals("Ninja")){
            int length = 100;
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[3][];
            gens[0] = new Generator[6];
            for(int i = 1; i <= 6; i++){
                gens[0][i - 1] = new Generator(1 + i, 2 * (int)(Math.pow(3, i - 1)), 2 + i, 2);
            }
            gens[1] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[1][i - 1] = new Generator(3 * i, 3 * (int)(Math.pow(4, i - 1)), 4 + i, 2);
            }
            gens[2] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[2][i - 1] = new Generator(4 + 5 * (i - 1), 4 * (int)(Math.pow(6, i - 1)), 6 + i, 2);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> i3 = new ArrayList<Integer>();
            i3.add(3);
            rsch.add(new Researcher("prod", 1, 4, 2, i1));
            rsch.add(new Researcher("prod", 1, 6, 2, i2));
            rsch.add(new Researcher("prod", 1, 8, 2, i3));
            rsch.add(new Researcher("com", 1, 5, 2, i1));
            rsch.add(new Researcher("com", 1, 5, 2, i2));
            rsch.add(new Researcher("com", 1, 5, 2, i3));
            super.instantiate(length, gens, rsch);
        } else if(event.equals("Space") || event.equals("Cowboy")){
            int length = 100;
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            System.out.println("Event: " + event + "\n");
            gens = new Generator[3][];
            gens[0] = new Generator[6];
            for(int i = 1; i <= 6; i++){
                gens[0][i - 1] = new Generator(1 + 2 * i, (int)(Math.pow(2, i)), 3, 3);
            }
            gens[1] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[1][i - 1] = new Generator(2 + 4 * i, (int)(Math.pow(2, i + 1)), 4, 4);
            }
            gens[2] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[2][i - 1] = new Generator(4 + 8 * i, (int)(Math.pow(2, i + 2)), 5, 5);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> i3 = new ArrayList<Integer>();
            i3.add(3);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            global.add(3);
            rsch.add(new Researcher("prod", 1, 2, 4, global));
            rsch.add(new Researcher("luck", 0.00, 0.15, 0.00, global));
            rsch.add(new Researcher("com", 1, 3, 2, global));
            rsch.add(new Researcher("com", 1, 5, 2, i1));
            rsch.add(new Researcher("com", 1, 7, 2, i2));
            rsch.add(new Researcher("com", 1, 9, 2, i3));
            rsch.add(new Researcher("crit", 256, 1, 1, global));
            super.instantiate(length, gens, rsch);
        } else if(event.equals("Power") || event.equals("Oil")){
            int length = 32;
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[2][];
            gens[0] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[0][i - 1] = new Generator(3 + i, 3 * (int)(Math.pow(2, i - 1)), 1 + i, 2);
            }
            gens[1] = new Generator[3];
            for(int i = 1; i <= 3; i++){
                gens[1][i - 1] = new Generator(5 + 2 * i, 6 * (int)(Math.pow(3, i - 1)), 2 + 2 * i, 4);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            rsch.add(new Researcher("prod", 1, 3, 3, i2));
            rsch.add(new Researcher("luck", 0.00, 0.13, 0.02, global));
            rsch.add(new Researcher("com", 1, 3, 3, i1));
            rsch.add(new Researcher("com", 1, 4, 2, global));
            rsch.add(new Researcher("crit", 8, 1, 1, global));
            super.instantiate(length, gens, rsch);
        } else if(event.equals("Shield")){
            int length = 32;
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[2][];
            gens[0] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[0][i - 1] = new Generator(3 * (1 + i), (int)(Math.pow(3, i)), 4, 4);
            }
            gens[1] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[1][i - 1] = new Generator(9 * (1 + i), (int)(Math.pow(3, i)), 3, 3);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            rsch.add(new Researcher("prod", 1, 5, 2, i1));
            rsch.add(new Researcher("luck", 0.00, 0.13, 0.02, i2));
            rsch.add(new Researcher("com", 1, 4, 2, i1));
            rsch.add(new Researcher("com", 1, 4, 2, i2));
            rsch.add(new Researcher("crit", 8, 1, 1, global));
            super.instantiate(length, gens, rsch);
        } else if(event.equals("Export")){
            int length = 32;
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[2][];
            gens[0] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[0][i - 1] = new Generator(3 * (1 + i), (int)(Math.pow(3, i)), 4, 4);
            }
            gens[1] = new Generator[4]; // I hate you HH
                gens[1][0] = new Generator(18, 3, 3, 3);
                gens[1][1] = new Generator(60, 6, 3, 3);
                gens[1][2] = new Generator(120, 30, 3, 3);
                gens[1][3] = new Generator(240, 90, 3, 3);
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            rsch.add(new Researcher("prod", 1, 5, 2, i1));
            rsch.add(new Researcher("prod", 1, 5, 2, i2));
            rsch.add(new Researcher("com", 1, 4, 2, i1));
            rsch.add(new Researcher("com", 1, 4, 2, i2));
            super.instantiate(length, gens, rsch);
        } else if(event.equals("Farm") || event.equals("Science") || event.equals("Pet Show")){
            int length = 52;
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[2][];
            gens[0] = new Generator[8];
            for(int i = 1; i <= gens[0].length; i++){
                gens[0][i - 1] = new Generator(-1 + 3 * i, 2 * (int)(Math.pow(3, i - 1)), 3 * i, 3);
            }
            gens[1] = new Generator[9];
            for(int i = 1; i <= gens[1].length; i++){
                gens[1][i - 1] = new Generator(-2 + 6 * i, (int)(Math.pow(2, i + 1)), 3 * i, 3);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            rsch.add(new Researcher("prod", 1, 2, 4, i1));
            rsch.add(new Researcher("prod", 1, 6, 4, i2));
            rsch.add(new Researcher("prod", 1, 5, 4, global));
            rsch.add(new Researcher("luck", 0.00, 0.12, 0.00, global));
            rsch.add(new Researcher("com", 1, 3, 2, i1));
            rsch.add(new Researcher("com", 1, 7, 2, i2));
            rsch.add(new Researcher("crit", 32, 1, 1, global));
            super.instantiate(length, gens, rsch);
        } else if(event.equals("SVS") || event.equals("Vehicle Show")){
            int length = 52;
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[2][];
            gens[0] = new Generator[8];
            for(int i = 1; i <= gens[0].length; i++){
                gens[0][i - 1] = new Generator(-2 + 4 * i, 2 * (int)(Math.pow(3, i - 1)), 6, 3);
            }
            gens[1] = new Generator[9];
            for(int i = 1; i <= gens[1].length; i++){
                gens[1][i - 1] = new Generator(-2 + 6 * i, (int)(Math.pow(2, i + 1)), 5, 5);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            rsch.add(new Researcher("crit", 32, new int[] {1, 9, 36, 109, 336, 1149, 4276, 16629}, i1));
            rsch.add(new Researcher("crit", 64, new int[] {1, 9, 36, 109, 336, 1149, 4276, 16629}, i2));
            rsch.add(new Researcher("prod", 1, 5, 4, global));
            rsch.add(new Researcher("luck", 0.00, 0.15, 0.00, global));
            rsch.add(new Researcher("com", 1, 8, 4, i1));
            rsch.add(new Researcher("com", 1, 8, 2, i2));
            super.instantiate(length, gens, rsch);
        } else if(event.equals("Santa") || event.equals("Cockatrice") || event.equals("Supreme") || event.equals("MLG") || event.equals("CnC") || event.equals("Vacation") || event.equals("Motherland Games") || event.equals("Supervillain") || event.equals("Spooky") || event.equals("Potato Factory") || event.equals("SUV")){
            int length = 268;
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[4][];
            gens[0] = new Generator[7];
            for(int i = 1; i <= 7; i++){
                gens[0][i - 1] = new Generator(2 + 3 * (i - 1), 2 * (int)(Math.pow(3, i - 1)), 3 * i, 3);
            }
            gens[1] = new Generator[6];
            for(int i = 1; i <= 6; i++){
                gens[1][i - 1] = new Generator(6 + 15 * (i - 1), 3 * (int)(Math.pow(4, i - 1)), 6 * i, 3);
            }
            gens[2] = new Generator[5];
            for(int i = 1; i <= 5; i++){
                gens[2][i - 1] = new Generator(12 + 52 * (i - 1), 4 * (int)(Math.pow(6, i - 1)), 9 * i, 3);
            }
            gens[3] = new Generator[4];
            for(int i = 1; i <= 4; i++){
                gens[3][i - 1] = new Generator(20 + 190 * (i - 1), 5 * (int)(Math.pow(12, i - 1)), 12 * i, 3);
            }
            rsch = new ArrayList<Researcher>();
            ArrayList<Integer> i1 = new ArrayList<Integer>();
            i1.add(1);
            ArrayList<Integer> i2 = new ArrayList<Integer>();
            i2.add(2);
            ArrayList<Integer> i3 = new ArrayList<Integer>();
            i3.add(3);
            ArrayList<Integer> i4 = new ArrayList<Integer>();
            i4.add(4);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            global.add(3);
            global.add(4);
            rsch.add(new Researcher("prod", 1, 2, 4, i1));
            rsch.add(new Researcher("prod", 1, 4, 4, i2));
            rsch.add(new Researcher("prod", 1, 6, 4, i3));
            rsch.add(new Researcher("prod", 1, 8, 4, i4));
            rsch.add(new Researcher("prod", 1, 5, 4, global));
            rsch.add(new Researcher("luck", 0.00, 0.12, 0.00, global));
            rsch.add(new Researcher("crit", 32, 8, 2, global));
            rsch.add(new Researcher("com", 1, 3, 2, i1));
            rsch.add(new Researcher("com", 1, 5, 2, i2));
            rsch.add(new Researcher("com", 1, 7, 2, i3));
            rsch.add(new Researcher("com", 1, 9, 2, i4));
            rsch.add(new Researcher("com", 1, 2, 2, global));
            super.instantiate(length, gens, rsch);
        } else{
            System.out.println("Invalid event name. Please try again.");
            valid = false;
        }
        if(valid){
            System.out.println("----------------------------------------------------\n");
        }
    }
    
    public boolean isValid(){
        return valid;
    }
}
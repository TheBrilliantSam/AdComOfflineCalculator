import java.util.*;
public class Event extends Balance{
    private boolean valid = true;
    public Event(String event){
        super(event);
        event = event.toLowerCase();
        if(event.equals("motherland")){
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[5][];
            gens[0] = new Generator[11]; // potato
            for(int i = 1; i <= gens[0].length; i++){
                gens[0][i - 1] = new Generator(2 + i, 2 * (int)(Math.pow(2, i - 1)), 2, 2);
            }
            gens[1] = new Generator[11]; // land
            for(int i = 1; i <= gens[1].length; i++){
                gens[1][i - 1] = new Generator(3 + i, 3 * (int)(Math.pow(2, i - 1)), 2, 2);
            }
            gens[2] = new Generator[11]; // ore
            for(int i = 1; i <= gens[2].length; i++){
                gens[2][i - 1] = new Generator(4 + i, 4 * (int)(Math.pow(2, i - 1)), 2, 2);
            }
            gens[3] = new Generator[11]; // bullet
            for(int i = 1; i <= gens[3].length; i++){
                gens[3][i - 1] = new Generator(5 + i, 5 * (int)(Math.pow(2, i - 1)), 2, 2);
            }
            gens[4] = new Generator[11]; // placebo
            for(int i = 1; i <= gens[4].length; i++){
                gens[4][i - 1] = new Generator(6 + i, 6 * (int)(Math.pow(2, i - 1)), 2, 2);
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
            ArrayList<Integer> i5 = new ArrayList<Integer>();
            i5.add(5);
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            global.add(3);
            global.add(4);
            global.add(5);
            
            // rares
            rsch.add(new Researcher("prod", 1, 2, 2, i1));
            rsch.add(new Researcher("single prod", 1, 9, 2, i1));
            rsch.add(new Researcher("luck", 0.00, 0.05, 0.0225, 0.005, i1));
            rsch.add(new Researcher("com", 1, 2, 2, i1));
            rsch.add(new Researcher("prod", 1, 2, 2, i2));
            rsch.add(new Researcher("single prod", 1, 9, 2, i2));
            rsch.add(new Researcher("luck", 0.00, 0.05, 0.0225, 0.005, i2));
            rsch.add(new Researcher("com", 1, 2, 2, i2));
            rsch.add(new Researcher("prod", 1, 2, 2, i3));
            rsch.add(new Researcher("single prod", 1, 9, 2, i3));
            rsch.add(new Researcher("luck", 0.00, 0.05, 0.0225, 0.005, i3));
            rsch.add(new Researcher("com", 1, 2, 2, i3));
            rsch.add(new Researcher("prod", 1, 2, 2, i4));
            rsch.add(new Researcher("single prod", 1, 9, 2, i4));
            rsch.add(new Researcher("luck", 0.00, 0.05, 0.0225, 0.005, i4));
            rsch.add(new Researcher("com", 1, 2, 2, i4));
            rsch.add(new Researcher("prod", 1, 2, 2, i5));
            rsch.add(new Researcher("single prod", 1, 9, 2, i5));
            rsch.add(new Researcher("luck", 0.00, 0.05, 0.0225, 0.005, i5));
            rsch.add(new Researcher("com", 1, 2, 2, i5));
            
            //epics
            rsch.add(new Researcher("discount", 1, 10, 10, i1));
            rsch.add(new Researcher("crit", 1, 4, 4, i1));
            rsch.add(new Researcher("discount", 1, 10, 10, i2));
            rsch.add(new Researcher("crit", 1, 4, 4, i2));
            rsch.add(new Researcher("discount", 1, 10, 10, i3));
            rsch.add(new Researcher("crit", 1, 4, 4, i3));
            rsch.add(new Researcher("discount", 1, 10, 10, i4));
            rsch.add(new Researcher("crit", 1, 4, 4, i4));
            rsch.add(new Researcher("discount", 1, 10, 10, i5));
            rsch.add(new Researcher("crit", 1, 4, 4, i5));
            
            //supremes
            rsch.add(new Researcher("prod", 1, 2, 2, global));
            rsch.add(new Researcher("discount", 1, 10, 10, global));
            rsch.add(new Researcher("luck", 0.01, 0.08, 0.05, 0.01, global));
            rsch.add(new Researcher("crit", 2, 4, 4, global));
            rsch.add(new Researcher("com", 1, 2, 2, global));
            
            super.instantiate(gens, rsch);
            
        } else if(event.equals("atlantis") || event.equals("winter") || event.equals("stone")){
            int length = 100;
            Time duration = new Time(length + "h");
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
            rsch.add(new Researcher("com", 1, 4, 2, i1));
            rsch.add(new Researcher("prod", 1, 3, 3, i2));
            rsch.add(new Researcher("com", 1, 6, 2, i2));
            rsch.add(new Researcher("prod", 1, 3, 3, i3));
            rsch.add(new Researcher("com", 1, 8, 2, i3));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("crusade") || event.equals("zombie") || event.equals("ninja")){
            int length = 100;
            Time duration = new Time(length + "h");
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
            rsch.add(new Researcher("com", 1, 5, 2, i1));
            rsch.add(new Researcher("prod", 1, 6, 2, i2));
            rsch.add(new Researcher("com", 1, 5, 2, i2));
            rsch.add(new Researcher("prod", 1, 8, 2, i3));
            rsch.add(new Researcher("com", 1, 5, 2, i3));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("space") || event.equals("cowboy")){ //updated
            int length = 100;
            Time duration = new Time(length + "h");
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
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
            rsch.add(new Researcher("com", 1, 5, 2, i1));
            rsch.add(new Researcher("com", 1, 7, 2, i2));
            rsch.add(new Researcher("com", 1, 9, 2, i3));
            rsch.add(new Researcher("prod", 1, 2, 4, global));
            rsch.add(new Researcher("luck", 0.00, 0.15, 0.00, global));
            rsch.add(new Researcher("com", 1, 3, 2, global));
            rsch.add(new Researcher("crit", 256, 1, 1, global, true));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("power") || event.equals("oil")){ //updated
            int length = 32;
            Time duration = new Time(length + "h");
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
            rsch.add(new Researcher("com", 1, 3, 3, i1));
            rsch.add(new Researcher("prod", 1, 3, 3, i2));
            rsch.add(new Researcher("luck", 0.00, 0.13, 0.02, global));
            rsch.add(new Researcher("com", 1, 4, 2, global));
            rsch.add(new Researcher("crit", 8, 1, 1, global, true));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("shield")){ //updated
            int length = 32;
            Time duration = new Time(length + "h");
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
            rsch.add(new Researcher("com", 1, 4, 2, i1));
            rsch.add(new Researcher("luck", 0.00, 0.13, 0.02, i2));
            rsch.add(new Researcher("com", 1, 4, 2, i2));
            rsch.add(new Researcher("crit", 16, 1, 1, global, true));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("export")){ //updated
            int length = 32;
            Time duration = new Time(length + "h");
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
            ArrayList<Integer> global = new ArrayList<Integer>();
            global.add(1);
            global.add(2);
            rsch.add(new Researcher("prod", 1, 5, 2, i1));
            rsch.add(new Researcher("com", 1, 4, 2, i1));
            rsch.add(new Researcher("prod", 1, 5, 2, i2));
            rsch.add(new Researcher("com", 1, 4, 2, i2));
            rsch.add(new Researcher("crit", 16, 1, 1, global, true));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("farm") || event.equals("science") || event.equals("pet show") || event.equals("architecture") || event.equals("infrastructure")){ //updated
            int length = 52;
            Time duration = new Time(length + "h");
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
            rsch.add(new Researcher("com", 1, 3, 2, i1));
            rsch.add(new Researcher("prod", 1, 6, 4, i2));
            rsch.add(new Researcher("com", 1, 7, 2, i2));
            rsch.add(new Researcher("prod", 1, 5, 4, global));
            rsch.add(new Researcher("luck", 0.00, 0.12, 0.00, global));
            rsch.add(new Researcher("crit", 32, 1, 1, global, true));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("svs") || event.equals("vehicle show")){
            int length = 52;
            Time duration = new Time(length + "h");
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
            rsch.add(new SVSResearcher(32, i1));
            rsch.add(new Researcher("com", 1, 8, 4, i1));
            rsch.add(new SVSResearcher(64, i2));
            rsch.add(new Researcher("com", 1, 8, 2, i2));
            rsch.add(new Researcher("prod", 1, 5, 4, global));
            rsch.add(new Researcher("luck", 0.00, 0.15, 0.00, global));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("dino") || event.equals("monster hunt") || event.equals("halloween") || event.equals("mmh") || event.equals("anniversary") || event.equals("celebration") || event.equals("christmas") || event.equals("merry") || event.equals("santa") || event.equals("cockatrice") || event.equals("supreme") || event.equals("mlg") || event.equals("cnc") || event.equals("vacation") || event.equals("motherland games") || event.equals("supervillain") || event.equals("spooky") || event.equals("potato factory") || event.equals("suv")){
            int length = 268;
            Time duration = new Time(length + "h");
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
            rsch.add(new Researcher("com", 1, 3, 2, i1));
            rsch.add(new Researcher("prod", 1, 4, 4, i2));
            rsch.add(new Researcher("com", 1, 5, 2, i2));
            rsch.add(new Researcher("prod", 1, 6, 4, i3));
            rsch.add(new Researcher("com", 1, 7, 2, i3));
            rsch.add(new Researcher("prod", 1, 8, 4, i4));
            rsch.add(new Researcher("com", 1, 9, 2, i4));
            rsch.add(new Researcher("prod", 1, 5, 4, global));
            rsch.add(new Researcher("luck", 0.00, 0.12, 0.00, global));
            rsch.add(new Researcher("crit", 32, 8, 2, global));
            rsch.add(new Researcher("com", 1, 2, 2, global));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("egypt") || event.equals("japan")){ //updated
            int length = 148;
            Time duration = new Time(length + "h");
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[3][];
            gens[0] = new Generator[7];
                for(int i = 1; i <= gens[0].length; i++){
                    gens[0][i - 1] = new AgesGenerator(i, 2 * (int)(Math.pow(3, i - 2)), 3, i);
                }
                gens[0][0] = new AgesGenerator(2, 2, 3, 1);
                gens[0][1] = new AgesGenerator(2, 4, 3, 2);
            gens[1] = new Generator[6];
                gens[1][0] = new AgesGenerator(3, 3, 3, 2);
                gens[1][1] = new AgesGenerator(6, 12, 3, 4);
                gens[1][2] = new AgesGenerator(8, 32, 3, 6);
                gens[1][3] = new AgesGenerator(9, 48, 3, 8);
                gens[1][4] = new AgesGenerator(12, 192, 3, 10);
                gens[1][5] = new AgesGenerator(15, 768, 3, 12);
            gens[2] = new Generator[5];
                gens[2][0] = new AgesGenerator(4, 4, 3, 3);
                gens[2][1] = new AgesGenerator(6, 18, 3, 6);
                gens[2][2] = new AgesGenerator(9, 24, 3, 9);
                gens[2][3] = new AgesGenerator(14, 144, 3, 12);
                gens[2][4] = new AgesGenerator(19, 864, 3, 15);
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
            rsch.add(new Researcher("luck", 0.00, 0.12, 0.00, i1));
            rsch.add(new Researcher("crit", 8, 8, 2, i1));
            rsch.add(new Researcher("com", 1, 6, 4, i1));
            rsch.add(new Researcher("luck", 0.00, 0.12, 0.00, i2));
            rsch.add(new Researcher("crit", 16, 8, 2, i2));
            rsch.add(new Researcher("com", 1, 10, 4, i2));
            rsch.add(new Researcher("luck", 0.00, 0.12, 0.00, i3));
            rsch.add(new Researcher("crit", 32, 8, 2, i3));
            rsch.add(new Researcher("com", 1, 14, 4, i3));
            rsch.add(new Researcher("prod", 1, 12, 4, global));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("scandinavia") || event.equals("scand")){ //updated
            int length = 148;
            Time duration = new Time(length + "h");
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[3][];
            gens[0] = new Generator[7];
                for(int i = 1; i <= gens[0].length; i++){
                    gens[0][i - 1] = new AgesGenerator(3 + 2 * i, (int)(Math.pow(2, i)), 3, 1);
                }
            gens[1] = new Generator[6];
                for(int i = 1; i <= gens[1].length; i++){
                    gens[1][i - 1] = new AgesGenerator(5 + 5 * i, (int)(Math.pow(3, i)), 4, 1);
                }
            gens[2] = new Generator[5];
                for(int i = 1; i <= gens[2].length; i++){
                    gens[2][i - 1] = new AgesGenerator(5 + 10 * i, (int)(Math.pow(4, i)), 5, 1);
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
            rsch.add(new Researcher("prod", 1, 3, 3, i1));
            rsch.add(new Researcher("luck", 0.00, 0.0275, 0.0825, 0.055, i1));
            rsch.add(new Researcher("com", 1, 4, 4, i1));
            rsch.add(new Researcher("prod", 1, 3, 3, i2));
            rsch.add(new Researcher("luck", 0.00, 0.0275, 0.0825, 0.055, i2));
            rsch.add(new Researcher("com", 1, 8, 4, i2));
            rsch.add(new Researcher("prod", 1, 3, 3, i3));
            rsch.add(new Researcher("luck", 0.00, 0.0275, 0.0825, 0.055, i3));
            rsch.add(new Researcher("com", 1, 12, 4, i3));
            rsch.add(new Researcher("prod", 1, 2, 4, global));
            rsch.add(new Researcher("crit", 2, 1, 1, global, true));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("careers") || event.equals("innovation")){ //updated 
            int length = 76;
            Time duration = new Time(length + "h");
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[4][];
            gens[0] = new Generator[5];
            for(int i = 1; i <= gens[0].length; i++){
                gens[0][i - 1] = new Generator(5 + 2 * (i - 1), (int)(Math.pow(2, i)), 3 * i, 3);
            }
            gens[1] = new Generator[5];
            for(int i = 1; i <= gens[1].length; i++){
                gens[1][i - 1] = new Generator(10 + 5 * (i - 1), (int)(Math.pow(3, i)), 6 * i, 3);
            }
            gens[2] = new Generator[5];
            for(int i = 1; i <= gens[2].length; i++){
                gens[2][i - 1] = new Generator(15 + 10 * (i - 1), (int)(Math.pow(4, i)), 9 * i, 3);
            }
            gens[3] = new Generator[5];
                gens[3][0] = new Generator(20, 5, 12, 3);
                gens[3][1] = new Generator(30, 20, 24, 3);
                gens[3][2] = new Generator(40, 100, 36, 3);
                gens[3][3] = new Generator(50, 500, 42, 3);
                gens[3][4] = new Generator(60, 5000, 48, 3);
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
            rsch.add(new Researcher("com", 1, 3, 2, i1));
            rsch.add(new Researcher("prod", 1, 4, 4, i2));
            rsch.add(new Researcher("com", 1, 5, 2, i2));
            rsch.add(new Researcher("prod", 1, 6, 4, i3));
            rsch.add(new Researcher("com", 1, 7, 2, i3));
            rsch.add(new Researcher("prod", 1, 8, 4, i4));
            rsch.add(new Researcher("com", 1, 9, 2, i4));
            rsch.add(new Researcher("prod", 1, 5, 4, global));
            rsch.add(new Researcher("crit", 2, 1, 1, global, true));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("aztec")){ //updated
            int length = 148;
            Time duration = new Time(length + "h");
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[3][];
            gens[0] = new Generator[7];
            for(int i = 1; i <= 6; i++){
                gens[0][i - 1] = new Generator(3 + 2 * (i - 1), (int)(Math.pow(2, i)), 3, 3);
            }
            gens[0][6] = new Generator(13, 64, 3, 3);
            gens[1] = new Generator[6];
            for(int i = 1; i <= 5; i++){
                gens[1][i - 1] = new Generator(6 + 4 * (i - 1), (int)(Math.pow(2, 1 + i)), 4, 4);
            }
            gens[1][5] = new Generator(22, 64, 4, 4);
            gens[2] = new Generator[5];
            for(int i = 1; i <= 3; i++){
                gens[2][i - 1] = new Generator(12 + 8 * (i - 1), 4 * (int)(Math.pow(2, 2 + i)), 5, 5);
            }
            gens[2][3] = new Generator(28, 32, 5, 5);
            gens[2][4] = new Generator(36, 64, 5, 5);
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
            rsch.add(new Researcher("prod", 1, 2, 4, i1));
            rsch.add(new Researcher("com", 1, 5, 2, i1));
            rsch.add(new Researcher("prod", 1, 2, 4, i2));
            rsch.add(new Researcher("com", 1, 7, 2, i2));
            rsch.add(new Researcher("prod", 1, 2, 4, i3));
            rsch.add(new Researcher("com", 1, 9, 2, i3));
            rsch.add(new Researcher("prod", 1, 2, 4, global));
            rsch.add(new Researcher("discount", 1, 1, 10, global));
            rsch.add(new Researcher("luck", 0.00, 0.15, 0.00, global));
            rsch.add(new Researcher("com", 1, 3, 2, global));
            rsch.add(new Researcher("crit", 256, 1, 1, global, true));
            super.instantiate(duration, gens, rsch);
        } else if(event.equals("music")){ //updated
            int length = 148;
            Time duration = new Time(length + "h");
            Generator[][] gens;
            ArrayList<Researcher> rsch;
            //System.out.println("Event: " + event + "\n");
            gens = new Generator[4][];
            gens[0] = new Generator[6];
            for(int i = 1; i <= gens[0].length; i++){
                gens[0][i - 1] = new Generator(5 + 2 * (i - 1), (int)(Math.pow(2, i)), 3 * i, 3);
            }
            gens[1] = new Generator[5];
            for(int i = 1; i <= gens[1].length; i++){
                gens[1][i - 1] = new Generator(6 + 15 * (i - 1), 3 * (int)(Math.pow(4, i - 1)), 6 * i, 3);
            }
            gens[2] = new Generator[4];
            for(int i = 1; i <= gens[2].length; i++){
                gens[2][i - 1] = new Generator(12 + 52 * (i - 1), 4 * (int)(Math.pow(6, i - 1)), 9 * i, 3);
            }
            gens[3] = new Generator[3];
            for(int i = 1; i <= gens[3].length; i++){
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
            rsch.add(new Researcher("prod", 1, 15, 6, i1));
            rsch.add(new Researcher("com", 1, 5, 2, i1));
            rsch.add(new Researcher("prod", 1, 18, 6, i2));
            rsch.add(new Researcher("com", 1, 7, 2, i2));
            rsch.add(new Researcher("prod", 1, 21, 6, i3));
            rsch.add(new Researcher("com", 1, 9, 2, i3));
            rsch.add(new Researcher("prod", 1, 24, 6, i4));
            rsch.add(new Researcher("com", 1, 10, 2, i4));
            rsch.add(new Researcher("crit", 3, 1, 1, global, true));
            super.instantiate(duration, gens, rsch);
        } else{
            System.out.println("Event name not recognized. Please try again.");
            valid = false;
        }
        if(valid){
            System.out.println("-------------------------------------------------------------------\n");
        }
    }
    
    public boolean isValid(){
        return valid;
    }
}
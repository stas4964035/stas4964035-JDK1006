import java.util.HashMap;


public class Main {
    public static void main(String[] args) {
        final int ROUNDS = 100;
        HashMap<Integer, Boolean> result = new HashMap();
        Game g = new Game();
        for (int i = 0; i < ROUNDS; i++) {
            result.put(i, g.startGame(null));
        }
        int wins = 0;
        for(Boolean b: result.values()){
            if(b) wins++;
        }
        double res = ((double)ROUNDS / wins) * 10;
        System.out.println("Full random door select win chances:" + res + "(" + wins + "/" + ROUNDS + ")");



        result = new HashMap();
        g = new Game();
        for (int i = 0; i < ROUNDS; i++) {
            result.put(i, g.startGame(true));
        }
        wins = 0;
        for(Boolean b: result.values()){
            if(b) wins++;
        }
        res = ((double) ROUNDS / wins) * 10;
        System.out.println("Do not change selected door win chances:" + res + "(" + wins + "/" + ROUNDS + ")");


        result = new HashMap();
        g = new Game();
        for (int i = 0; i < ROUNDS; i++) {
            result.put(i, g.startGame(true));
        }
        wins = 0;
        for(Boolean b: result.values()){
            if(b) wins++;
        }
        res = ((double) ROUNDS / wins) * 10;
        System.out.println("Change selected door win chances:" + res + "(" + wins + "/" + ROUNDS + ")");





    }

}

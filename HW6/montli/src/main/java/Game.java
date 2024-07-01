import java.util.Random;

public class Game {

    boolean[] doors;
    int playerSelect;
    int hostSelect;
    int finalSelect;

    public Boolean startGame(Boolean strategy) {
        doors = new boolean[]{false, false, false};
        doors[rand()] = true;
        playerSelect();
        hostSelect();
        hostOpenDoor();
        playerFinalSelect(strategy);
        return playerWin();
//        System.out.println("Player select: " + (playerSelect + 1) + " Host select: " + (hostSelect + 1)
//                + "; FinalSelect: " + (finalSelect + 1) + "; is player win: " + playerWin());
    }

    private int rand() {
        Random rand = new Random();
        return rand.nextInt(3);
    }

    private int playerSelect() {
        playerSelect = rand();
        return playerSelect;
    }


    private int hostSelect() {
        hostSelect = rand();
        return hostSelect;
    }

    private void hostOpenDoor() {
        while (hostSelect == playerSelect || doors[hostSelect]) {
            hostSelect();
        }
    }

    /*
    Boolean strategy парметр, который указывает по какой стратегии играет игрок. true - оставляет свой выбор,
    false - меняет свой выбор, null - использует рандом
     */
    private void playerFinalSelect(Boolean strategy) {
        if (strategy == null) {
            finalSelect = rand();
        } else if (strategy == true) {
            finalSelect = playerSelect;
        } else if (strategy == false) {
            do {
                finalSelect = rand();
            } while (finalSelect == playerSelect || finalSelect == hostSelect);
        }

    }

    private boolean playerWin() {
        return doors[finalSelect];
    }

    @Override
    public String toString() {
        return "Door 1: " + doors[0] + "; Door 2: " + doors[1] + "; Door 3: " + doors[2] + ";";
    }
}

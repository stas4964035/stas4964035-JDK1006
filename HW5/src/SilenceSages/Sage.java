package SilenceSages;

import java.util.Random;

public class Sage extends Thread {
    private static final int MAX_EATS = 3;
    private int eatCount = 0;
    private static final long EAT_TIME = 2000;
    public String name;
    private int chair, left, right;
    Boolean[] spoons;
    Random rand = new Random();

    public Sage(String name, int chair, Boolean[] spoons) {
        this.name = name;
        this.chair = chair;
        this.spoons = spoons;
        this.left = chair;
        this.right = chair + 1 >= spoons.length ? 0 : chair + 1;
    }

    @Override
    public void run() {
        try {
            while (eatCount < MAX_EATS) {
                if (takeSpoons()) {

                    eat();
                    dropSpoons();
                    prey();

                } else {
                    prey();
                }
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s eat %d times\n", name, eatCount);
    }

    private boolean takeSpoons() {
        synchronized (spoons) {
            if (spoons[right] && spoons[left]) {
                spoons[right] = false;
                spoons[left] = false;
                System.out.printf("%s take spoons\n", name);
                return true;
            } else {
                System.out.printf("%s cant take spoons\n", name);
                return false;
            }

        }
    }

    private void eat() throws InterruptedException {
        System.out.printf("%s eat\n", name);
        eatCount++;
        sleep(rand.nextLong(EAT_TIME));
    }

    private void prey() throws InterruptedException {
        System.out.printf("%s preys\n", name);
        sleep(rand.nextLong(EAT_TIME));
    }

    private void dropSpoons() {
        synchronized (spoons) {
            spoons[left] = true;
            spoons[right] = true;
            System.out.printf("%s drop spoons\n", name);
        }
    }
}

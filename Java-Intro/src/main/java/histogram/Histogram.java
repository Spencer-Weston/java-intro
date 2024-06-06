package histogram;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.IOException;

public class Histogram {

    public static class Pair {
        private Integer x;
        private Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }

        public Integer getX() {
            return x;
        }

        public Integer getY() {
            return y;
        }

        public void setX(Integer x) {
            this.x = x;
        }

        public void setY(Integer y) {
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner data = null;
        ArrayList<Integer> count;
        Integer idx;

        System.out.println("Working Directory = " + System.getProperty("user.dir"));

        try {
            data = new Scanner(new File("data/test.dat"));
        }
        catch ( IOException e) {
            System.out.println("Unable to open data file");
            e.printStackTrace();
            System.exit(0);
        }

        count = new ArrayList<Integer>(10);
        for (Integer i = 0; i < 10; i++) {
            count.add(i,0);
        }

        while(data.hasNextInt()) {
            idx = data.nextInt();
            count.set(idx,count.get(idx)+1);
        }

        List<Pair> pairs = new ArrayList<>();

        // parsing a pair object
        for (int i = 0; i < 10; i++) {
            pairs.add(new Pair(i, i * 2));
        }

        parsePairs(pairs);

        idx = 0;
        for(Integer i : count) {
            System.out.println(idx + " occured " + i + " times.");
            idx++;
        }
    }
    public static void parsePairs(List<Pair> args) {
        for (Pair pair : args) {
            System.out.println("Pair: x = " + pair.getX() + ", y = " + pair.getY());
    }
    }
}


package icpc;

import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        ICPC program = new ICPC();
        program.run();
    }
}

class ICPC {
    private static final String delimiter = " ";

    public ICPC() {

    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int w = scanner.nextInt();
        int h = scanner.nextInt();

        int n = scanner.nextInt();

        int[][] desired = new int[n][2];
        int subSum = 0;
        for (int i = 0; i < n; i++) {
            var list = new int[]{scanner.nextInt(), scanner.nextInt()};
            desired[i] = list;
            subSum += list[0] * list[1];
        }

        int area = w * h;

        print(area - subSum);

    }

    void print(Object s) {
        System.out.println(s);
    }

    void print(List<String> l) {
        for (String s : l) {
            print(s);
        }
    }
}
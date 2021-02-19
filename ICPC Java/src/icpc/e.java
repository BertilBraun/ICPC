package icpc;

import java.util.Arrays;
import java.util.LinkedList;
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

        int q = scanner.nextInt();

        int[][] field = new int[h][w];

        for (int i = 0; i < h; i++) {
            var list = new int[w];
            for (int j = 0; j < w; j++) {
                list[j] = (scanner.nextInt());
            }
            field[i] = list;
        }

        int[][] sumfield = new int[h][w];

        sumfield[0] = new int[w];
        sumfield[0][0] = field[0][0];
        for (int j = 1; j < w; j++)
            sumfield[0][j] = field[0][j] + sumfield[0][j - 1];
        for (int i = 1; i < h; i++) {
            var list = new int[w];
            list[0] = field[i][0] + sumfield[i - 1][0];
            sumfield[i] = list;
        }
        // sumlist contains borders

        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                sumfield[i][j] = field[i][j] + sumfield[i - 1][j] + sumfield[i][j - 1] - sumfield[i - 1][j - 1];

            }
        }


        for (int i = 0; i < q; i++) {
            var list = new int[4];
            for (int j = 0; j < 4; j++) {
                list[j] = scanner.nextInt();
            }

            int x0 = list[0] - 1;
            int x1 = list[2] - 1;
            int y0 = list[1] - 1;
            int y1 = list[3] - 1;
            if (x0 > x1) {
                int tmp = x0;
                x0 = x1;
                x1 = tmp;
            }
            if (y0 > y1) {
                int tmp = y0;
                y0 = y1;
                y1 = tmp;
            }

            int sum = sumfield[y1][x1];
            if (y0 > 0)
                sum -= sumfield[y0 - 1][x1];
            if (x0 > 0)
                sum -= sumfield[y1][x0 - 1];
            if (y0 > 0 && x0 > 0)
                sum += sumfield[y0 - 1][x0 - 1];
            // int sum = 0;
            // for (int x = x0; x <= x1; x++) {
            //     for (int y = y0; y <= y1; y++) {
            //         sum += field[y][x];
            //     }
            // }
            print(sum);
        }
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
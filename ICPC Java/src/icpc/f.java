package icpc;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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

        while (true) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();

            if (m == 0) {
                return;
            }

            scanner.nextLine();

            int[][] grid = new int[m][n];
            for (int i = 0; i < m; i++) {
                grid[i] = new int[n];
                String line = scanner.nextLine();
                for (int j = 0; j < n; j++) {
                    grid[i][j] = line.charAt(j) == '*' ? 0 : 1;
                }
            }

            matchGrid(grid, m, n);
        }
    }

    class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair{" + "x=" + x + ", y=" + y + '}';
        }
    }

    void matchGrid(int[][] grid, int m, int n) {
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i] = new boolean[n];
        }

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (visited[i][j]) continue;
                if (grid[i][j] == 0) continue;

                count++;

                Queue<Pair> queue = new LinkedList<>();
                queue.add(new Pair(j, i));

                while (!queue.isEmpty()) {
                    Pair pos = queue.poll();

                    if (pos.x < 0 || pos.y < 0 || pos.x >= n || pos.y >= m) {
                        continue;
                    }

                    if (visited[pos.y][pos.x]) {
                        continue;
                    }
                    visited[pos.y][pos.x] = true;
                    if (grid[pos.y][pos.x] == 0) {
                        continue;
                    }

                    grid[pos.y][pos.x] = 0;

                    queue.add(new Pair(pos.x, pos.y - 1));
                    queue.add(new Pair(pos.x, pos.y + 1));
                    queue.add(new Pair(pos.x - 1, pos.y));
                    queue.add(new Pair(pos.x + 1, pos.y));

                    queue.add(new Pair(pos.x - 1, pos.y - 1));
                    queue.add(new Pair(pos.x + 1, pos.y + 1));
                    queue.add(new Pair(pos.x - 1, pos.y + 1));
                    queue.add(new Pair(pos.x + 1, pos.y - 1));
                }
            }
        }

        print(count);
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
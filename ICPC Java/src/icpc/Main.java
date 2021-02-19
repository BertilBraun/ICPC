package icpc;

import java.util.ArrayList;
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

    class Node {
        public List<Node> children = new ArrayList<>();

        public int fCap;
        public int pos;

        public Node(int pos, int fCap) {
            this.fCap = fCap;
            this.pos  = pos;
        }
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        List<Node> nodes = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            nodes.add(new Node(scanner.nextInt(), scanner.nextInt()));
        }

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nodes.get(i).fCap - nodes.get(j).fCap) > Math.abs(nodes.get(i).pos - nodes.get(j).pos)) {
                    if (nodes.get(i).fCap < nodes.get(j).fCap)
                        nodes.get(j).children.add(nodes.get(i));
                    else
                        nodes.get(i).children.add(nodes.get(j));
                }
            }

        int max = nodes.stream().max(com)


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
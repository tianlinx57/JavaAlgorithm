package CodeForces.round957div3;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Q4_bfs {

    static class State {
        int position;
        int swimDistance;

        State(int position, int swimDistance) {
            this.position = position;
            this.swimDistance = swimDistance;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = Integer.parseInt(in.nextLine());

        for (int i = 0; i < times; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            System.out.println(solve(n, m, k, s) ? "YES" : "NO");
        }
    }

    private static boolean solve(int n, int m, int k, String s) {
        Queue<State> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n + 2]; // to track visited positions
        queue.add(new State(0, 0));
        visited[0] = true;

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int pos = current.position;
            int swimDist = current.swimDistance;

            if (pos == n + 1) {
                return true; // reached the right bank
            }

            for (int jump = 1; jump <= m; jump++) {
                int nextPos = pos + jump;
                if (nextPos > n + 1) {
                    nextPos = n + 1;
                }

                if (nextPos == n + 1 || (nextPos <= n && s.charAt(nextPos - 1) == 'L')) {
                    if (!visited[nextPos]) {
                        queue.add(new State(nextPos, swimDist));
                        visited[nextPos] = true;
                    }
                } else if (nextPos <= n && s.charAt(nextPos - 1) == 'W') {
                    if (swimDist < k && !visited[nextPos]) {
                        queue.add(new State(nextPos, swimDist + 1));
                        visited[nextPos] = true;
                    }
                }
            }
        }

        return false; // couldn't reach the right bank
    }



}

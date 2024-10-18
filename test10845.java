import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class test10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());
        int last = -1;

        for (int i = 0; i < n; i++) {
            String[] command = br.readLine().split(" ");

            switch (command[0]) {
                case "push":
                    int value = Integer.parseInt(command[1]);
                    queue.offer(value);
                    last = value;
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.poll()).append("\n");
                    }
                    break;

                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                case "empty":
                    if (queue.isEmpty()) {
                        sb.append("1\n");
                    } else {
                        sb.append("0\n");
                    }
                    break;

                case "front":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(queue.peek()).append("\n");
                    }
                    break;

                case "back":
                    if (queue.isEmpty()) {
                        sb.append("-1\n");
                    } else {
                        sb.append(last).append("\n");
                    }
                    break;
            }
        }

        System.out.print(sb);
    }
}

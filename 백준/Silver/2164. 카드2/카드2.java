// 2164 실버4 카드2

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> card = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            card.add(i + 1);
        }

        while (card.size() > 1) {
            card.poll();
            card.offer(card.poll());
        }

        System.out.println(card.poll());
    }
}

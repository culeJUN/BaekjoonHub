// 1781 골드2 컵라면

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Question[] questions = new Question[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int cupCnt = Integer.parseInt(st.nextToken());

            questions[i] = new Question(deadLine, cupCnt);
        }

        Arrays.parallelSort(questions);
        long cupNoodleCnt = 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();

        for (Question question : questions) {
            int size = pQueue.size();

            if (size < question.deadLine) {
                pQueue.offer(question.cupCnt);
            }
            else if (size == question.deadLine) {
                int noodleCount = pQueue.peek();

                if(noodleCount < question.cupCnt) {
                    pQueue.poll();
                    pQueue.offer(question.cupCnt);
                }
            }
        }

        int totalNoodle = 0;
        
        while (!pQueue.isEmpty()) {
            totalNoodle += pQueue.poll();    
        }
        
        System.out.println(totalNoodle);
    }
}

class Question implements Comparable<Question> {
    int deadLine;
    int cupCnt;

    Question(int deadLine, int cupCnt) {
        this.deadLine = deadLine;
        this.cupCnt = cupCnt;
    }

    @Override
    public int compareTo(Question o) {
        // 1. 데드라인 낮은순
        // 2. 컵라면 많은 순
        if (this.deadLine < o.deadLine) {
            return -1;
        }
        else if (this.deadLine == o.deadLine) {
            if (this.cupCnt > o.cupCnt) {
                return -1;
            }
            else if (this.cupCnt == o.cupCnt) {
                return 0;
            }
            else {
                return 1;
            }
        }
        else {
            return 1;
        }
    }
}
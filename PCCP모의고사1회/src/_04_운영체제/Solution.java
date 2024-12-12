package _04_운영체제;

import java.util.PriorityQueue;

class Solution {
    static long[] answer = new long[11];
    
    public long[] solution(int[][] program) {

        PriorityQueue<int[]> waitHeap = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        

        PriorityQueue<int[]> sleepHeap = new PriorityQueue<>((o1, o2) -> {
            return o1[1] - o2[1];
        });
        
        for (int i = 0; i < program.length; i++) {
            sleepHeap.add(program[i]);
        }
        
        run(waitHeap, sleepHeap);
        
        return answer;
    }
    
    public void run(PriorityQueue<int[]> waitHeap, PriorityQueue<int[]> sleepHeap) {
        long time = -1;
        int run = 0;
        while (true) {

            if (waitHeap.isEmpty() && sleepHeap.isEmpty() && run == 0) {
                break;
            }
            time++;

            if (run > 0) {
                run--;
            }
            

            while (!sleepHeap.isEmpty() && sleepHeap.peek()[1] == time) {
                waitHeap.add(sleepHeap.poll());
            }

            if (run == 0 && !waitHeap.isEmpty()) {
                int[] curProgram = waitHeap.poll();
                // ����ð��� �߰��մϴ�.
                run += curProgram[2];

                answer[curProgram[0]] += time - curProgram[1];
            }
        }
        // 0������ ���α׷��� �� �ð��� ���ϴ�.
        answer[0] = time;
    }
}
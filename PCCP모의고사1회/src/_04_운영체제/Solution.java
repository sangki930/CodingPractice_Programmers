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
        
        // ���� ���� ȣ��ð� ������ ����ŵ�ϴ�.
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
            // �������� �������� �� �� �����, ������ 0�̶�� ���� �� �Դϴ�.
            if (waitHeap.isEmpty() && sleepHeap.isEmpty() && run == 0) {
                break;
            }
            time++;
            // ���� �� �̶�� ����, �� 0�̶�� ���� �� �ƴ�.
            if (run > 0) {
                run--;
            }
            
            // ȣ��
            // �ð��� ���ٸ�, ���� ������ ������ ��⿭�� �ֽ��ϴ�.
            while (!sleepHeap.isEmpty() && sleepHeap.peek()[1] == time) {
                waitHeap.add(sleepHeap.poll());
            }
            
            // ����
            if (run == 0 && !waitHeap.isEmpty()) {
                int[] curProgram = waitHeap.poll();
                // ����ð��� �߰��մϴ�.
                run += curProgram[2];
                // ���信�� ����� �ð� - ��⿭�� �� �ð��� ��ϵ˴ϴ�.
                // ������ ���� ���α׷� ���� ����Ǵ°� �ƴ϶� �켱���� ���� ��ϵȴٴ� �� �Դϴ�.
                // ex) �켱������ 1�� ���α׷��� answer[1]�� �����.
                answer[curProgram[0]] += time - curProgram[1];
            }
        }
        // 0������ ���α׷��� �� �ð��� ���ϴ�.
        answer[0] = time;
    }
}
//��ó : https://velog.io/@soluinoon/PCCP-%EB%AA%A8%EC%9D%98%EA%B3%A0%EC%82%AC-1%ED%9A%8C-4%EB%B2%88-%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9CJAVA
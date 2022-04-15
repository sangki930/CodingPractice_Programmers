package greedy.�������ϱ�;

import java.util.*;
class Node implements Comparable<Node>{
	
	int start;
	int end;
	int vertex;
	
	public Node(int start,int end,int vertex) {
		super();
		this.start=start;
		this.end=end;
		this.vertex=vertex;
		
	}

	@Override
	public int compareTo(Node o) {
		//MinHeap �� �޼���
		return o.vertex>=this.vertex?-1:1;
	}

}

class Solution {
    
	public static int find(int a) {
		
		
		if(a==parent[a])return a;//�ʱ�ȭ�� ����(������ ó�� ����)�̸� �ڱ� �ڽ��� �θ�
		parent[a] = find(parent[a]);//find �� ������ �θ�� �ֻ��� �θ�� ����(���� ���)
		return parent[a];
	}
	
	public static void union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot!=bRoot) {
			parent[aRoot] = b;
		}else {
			return;
		}
	}
    
    static int N;//������ ����
	static int E;//������ ����
	static PriorityQueue<Node> pq; //���� ���� Min Heap �����ϴ� �켱���� ť
	static int[] parent;
	static boolean[] visit; //�湮 ���� �迭
	static int result; //��� �� ����
    
    public int solution(int n, int[][] costs) throws Exception {

        N=n;
        E=costs.length;
      
		parent = new int[N+1];
		visit = new boolean[N+1];
		result = 0;
		
		pq = new PriorityQueue<Node>();

		for(int i=0;i<E;i++) {
			pq.add(new Node(costs[i][0]
					,costs[i][1]
					,costs[i][2]
					));

		}
		
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		
		for(int i=0;i<E;i++) {
			Node oneNode = pq.poll();

			int start = oneNode.start;
			int end = oneNode.end;
			int a = find(start);
			int b = find(end);
			if(a==b) continue; 
			
			union(start,end);
			result+=oneNode.vertex;
			
		}
        return result;
    }
}
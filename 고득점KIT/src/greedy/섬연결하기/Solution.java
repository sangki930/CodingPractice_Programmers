package greedy.섬연결하기;

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
		//MinHeap 용 메서드
		return o.vertex>=this.vertex?-1:1;
	}

}

class Solution {
    
	public static int find(int a) {
		
		
		if(a==parent[a])return a;//초기화된 상태(정점이 처음 등장)이면 자기 자신이 부모
		parent[a] = find(parent[a]);//find 할 때마다 부모는 최상위 부모로 설정(성능 향상)
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
    
    static int N;//정점의 개수
	static int E;//간선의 개수
	static PriorityQueue<Node> pq; //간선 값을 Min Heap 으로하는 우선순위 큐
	static int[] parent;
	static boolean[] visit; //방문 여부 배열
	static int result; //결과 값 저장
    
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
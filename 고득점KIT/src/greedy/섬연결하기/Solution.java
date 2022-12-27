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
    
    /*
	 * 찾기
	 * x가 속한 집합의 대표값(루트 노드 값)을 반환한다.
	 * 즉, x가 어떤 집합에 속해있는지 찾는 연산
	 */
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
		// String[] tempStr;
		for(int i=0;i<E;i++) {
			// tempStr = br.readLine().split(" ");
			pq.add(new Node(costs[i][0]
					,costs[i][1]
					,costs[i][2]
					));

		}//모든 간선에 대해 [시작,끝, 비용]을 가진 클래스로 우선순위 큐에 add
		
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}//union-find의 초기화는 일단 자기 자신의 부모노드는 자기 자신으로 설정
		
		for(int i=0;i<E;i++) {//모든 간선에 대하여 확인
			Node oneNode = pq.poll();
			//현재 큐에 있는 모든 인스턴스 중 비용이 가장 작은 간선이 poll된다.
			int start = oneNode.start;
			int end = oneNode.end;
			int a = find(start);
			//만약 간선을 선택해서 연결한다 했을 때, 사이클이 생기면 안되므로
			int b = find(end);
			//양쪽의 루트(최상위 부모) 노드가 무엇인지 확인하고
			if(a==b) continue; //만약 같으면 선택하지 않고 넘어간다.
			
			union(start,end);//두 개의 루트 노드가 달랐다면 한쪽의
			//한쪽의 최상위 부모를 다른 한쪽의 부모로 설정하고
			result+=oneNode.vertex;//선택된 간선이므로 간선의 비용을 더한다.
			
		}
        return result;
    }
}
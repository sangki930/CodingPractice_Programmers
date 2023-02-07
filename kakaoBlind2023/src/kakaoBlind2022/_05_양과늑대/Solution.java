package kakaoBlind2022._05_양과늑대;

import java.util.Map;
import java.util.HashMap;
import java.util.Stack;
import java.util.ArrayList;

class Trace{
    
    int node;
    int wolf;
    int sheep;
    String visited;
    public Trace(int node,int sheep, int wolf,String visited){
        this.node=node;
        this.wolf=wolf;
        this.sheep=sheep;
        this.visited=visited;
    }
    
    @Override
    public String toString(){
        return "{ node : "+this.node+", sheep : "+this.sheep+", wolf : "+this.wolf+", visited : "
            +this.visited+" }";
    }
}

class Solution {
    public int solution(int[] info, int[][] edges) {
        int answer = 0;
        Map<Integer,ArrayList<Integer>> tree = new HashMap<>();
        
        for(int[] edge : edges){
            int p = edge[0];
            int s = edge[1];
            ArrayList<Integer> nodes = tree.getOrDefault(p,new ArrayList<>());
            nodes.add(s);
            tree.put(p,nodes);
        }
        
        Stack<Trace> stack  = new Stack<>();
        String start = "",end = "";
        for(int i=0;i<info.length;i++){
            start+="X";
            end+="O";
        }
            
        stack.push(new Trace(0,0,0,start));
        
        while(!stack.isEmpty()){
            // System.out.println(stack);
            Trace trace = stack.pop();
            
            int node = trace.node;
            int wolf = trace.wolf;
            int sheep = trace.sheep;
            char[] v = trace.visited.toCharArray();
            
            if(trace.visited.equals(end)) continue;
            if(v[node]=='X'){
                v[node]='O';
                if(info[node]==0){
                    sheep++;
                    stack.push(new Trace(0,sheep,wolf,new String(v)));
                }else if(info[node]==1){
                    wolf++;
                }
            }

            if(sheep<=wolf){
                continue;
            }

            answer = Math.max(answer,sheep);

            ArrayList<Integer> nodes = tree.getOrDefault(node, new ArrayList<>());
            for(int son : nodes){
                stack.add(new Trace(son,sheep,wolf,new String(v)));
            }
        }
        return answer;
    }
    
}
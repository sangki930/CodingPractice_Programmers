package kakaoBilnd2019._05길찾기게임;

import java.util.*;

class Solution {
    
    class Node{
        
        Node(int id,int x,int y){
            this.x=x;
            this.id=id;
            this.y=y;
        }
        
      int id;
        int x,y;
        Node left;
        Node right;
    };
    int idx;
    List<Node> Nodes = new ArrayList<>();
    
    void addNode(Node parent, Node child){
        if(child.x<parent.x){
            if(parent.left==null){
                parent.left=child;
            }else{
                addNode(parent.left,child);
            }
        }else{
            if(parent.right==null){
                parent.right = child;
            }else{
                 addNode(parent.right,child);
            }
        }
    }
    
    void preorder(int[][] answer, Node node){
        if(node==null)return;
        answer[0][idx++] = node.id;
        preorder(answer,node.left);
        preorder(answer,node.right);
        
    }
      void postorder(int[][] answer, Node node){
        if(node==null)return;
        postorder(answer,node.left);
        postorder(answer,node.right);
          answer[1][idx++] = node.id;
        
    }
    
    public int[][] solution(int[][] nodeinfo) {
        int size = nodeinfo.length;
        for(int i=0;i<size;++i){
            Nodes.add(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]));
        }
        Nodes.sort((a,b)->{
            if(a.y==b.y){
                return a.x-b.x;
            }
            return b.y-a.y;
        });
        
        Node root = Nodes.get(0);
        
        for(int i=1;i<size;++i){
            addNode(root,Nodes.get(i));
            //첫 번째 param : 루트노드
            //두 번째 param : 새로 추가하고자하는 노드
        }
        
        int[][] answer = new int[2][size];
        preorder(answer,root);
        idx=0;
        postorder(answer,root);
        
        return answer;
    }
}

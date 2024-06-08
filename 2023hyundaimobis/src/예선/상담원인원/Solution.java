package 예선.상담원인원;

import java.util.*;

class Data{
    int s;
    int e;
    public Data(int s, int e){
        this.s=s;
        this.e=e;
    }
}

class Solution {

    int _n;
    int _k;
    int[][] _reqs;
    int answer = Integer.MAX_VALUE;
    public int solution(int k, int n, int[][] reqs) {

        this._n = n;
        this._k = k;
        this._reqs = reqs;
        func(0,0, new ArrayList<>());
        return answer;
    }

    public void func(int sum, int level, ArrayList<Integer> list){

        if(level == _k){
            if(sum == _n){
                ArrayList<Data>[][] arr1 = new ArrayList[_k][];
                for(int i=0;i<list.size();i++){
                    arr1[i] = new ArrayList[list.get(i)];
                    for(int j=0;j<arr1[i].length;j++){
                        arr1[i][j] = new ArrayList<Data>();
                    }

                }
                int time = 0;

                for(int[] req : _reqs){
                    int a = req[0];
                    int b = req[1];
                    int c = req[2]-1;

                    ArrayList[] tmp_arr = arr1[c];
                    int[] d = select_queue(tmp_arr);
                    if(d[1]>=a){
                        time += (d[1]-a);
                        a = d[1];
                    }
                    arr1[c][d[0]].add(new Data(a,a+b));

                }
                answer = Math.min(answer,time);
            }
            return;
        }

        for(int i=1;i<=_n;i++){
            if(sum + i<=_n){
                ArrayList<Integer> tmp = new ArrayList<>(list);
                tmp.add(i);
                func(sum+i,level+1, tmp);
            }
        }

    }

    public int[] select_queue(ArrayList<Data>[] arr){
        int[] ret = {-1,Integer.MAX_VALUE}; // ret[0] : 큐 번호, ret[1] : 큐의 마지막 값
        for(int i=0;i<arr.length;i++){
            if(arr[i].isEmpty()){
                ret[0] = i;
                ret[1] = 0;
                return ret;
            }else{
                if(arr[i].get(arr[i].size()-1).e<ret[1]){
                    ret[0] = i;
                    ret[1] = arr[i].get(arr[i].size()-1).e;
                }
            }
        }

        return ret;
    }

}
package Week04;

import java.util.*;
import java.util.stream.IntStream;

class Pair{
	int val;
	String key;
	public Pair(String key, int val) {
		super();
		this.val = val;
		this.key = key;
	}
}
class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        LinkedList<Pair> ret = new LinkedList<>();
		for(String data : table) {
			String[] tmp = data.split(" ");
			Map<String,Integer> d = new HashMap<>();
			for(int i=1;i<tmp.length;i++) d.put(tmp[i], 6-i);
			int sum = IntStream.range(0, languages.length).map(i->d.getOrDefault(languages[i], 0)*preference[i]).sum();
            ret.offer(new Pair(tmp[0],sum));
		}
        return ((Pair)ret.stream().sorted((a,b)->{if(a.val==b.val) return a.key.compareTo(b.key); return Integer.compare(b.val,a.val); }).toArray()[0]).key;
    }
}

package _07_풍선터뜨리기;

class Solution {
    public int solution(int[] a) {
        int answer = 0;

        int l = 1000000000, r = 1000000000;

        for (int i = 0; i < a.length; i++) {
            if (a[i] < l) {
                answer++;
                l = a[i];
            }

            if (a[a.length - 1 - i] < r) {
                answer++;
                r = a[a.length - 1 - i];
            }

            if (l == r)
                break;
        }

        return answer + (l == r ? -1 : 0);
    }
}
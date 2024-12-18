package 연속펄스부분의합;

class Solution {
    public long solution(int[] sequence) {
        // 최대 연속 펄스 부분 수열의 합을 저장할 변수
        long maxPulseSum = Integer.MIN_VALUE;

        // 펄스 수열이 1 또는 -1로 시작하는 경우를 각각 계산
        maxPulseSum = Math.max(maxPulseSum, maxPulseSubsequenceSum(sequence, 1L));
        maxPulseSum = Math.max(maxPulseSum, maxPulseSubsequenceSum(sequence, -1L));

        return maxPulseSum;
    }

    private long maxPulseSubsequenceSum(int[] sequence, long startPulse) {
        long pulse = startPulse; // 현재 펄스 값을 저장 (1 또는 -1)
        long currentSum = 0; // 현재 부분 수열의 합
        long maxSum = Long.MIN_VALUE; // 최대 합

        // 주어진 배열을 순회하며 연속 부분 수열의 최대 합을 계산
        for (int num : sequence) {
            // 현재 원소와 펄스를 곱한 값을 현재 합에 추가
            currentSum = Math.max(num * pulse, currentSum + (long)num * (long)pulse);
            // 최대 합 갱신
            maxSum = Math.max(maxSum, currentSum);
            // 펄스 반전
            pulse *= -1;
        }

        return maxSum;
    }
}
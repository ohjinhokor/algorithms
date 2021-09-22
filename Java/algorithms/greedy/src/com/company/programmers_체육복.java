package com.company;
import java.util.Arrays;

public class programmers_체육복 {

    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = -100;
                    reserve[j] = -1000;

                    answer++;
                    break;
                }
            }
        }
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] + 1) {
                    lost[i] = -100;
                    reserve[j] = -1000;
                    answer++;
                    break;
                }

                if (lost[i] == reserve[j] - 1) {
                    lost[i] = -100;
                    reserve[j] = -1000;
                    answer++;
                }
            }
        }
        return answer;
    }
}

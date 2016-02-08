package p100;

import java.util.Scanner;

public class Main {
    static long[] a = new long[1000001];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int i = in.nextInt();
            int j = in.nextInt();
            System.out.println(String.format("%d %d %d", i, j, the3NPlus1Problem(i, j)));
        }
    }

    static long the3NPlus1Problem(int i, int j) {
        long maxNumbersToPrint = 0;
        int max = Math.max(i, j);
        int min = Math.min(i, j);
        a[1] = 1;
        for (int k = min; k <= max; k++) {
            maxNumbersToPrint = Math.max(maxNumbersToPrint, count(k));
        }
        return maxNumbersToPrint;
    }

    static long count(long i) {
        int index = (int) i;
        if (a[index] != 0) {
            return a[index];
        }
        long count = 0;
        while (i != 1) {
            count++;
            if (i % 2 == 0) {
                i = i / 2;
            } else {
                i = 3 * i + 1;
            }
            if (i < 1000001 && a[(int)i] != 0) {
                count += a[(int)i];
                break;
            }
        }
        a[index] = count;
        return count;
    }
}

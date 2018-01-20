package saman.problem.misc;

public final class Math {

    private Math() {}

    public static long power(long number, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result = result * number;
        }
        return result;
    }
}

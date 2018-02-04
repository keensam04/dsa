package saman.util;

public final class Math {

    private Math() {}

    public static long power(long number, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result = result * number;
        }
        return result;
    }

    public static double power(double number, int exponent) {
        double result = 1.0;
        for (int i = 0; i < exponent; i++) {
            result = result * number;
        }
        return result;
    }

}

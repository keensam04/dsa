package saman.problem.arrays;

public final class ArrayUtils {

    private ArrayUtils() {}

    /**
     * Given a weighted array, and a random integer between 0 and total weight,
     * calculate the index at which this random number would lie.
     * e.g. if array = [10,20,0,20,50] and
     *   i)   randomNumber = 53, then answer is 4
     *   ii)  randomNumber = 32, then answer is 3
     *   iii) randomNumber = 9, then answer is 0
     */
    public static int getIndexByWeight(int[] weightedArray, int randomNumber) {
        int sum = 0;
        for (int index = 0; index < weightedArray.length; index++) {
            if (sum <= randomNumber && randomNumber <= (sum = sum + weightedArray[index])) {
                return index;
            }
        }
        return -1;
    }
}

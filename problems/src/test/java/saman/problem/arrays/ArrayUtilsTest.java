package saman.problem.arrays;

import org.junit.Test;

import java.util.stream.IntStream;

public class ArrayUtilsTest {

    @Test
    public void testGetIndexByWeight() {
        int[] weightedArray = {10, 20, 0, 20, 50};
        IntStream.rangeClosed(0, 100).forEach(integer -> {
            int index = ArrayUtils.getIndexByWeight(weightedArray, integer);
            System.out.println(String.valueOf(integer).concat(" -> ").concat(String.valueOf(index)));
        });
    }
}

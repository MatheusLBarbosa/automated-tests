package br.com.mlb;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class ArrayCompareTest {

    @Test
    void test(){
        int[] numbers = {8, 21, 4, 25, 32};
        int[] expectedArray = {4, 8, 21, 25, 32};

        Arrays.sort(numbers);

        assertArrayEquals(expectedArray, numbers);
    }

    @Test
    @Timeout(value = 15, unit = TimeUnit.MILLISECONDS)
    @Disabled
    void testPerformance(){
        int[] numbers = {8, 21, 4, 25, 32};
        for (int i=0; i<100000000; i++){
            numbers[0] = i;
            Arrays.sort(numbers);
        }
    }
}

package br.com.mlb.mockito;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {

    @Test
    void testHamcrestMatchers(){
        //Given
        List<Integer> scores = Arrays.asList(99, 100, 101, 105);

        //When && Then
        assertThat(scores, hasSize(4));
        assertThat(scores, hasItems(100, 101));
        assertThat(scores, everyItem(greaterThan(90)));
        assertThat(scores, everyItem(lessThan(110)));

        //Check Strings
        assertThat("", is(emptyString()));
        assertThat(null, is(emptyOrNullString()));

        //Check Array
        Integer[] intArray = {1,2,3};
        assertThat(intArray, arrayWithSize(3));
        assertThat(intArray, arrayContaining(1,2,3));
        assertThat(intArray, arrayContainingInAnyOrder(3,2,1));
    }
}

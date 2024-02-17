package br.com.mlb.mockito;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class SpyTest {
    @Test
    void testV1() {
        //Given
        List<String> mockList = Mockito.mock(ArrayList.class);
        //When
        Assertions.assertEquals(0, mockList.size());
        //Then
        Mockito.when(mockList.size()).thenReturn(5);
        mockList.add("Foo-Bar");
        Assertions.assertEquals(5, mockList.size());
    }


    @Test
    void testV2() {
        //Given
        List<String> spyList = Mockito.spy(ArrayList.class);
        //When
        Assertions.assertEquals(0, spyList.size());
        //Then
        spyList.add("Foo-Bar");
        Assertions.assertEquals(1, spyList.size());

        spyList.remove("Foo-Bar");
        Assertions.assertEquals(0, spyList.size());
    }

    @Test
    void testV3() {
        List<String> spyList = Mockito.spy(ArrayList.class);
        Assertions.assertEquals(0, spyList.size());
        Mockito.when(spyList.size()).thenReturn(5);
        Assertions.assertEquals(5, spyList.size());
    }

    @Test
    void testV4() {
        List<String> spyList = Mockito.spy(ArrayList.class);
        spyList.add("Foo-Bar");
        Mockito.verify(spyList).add("Foo-Bar");
        Mockito.verify(spyList, Mockito.never()).remove(Mockito.anyString());
        Mockito.verify(spyList, Mockito.never()).clear();
    }
}

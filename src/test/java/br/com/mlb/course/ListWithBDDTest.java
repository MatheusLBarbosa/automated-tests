package br.com.mlb.course;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.BDDMockito.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class ListWithBDDTest {
    @Test
    void testMockingList_Given_SizeIsCalled_ShouldReturn10() {
        //Given
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10);
        //Given
        //Then
        assertThat(list.size(), is(10));
    }

    @Test
    void testMockingList_Given_SizeIsCalled_ShouldReturnMultipleValues() {
        //Given
        List<?> list = mock(List.class);
        given(list.size()).willReturn(10).willReturn(20);
        //Given
        //Then
        assertThat(list.size(), is(10));
        assertThat(list.size(), is(20));
        assertThat(list.size(), is(20));
    }

    @Test
    void testMockingList_Given_GetIsCalled_ShouldReturnMatheus() {
        //Given
        List<String> list = mock(List.class);
        given(list.get(0)).willReturn("Matheus");
        //Given
        //Then
        assertThat(list.get(0), is("Matheus"));
        assertThat(list.get(1), is(nullValue()));
    }

    @Test
    void testMockingList_Given_GetIsCalledWithArgumentMatcher_ShouldReturnMatheus() {
        //Given
        List<String> list = mock(List.class);
        given(list.get(anyInt())).willReturn("Matheus");
        //Given
        //Then
        assertThat(list.get(anyInt()), is("Matheus"));
        assertThat(list.get(anyInt()), is("Matheus"));
    }

    @Test
    void testMockingList_When_GetIsCalled_ShouldThrowException() {
        //Given
        List<String> list = mock(List.class);
        given(list.get(anyInt())).willThrow(new RuntimeException("Foo Bar"));
        //When
        //Then
        assertThrows(RuntimeException.class, () -> {
                    list.get(anyInt());
                },
                () -> "Should have throw an exception");
    }

}

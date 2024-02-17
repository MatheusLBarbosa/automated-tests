package br.com.mlb.staticWithParams;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class MyUtilTest {
    @Test
    void shouldMockStaticMethodWithParams(){
        try(MockedStatic<MyUtils> mockedStatic = mockStatic(MyUtils.class)) {
            mockedStatic.when(
                    () -> MyUtils.getWelcomeMessage(
                            eq("Matheus"),
                            anyBoolean()
                    )
            ).thenReturn("Howdy Matheus!");
            String result = MyUtils.getWelcomeMessage("Matheus", false);
            assertEquals("Howdy Matheus!", result);
        }
    }
}

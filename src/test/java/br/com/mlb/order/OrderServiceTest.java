package br.com.mlb.order;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.time.LocalDateTime;
import java.util.UUID;

public class OrderServiceTest {
    private final OrderService service = new OrderService();
    private final UUID defaultUuid = UUID.fromString("61b779e5-b742-48ba-82f8-42afdeedf484");
    private final LocalDateTime defaultLocalDateTime = LocalDateTime.of(2024, 02, 01, 02,01);

    @Test
    void testShouldIncludeRandomOrderId_When_NoOrderIdExists(){
        //Given
        try(MockedStatic<UUID> mockedUuid = mockStatic(UUID.class)) {
            mockedUuid.when(UUID::randomUUID).thenReturn(defaultUuid);
            //When
            Order result = service.createOrder("MacBook Pro", 2L, null);
            assertEquals(defaultUuid.toString(), result.getId());
        }
        //Then
    }

    @Test
    void testShouldIncludeCurrentDateTime_When_CreateANewOrder(){
        //Given
        try(MockedStatic<LocalDateTime> mockTime = mockStatic(LocalDateTime.class)) {
            mockTime.when(LocalDateTime::now).thenReturn(defaultLocalDateTime);
            //When
            Order result = service.createOrder("MacBook Pro", 2L, null);
            assertEquals(defaultLocalDateTime, result.getCreationDate());
        }
        //Then
    }
}

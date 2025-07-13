// src/test/java/org/example/MyServiceTest.java
//package org.example;
import org.example.ExternalApi;
import org.example.MyService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    public void testExternalApi() {
        // Step 1: Create a mock object for the external API.
        ExternalApi mockApi = mock(ExternalApi.class);

        // Step 2: Stub the methods to return predefined values.
        // When mockApi.getData() is called, it should return "Mock Data".
        when(mockApi.getData()).thenReturn("Mock Data");

        // Step 3: Inject mock into the tested class.
        // This is the line that was highlighted: Ensure MyService has the constructor
        MyService service = new MyService(mockApi);

        // Step 4: Call method under test.
        String result = service.fetchData();

        // Step 5: Verify result.
        assertEquals("Mock Data", result);

        // Optional: Verify that getData() was called exactly once on the mock.
        verify(mockApi, times(1)).getData();
    }
}

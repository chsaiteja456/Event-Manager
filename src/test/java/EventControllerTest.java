import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class EventControllerTest {

    @Mock
    private EventService eventService;  // Mock the service

    @InjectMocks
    private EventController eventController;  // Inject the mocks into the controller

    @Test
    void getAllEvents_shouldReturnListOfEvents() {
        // Arrange
        when(eventService.getAllEvents()).thenReturn(Arrays.asList(new Event(), new Event()));

        // Act
        ResponseEntity<List<Event>> response = eventController.getAllEvents();

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(2, response.getBody().size());
    }

    @Test
    void getEventById_shouldReturnEvent() {
        // Arrange
        long eventId = 1L;
        when(eventService.getEventById(eventId)).thenReturn(new Event());

        // Act
        ResponseEntity<Event> response = eventController.getEventById(eventId);

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
    }

    @Test
    void getEventById_shouldReturnNotFoundWhenEventNotFound() {
        // Arrange
        long eventId = 1L;
        when(eventService.getEventById(eventId)).thenReturn(null);

        // Act
        ResponseEntity<Event> response = eventController.getEventById(eventId);

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertNull(response.getBody());
    }

    // Similarly, you can write tests for other controller methods
}

package br.com.mlb.course;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;


public class CourseBusinessMockTest {
    ICourseService mockService;
    CourseBusiness business;
    List<String> courses;

    @BeforeEach
    public void setup() {
        mockService = mock(ICourseService.class);
        business = new CourseBusiness(mockService);
        courses = Arrays.asList(
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker",
                "Kotlin para DEV's Java",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Docker do Zero a Maestria",
                "REST API's RESTFul do 0 à Azure com ASP.NET CORE 5"
        );
    }

    @DisplayName("Test Method coursesRelatedToSpring() using mock")
    @Test
    void testCoursesRelatedToSpring_When_UsingMock() {
        //Given
        when(mockService.retrieveCourses("Matheus")).thenReturn(courses);
        //When
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Matheus");
        //Then
        assertEquals(2, filteredCourses.size());
    }
}

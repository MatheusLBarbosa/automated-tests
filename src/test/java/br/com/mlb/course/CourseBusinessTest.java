package br.com.mlb.course;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CourseBusinessTest {

    @DisplayName("Test Method coursesRelatedToSpring() using a stub")
    @Test
    void testCoursesRelatedToSpring_When_UsingAStub(){
        ICourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        //When
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Docker");

        //Then
        assertEquals(2, filteredCourses.size());
    }

    @DisplayName("Test Method coursesRelatedToSpring() using a stub")
    @Test
    void testCoursesRelatedToSpring_When_UsingAFooBarStudent(){
        ICourseService stubService = new CourseServiceStub();
        CourseBusiness business = new CourseBusiness(stubService);

        //When
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Leandro");

        //Then
        assertEquals(2, filteredCourses.size());
    }
}

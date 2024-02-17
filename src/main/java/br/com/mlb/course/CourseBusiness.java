package br.com.mlb.course;

import java.util.ArrayList;
import java.util.List;

//System(Method) Under Test
public class CourseBusiness {
    //CourseService is a Dependency
    private final CourseService service;

    public CourseBusiness(CourseService service) {
        this.service = service;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student) {
        var filteredCourses = new ArrayList<String>();
        var allCourses = service.retrieveCourses(student);

        allCourses.forEach(course -> {
            if (course.contains("Spring"))
                filteredCourses.add(course);
        });

        return filteredCourses;
    }

    public void deleteCoursesNotRelatedToSpring(String student) {
        var allCourses = service.retrieveCourses(student);

        allCourses.forEach(course -> {
            if (!course.contains("Spring"))
                service.deleteCourse(course);
        });
    }
}

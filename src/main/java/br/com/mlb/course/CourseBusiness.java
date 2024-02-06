package br.com.mlb.course;

import java.util.ArrayList;
import java.util.List;

//System(Method) Under Test
public class CourseBusiness {
    //CourseService is a Dependency
    private ICourseService service;

    public CourseBusiness(ICourseService service){
        this.service = service;
    }

    public List<String> retrieveCoursesRelatedToSpring(String student){
        var filteredCourses = new ArrayList<String>();
        var allCourses = service.retrieveCourses(student);

        allCourses.stream().forEach(course -> {
            if(course.contains("Spring"))
                filteredCourses.add(course);
        });

        return filteredCourses;
    }
}

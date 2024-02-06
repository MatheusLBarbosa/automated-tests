package br.com.mlb.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CourseServiceStub implements ICourseService{
    @Override
    public List<String> retrieveCourses(String student) {
        return Arrays.asList(
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker",
                "Kotlin para DEV's Java",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Docker do Zero a Maestria",
                "REST API's RESTFul do 0 à Azure com ASP.NET CORE 5"
        );
    }

    @Override
    public List<String> doSomething(String student) {
        return null;
    }
}

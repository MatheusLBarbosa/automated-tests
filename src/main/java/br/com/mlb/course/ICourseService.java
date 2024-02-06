package br.com.mlb.course;

import java.util.List;

public interface ICourseService {
    List<String> retrieveCourses(String student);
    List<String> doSomething(String student);
}

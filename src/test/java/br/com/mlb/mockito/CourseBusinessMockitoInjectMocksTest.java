package br.com.mlb.mockito;

import br.com.mlb.course.CourseBusiness;
import br.com.mlb.course.CourseService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourseBusinessMockitoInjectMocksTest {
    @Mock
    CourseService mockService;
    @InjectMocks
    CourseBusiness business;
    @Captor
    ArgumentCaptor<String> argumentCaptor;
    List<String> courses;

    @BeforeEach
    public void setup() {
        courses = Arrays.asList(
                "REST API's RESTFul do 0 à Azure com ASP.NET Core 5 e Docker",
                "Agile Desmistificado com Scrum, XP, Kanban e Trello",
                "Spotify Engineering Culture Desmistificado",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Java e Docker",
                "Docker do Zero à Maestria - Contêinerização Desmistificada",
                "Docker para Amazon AWS Implante Apps Java e .NET com Travis CI",
                "Microsserviços do 0 com Spring Cloud, Spring Boot e Docker",
                "Arquitetura de Microsserviços do 0 com ASP.NET, .NET 6 e C#",
                "REST API's RESTFul do 0 à AWS com Spring Boot 3 Kotlin e Docker",
                "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android",
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker"
        );
    }

    @DisplayName("Test Method coursesRelatedToSpring() using mock")
    @Test
    void testCoursesRelatedToSpring_When_UsingMock() {
        //Given
        given(mockService.retrieveCourses("Matheus")).willReturn(courses);
        //When
        var filteredCourses = business.retrieveCoursesRelatedToSpring("Matheus");
        //Then
        assertThat(filteredCourses.size(), is(4));
    }

    @DisplayName("Delete Courses Not Related to Spring Using Mockito should call Method")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCourses() {
        //Given
        given(mockService.retrieveCourses("Matheus"))
                .willReturn(courses);
        //When
        business.deleteCoursesNotRelatedToSpring("Matheus");
        //Then
        //verify(mockService).deleteCourse("Kotlin para DEV's Java");
        //verify(mockService, times(1)).deleteCourse("Kotlin para DEV's Java");
        //verify(mockService, atLeast(1))
        verify(mockService, atLeastOnce()).deleteCourse("Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android");
        then(mockService).should().deleteCourse("Docker do Zero à Maestria - Contêinerização Desmistificada");
        then(mockService).should(never()).deleteCourse("Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
    }

    @DisplayName("Delete Courses Not Related to Spring Using Mockito should call Method V2")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCoursesV2() {
        //Given
        given(mockService.retrieveCourses("Matheus"))
                .willReturn(courses);
        //When
        business.deleteCoursesNotRelatedToSpring("Matheus");
        //Then
        String kotlinCourse = "Kotlin para DEV's Java: Aprenda a Linguagem Padrão do Android";
        then(mockService).should().deleteCourse(kotlinCourse);
        then(mockService).should().deleteCourse("Docker do Zero à Maestria - Contêinerização Desmistificada");
        then(mockService).should(never()).deleteCourse("Microsserviços do 0 com Spring Cloud, Kotlin e Docker");
    }

    @DisplayName("Delete Courses Not Related to Spring Using Mockito should call Method V3")
    @Test
    void testDeleteCoursesNotRelatedToSpring_UsingMockitoVerify_Should_CallMethod_deleteCoursesV3() {
        courses = Arrays.asList(
                "Microsserviços do 0 com Spring Cloud, Kotlin e Docker",
                "Kotlin para DEV's Java"
        );
        //Given
        given(mockService.retrieveCourses("Matheus"))
                .willReturn(courses);
        //When
        String kotlinCourse = "Kotlin para DEV's Java";

        business.deleteCoursesNotRelatedToSpring("Matheus");
        //Then
        then(mockService).should().deleteCourse(argumentCaptor.capture());
        assertThat(argumentCaptor.getValue(), is(kotlinCourse));
    }
}

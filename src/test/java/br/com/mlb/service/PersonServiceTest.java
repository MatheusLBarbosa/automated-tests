package br.com.mlb.service;

import static org.junit.jupiter.api.Assertions.*;

import br.com.mlb.person.service.IPersonService;
import br.com.mlb.person.service.Person;
import br.com.mlb.person.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PersonServiceTest {

    Person person;
    IPersonService service;
    @BeforeEach
    void setup() {
        service = new PersonService();
        person = new Person("Gau", "Galau", "gaugalau@gmail.com", "PE - BR", "Male");
    }

    @DisplayName("When Create a Person With Sucess Should Return Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        Person actual = service.createPerson(person);

        assertNotNull(actual, () -> "The cratePerson() should not have returned null!");
        assertNotNull(person.getId(), () -> "The person ID should not be null!");
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The person first name should not be null!");
        assertEquals(person.getLastName(), actual.getLastName(), () -> "The person last name should not be null!");
        assertEquals(person.getEmail(), actual.getEmail(), () -> "The person email should not be null!");
        assertEquals(person.getAddress(), actual.getAddress(), () -> "The person last name should not be null!");
        assertEquals(person.getGender(), actual.getGender(), () -> "The person last name should not be null!");
    }

    @DisplayName("When create a person with null email, should throw Exception")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException(){
        person.setEmail(null);
        var expected = "The person email is null or empty";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.createPerson(person),
                () -> "Null email should throw an IllegalArgumentException");
        assertEquals(expected, exception.getMessage());
    }
}

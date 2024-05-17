package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
    // 1. Find people aged less or equal 18
    // 2. Then change implementation to find first 10 people

    List<Person> youngPeople = new ArrayList<>();

    final int LIMIT = 10;
    int counter = 0;
    for (Person person : people) {
      if (person.getAge() <= 18) {
        youngPeople.add(person);
        counter++;
        if (counter == LIMIT) break;//breaks the for loop when counter reach the LIMIT
      }
    }
    for (Person young : youngPeople) {
      if (Integer.toString(young.getAge()).length() == 1) System.out.println(" "+young.getAge()+" "+young.getFirstName()); // Only adds a blank space to the ages of 1 digit for better visualization in console
      else System.out.println(young.getAge()+" "+young.getFirstName()); // if the length of the age is 2 digits, then does not add the initial space
    }
  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {
    ImmutableList<Person> people = MockData.getPeople();
  }
}

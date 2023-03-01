import static org.junit.Assert.*;
import org.junit.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class IsMoon implements StringChecker {
  public boolean checkString(String s) {
    return s.equalsIgnoreCase("moon");
  }
}

public class TestListExamples {
  @Test(timeout = 500)
  public void testMergeRightEnd() {
    List<String> left = Arrays.asList("a", "b", "c");
    List<String> right = Arrays.asList("a", "d");
    List<String> merged = ListExamples.merge(left, right);
    List<String> expected = Arrays.asList("a", "a", "b", "c", "d");
    assertEquals(expected, merged);
  }
  @Test
  public void testFilter() {
    List<String> not_filtered = new ArrayList<>();
    not_filtered.add("abc");
    not_filtered.add("moon");
    not_filtered.add("def");
    StringChecker sc = new IsMoon(); 
    List<String> actual_result = ListExamples.filter(not_filtered, sc);
    assertEquals("First element should be moon", "moon", actual_result.get(0));
    assertEquals("Size should be 1", 1, actual_result.size());
  }
}

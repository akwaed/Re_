/**
 * JUnit4 Test starter. Javadoc style comments are not necessary for this file.
 *
 * Methods annotated with @Test are the actual tests that you want to run. They are called one at a time.
 * Methods annotated with @Before are called before each @Test method. This can be used to reset the changes made by previous tests.
 * Methods annotated with @BeforeClass are called once at the beginning before all tests. This is usually used to create objects to be used throughout the tests.
 *
 * Note: You can start running junit tests after the constructor, toString(), clear() and addLast() have been implemented.
 */

import static org.junit.Assert.*;
import org.junit.*;

public class DoublyLinkedListWithDummyTest {
  private static DoublyLinkedListWithDummy<Integer> emptyList;
  private static DoublyLinkedListWithDummy<Integer> filledList;

  @BeforeClass
  public static void init(){
    emptyList = new DoublyLinkedListWithDummy<Integer>();
    filledList = new DoublyLinkedListWithDummy<Integer>();
  }

  @Before
  public void setUp(){
    emptyList.clear();

    filledList.clear();
    for (int i = 0;i < 5; i++)
      filledList.addLast(i);
  }
  
  @Test
  public void testAddFirst(){
    for (int i = 0;i < 5; i++)
      emptyList.addFirst(i);

    assertEquals("[4, 3, 2, 1, 0]", emptyList.toString());
    assertEquals("[0, 1, 2, 3, 4]", emptyList.toStringReverse());
  }

  @Test
  public void testGet(){
    assertEquals(Integer.valueOf(2), filledList.get(2));
  }
}


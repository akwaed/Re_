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
@Test
    public void testSize() {
        assertEquals(0, emptyList.size());
        assertEquals(5, filledList.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(emptyList.isEmpty());
        assertFalse(filledList.isEmpty());
    }

    @Test
    public void testClear() {
        filledList.clear();
        assertTrue(filledList.isEmpty());
    }

    @Test
    public void testGetFirst() {
        assertNull(emptyList.getFirst());
        assertEquals(Integer.valueOf(0), filledList.getFirst());
    }

    @Test
    public void testGetLast() {
        assertNull(emptyList.getLast());
        assertEquals(Integer.valueOf(4), filledList.getLast());
    }

    @Test
    public void testGet() {
        assertNull(emptyList.get(2));
        assertEquals(Integer.valueOf(2), filledList.get(2));
    }

    @Test
    public void testSet() {
        assertNull(emptyList.set(2, 10));
        assertEquals(Integer.valueOf(2), filledList.set(2, 10));
        assertEquals(Integer.valueOf(10), filledList.get(2));
    }

    @Test
    public void testAddFirst() {
        emptyList.addFirst(10);
        assertEquals("[10]", emptyList.toString());
        assertEquals(Integer.valueOf(10), emptyList.getFirst());
        assertEquals(1, emptyList.size());
    }

    @Test
    public void testAdd() {
        filledList.add(2, 10);
        assertEquals("[0, 1, 10, 2, 3, 4]", filledList.toString());
        assertEquals(Integer.valueOf(10), filledList.get(2));
        assertEquals(6, filledList.size());
    }

    @Test
    public void testAddLast() {
        emptyList.addLast(10);
        assertEquals("[10]", emptyList.toString());
        assertEquals(Integer.valueOf(10), emptyList.getLast());
        assertEquals(1, emptyList.size());
    }

    @Test
    public void testToString() {
        assertEquals("[]", emptyList.toString());
        assertEquals("[0, 1, 2, 3, 4]", filledList.toString());
    }

    @Test
    public void testToStringReverse() {
        assertEquals("[]", emptyList.toStringReverse());
        assertEquals("[4, 3, 2, 1, 0]", filledList.toStringReverse());
    }

    @Test
    public void testRemoveFirst() {
        assertEquals(Integer.valueOf(0), filledList.removeFirst());
        assertEquals("[1, 2, 3, 4]", filledList.toString());
        assertEquals(4, filledList.size());
    }

    @Test
    public void testRemove() {
        assertEquals(Integer.valueOf(2), filledList.remove(2));
        assertEquals("[0, 1, 3, 4]", filledList.toString());
        assertEquals(4, filledList.size());
    }

    @Test
    public void testRemoveLast() {
        assertEquals(Integer.valueOf(4), filledList.removeLast());
        assertEquals("[0, 1, 2, 3]", filledList.toString());
        assertEquals(4, filledList.size());
    }

    @Test
    public void testRemoveWithoutIndex() {
        assertEquals(Integer.valueOf(0), filledList.remove());
        assertEquals("[1, 2, 3, 4]", filledList.toString());
        assertEquals(4, filledList.size());
    }

    @Test
    public void testLastIndexOf() {
        assertEquals(2, filledList.lastIndexOf(2));
        assertEquals(-1, filledList.lastIndexOf(10));
    }

    @Test
    public void testIndexOf() {
        assertEquals(2, filledList.indexOf(2));
        assertEquals(-1, filledList.indexOf(10));
    }

    @Test
    public void testContains() {
        assertTrue(filledList.contains(2));
        assertFalse(filledList.contains(10));
    }
}


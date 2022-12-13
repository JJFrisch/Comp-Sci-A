import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
public class ALTest {
AL a1;
@Before
public void setUp() throws Exception {
a1 = new AL();
}
@Test
public void testAddObject() {
assertTrue(a1.size() == 0);
a1.add("a");
assertTrue(a1.size() == 1);
assertEquals("a",a1.get(0));
for (int k = 0; k < 20; k++) {
a1.add("z");
}
assertTrue(a1.size() == 21);
assertEquals("a",a1.get(0));
assertEquals("z",a1.get(1));
}
@Test
public void testAddIntObject() {
a1.add(0,"a");
a1.add(1,"b");
a1.add(2,"c");
a1.add(1,"x");
assertEquals(4,a1.size());
assertEquals("a",a1.get(0));
assertEquals("x",a1.get(1));
assertEquals("b",a1.get(2));
assertEquals("c",a1.get(3));
}
@Test
public void testAddIntTException() {
try {
a1.add(-1,"x");
fail();
}
catch(IndexOutOfBoundsException ex) {}
}
@Test
public void testAddIntTException2() {
try {
a1.add(1,"x");
fail();
}
catch(IndexOutOfBoundsException ex) {}
a1.add("a");
try {
a1.add(2,"x");
fail();
}
catch(IndexOutOfBoundsException ex) {}
}
@Test
public void testRemove() {
a1.add("a");
a1.add("b");
a1.add("c");
String s1 = (String) a1.remove(0);
assertEquals("a",s1);
assertEquals("b",a1.get(0));
a1.add("d");
assertTrue(a1.size()==3);
assertEquals("c",a1.remove(1));
assertEquals("b",a1.get(0));
assertEquals("d",a1.get(1));
}
@Test
public void testRemoveException() {
try {
a1.remove(0);
fail();
}
catch(IndexOutOfBoundsException ex) {}
try {
a1.remove(-1);
fail();
}
catch(IndexOutOfBoundsException ex) {}
}
@Test
public void testSet() {
a1.add("a");
a1.add("b");
a1.add("c");
a1.set(0, "z");
assertEquals("z",a1.get(0));
}
@Test
public void testSetException() {
try {
a1.set(0,"x");
fail();
}
catch(IndexOutOfBoundsException ex) {}
try {
a1.set(-1,"x");
fail();
}
catch(IndexOutOfBoundsException ex) {}
}
@Test
public void testGet() {
a1.add("a");
a1.add("b");
a1.add("c");
assertEquals("a",a1.get(0));
assertEquals("b",a1.get(1));
assertEquals("c",a1.get(2));
}
@Test
public void testGetException() {
try {
a1.get(0);
fail();
}
catch(IndexOutOfBoundsException ex) {}
try {
a1.get(-1);
fail();
}
catch(IndexOutOfBoundsException ex) {}
}
@Test
public void testIsEmpty() {
assertTrue(a1.isEmpty());
a1.add(null);
assertFalse(a1.isEmpty());
}
@Test
public void testToString() {
a1.add("Mildred");
a1.add("Eloise");
a1.add("Caillou");
assertEquals("[Mildred, Eloise, Caillou]",a1.toString());
}
@Test
public void testIndexOf() {
a1.add("a");
a1.add("b");
a1.add("c");
a1.add("d");
a1.add("e");
//assertEquals(-1,a1.indexOf("f"));
//assertEquals(0,a1.indexOf("a"));
//assertEquals(1,a1.indexOf("b"));
}
@Test
public void testToArray() {
a1.add("a");
a1.add("b");
a1.add("c");
a1.add("d");
a1.add("e");
Object[] strings = a1.toArray();
assertEquals(5,strings.length);
assertEquals("a",strings[0]);
assertEquals("b",strings[1]);
assertEquals("c",strings[2]);
assertEquals("d",strings[3]);
assertEquals("e",strings[4]);
}
@Test
public void testSize() {
assertEquals(0,a1.size());
a1.add("A");
assertEquals(1,a1.size());
}
}
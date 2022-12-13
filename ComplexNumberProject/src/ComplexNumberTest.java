import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ComplexNumberTest {

	ComplexNumber c1;
	ComplexNumber c2;
	ComplexNumber c3;
	ComplexNumber c4;
	
	@Before
	public void setUp() throws Exception {
		c1 = new ComplexNumber(3,4);
		c2 = new ComplexNumber(3,-4);
		c3 = new ComplexNumber(-3,4);
		c4 = new ComplexNumber(-3,-4);
	}

	@Test
	public void testGetRealPart() {
		assertEquals(3,c1.getReal());
		assertEquals(3,c2.getReal());
		assertEquals(-3,c3.getReal());
		assertEquals(-3,c4.getReal());
	}

	@Test
	public void testGetImaginaryPart() {
		assertEquals(4,c1.getImaginary());
		assertEquals(-4,c2.getImaginary());
		assertEquals(4,c3.getImaginary());
		assertEquals(-4,c4.getImaginary());
	}

	@Test
	public void testToString() {
		assertEquals("3+4i",c1.toString());
		assertEquals("3-4i",c2.toString());
		assertEquals("-3+4i",c3.toString());
		assertEquals("-3-4i",c4.toString());
	}

	@Test
	public void testPlus() {
		assertEquals(new ComplexNumber(6,0),c1.plus(c2));
		assertEquals(new ComplexNumber(6,8),c1.plus(c1));
		assertEquals(new ComplexNumber(6,-8),c2.plus(c2));
		assertEquals(new ComplexNumber(-6,-8),c4.plus(c4));
		assertEquals(new ComplexNumber(-6,0),c4.plus(c3));
	}

	@Test
	public void testTimesComplexNumber() {
		assertEquals(new ComplexNumber(-7,24),c1.times(c1));
		assertEquals(new ComplexNumber(25,0),c1.times(c2));
		assertEquals(new ComplexNumber(-7,-24),c2.times(c2));
		assertEquals(new ComplexNumber(-25,0),c1.times(c3));
		assertEquals(new ComplexNumber(7,24),c2.times(c3));
	}

	@Test
	public void testTimesInt() {
		assertEquals(new ComplexNumber(15,20),c1.times(5));
	}

	@Test
	public void testPow() {
		assertEquals(new ComplexNumber(3,4),c1.pow(1));
		assertEquals(new ComplexNumber(-7,24),c1.pow(2));
		assertEquals(new ComplexNumber(-117,44),c1.pow(3));
	}

	@Test
	public void testGetModulus() {
		assertEquals(5.0,c1.getModulus(),.0001);
		assertEquals(5.0,c2.getModulus(),.0001);
		assertEquals(5.0,c3.getModulus(),.0001);
		assertEquals(5.0,c4.getModulus(),.0001);
	}

	@Test
	public void testGetConjugate() {
		assertEquals(new ComplexNumber(3,-4),c1.getConjugate());
		assertEquals(new ComplexNumber(3,4),c2.getConjugate());
		assertEquals(new ComplexNumber(-3,-4),c3.getConjugate());
		assertEquals(new ComplexNumber(-3,4),c4.getConjugate());
	}
	
	@Test
	public void testEquals() {
		assertEquals(true,c1.equals(new ComplexNumber(3,4)));
		assertEquals(true,c1.equals(new ComplexNumber(3,4)));
	}
}

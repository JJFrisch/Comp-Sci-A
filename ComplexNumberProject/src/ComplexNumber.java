/**
 * A class with two instance variables
 * r = an int that represents a real number
 * i = is the imaginary part represented by an int times i
 * @author 25frischmannj
 *
 */
public class ComplexNumber {
	private int r;
	private int i;
	
	/**
	 * Creates a complex number object with a set real and imaginary value
	 * @param rVal is the real value
	 * @param iVal is the imaginary value
	 */
	public ComplexNumber(int rVal, int iVal){
		r=rVal;
		i=iVal;
	}
	
	/**
	 * Creates a complex number with a real value of 0 and an imaginary value of 0
	 */
	public ComplexNumber(){
		r=0;
		i=0;
	}
	
	/**
	 * Gets the real part of this complex number
	 * @return the real part of this complex number
	 */
	public int getReal(){
		return r;
	}
	
	/**
	 * Gets the Imaginary part of this complex number
	 * @return the Imaginary part of this complex number
	 */
	public int getImaginary(){
		return i;
	}
	
	/**
	 * Returns this complex number as a string
	 */
	public String toString(){
		if(i>=0){
			return r + "+" + i + "i";
		}
		return r + "" + i + "i";
	}
	
	/**
	 * calculates this complex number plus another complex number
	 * @param complex the complex number getting added to this
	 * @return this complex number plus another complex number
	 */
	public ComplexNumber plus(ComplexNumber complex){
		return new ComplexNumber(r+complex.getReal(), i+complex.getImaginary());
	}
	
	/**
	 * calculates this complex number times another complex number
	 * @param complex the complex number getting times to this
	 * @return this complex number times another complex number
	 */
	public ComplexNumber times(ComplexNumber complex){
		int newR = r*complex.getReal() + (i*complex.getImaginary()*-1);
		int newI = r*complex.getImaginary() + i*complex.getReal();
		return new ComplexNumber(newR, newI);
	}
	
	/**
	 * calculates this complex number times a number
	 * @param n the number this is getting times by
	 * @return this complex number times a number
	 */
	public ComplexNumber times(int n){
		return new ComplexNumber(r*n, i*n);
	}
	
	
	/**
	 * Calculates this complex number to a power.
	 * @param n is the power. Must be a positive number.
	 * @return this complex number to a power.
	 */
	public ComplexNumber pow(int n){
		if (n<=0){
			throw new IllegalArgumentException("Perameter must by a poritive number");
		}
		else{
			ComplexNumber newCP = new ComplexNumber(r,i);
			for(int i=1;i<n;i++){
				newCP = newCP.times(this);
			}
			return newCP;
		}
		
	}
	
	/**
	 * gets the modulus of this complex number
	 * @return the modulus of this complex number
	 */
	public double getModulus(){
		return Math.sqrt(r*r + i*i);
	}
	
	/**
	 * Gets the conjugate of this complex number
	 * @return the conjugate of this complex number
	 */
	public ComplexNumber getConjugate(){
		return new ComplexNumber(r, i*-1);
	}
	
	/**
	 * calculates if this complex number equals an object
	 * @param the object
	 * @return if this complex number equals an object
	 */
	public boolean equals(Object x){
		ComplexNumber other = (ComplexNumber)x;
		return this.getReal() == other.getReal() && this.getImaginary() == other.getImaginary();
	}
}

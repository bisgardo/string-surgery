package string_surgery.chars.function;

public class IndexFunctions {
	
	public static int endex(CharSequence input, int endex) {
		if (input == null) {
			throw new NullPointerException("input");
		}
		return endex(input.length(), endex);
	}
	
	public static int endex(int length, int endex) {
		checkIndex(length, endex);
		return length - endex;
	}
	
	public static int snap(CharSequence input, int index) {
		if (input == null) {
			throw new NullPointerException("input");
		}
		return snap(input.length(), index);
	}
	
	public static int snap(int length, int index) {
		if (index < 0) {
			return 0;
		}
		if (index >= length) {
			return length - 1;
		}
		return index;
	}
	
	
	public static void checkIndex(CharSequence input, int index) {
		if (input == null) {
			throw new NullPointerException("input");
		}
		checkIndex(input.length(), index);
	}
	
	public static void checkIndex(int inputLength, int index) {
		if (index < 0) {
			throw new StringIndexOutOfBoundsException(index + " < 0");
		}
		if (index > inputLength) {
			throw new StringIndexOutOfBoundsException(index + " > " + inputLength);
		}
	}
	
	public static void checkIndices(CharSequence input, int fromIndex, int toIndex) {
		if (input == null) {
			throw new NullPointerException("input");
		}
		checkIndices(input.length(), fromIndex, toIndex);
	}
	
	public static void checkIndices(int inputLength, int fromIndex, int toIndex) {
		if (fromIndex < 0) {
			throw new StringIndexOutOfBoundsException(fromIndex + " < 0");
		}
		if (toIndex < fromIndex) {
			throw new StringIndexOutOfBoundsException("fromIndex = " + fromIndex + " > " + toIndex + " = toIndex");
		}
		if (inputLength < toIndex) {
			throw new StringIndexOutOfBoundsException(toIndex + " > " + inputLength);
		}
	}
}

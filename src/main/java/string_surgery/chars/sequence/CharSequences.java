package string_surgery.chars.sequence;

import string_surgery.chars.function.IndexFunctions;

import java.nio.charset.Charset;

public class CharSequences {
	
	public static final String EMPTY = "";
	
	public static final Charset UTF_8 = Charset.forName("UTF-8");
	
	public static final SingleChar NOT_A_CHARACTER = new SingleChar('\uFFFF');
	
	private static final SingleChar[] SINGLETON_CHAR_SEQUENCE_CACHE;
	static {
		SINGLETON_CHAR_SEQUENCE_CACHE = new SingleChar[256];
		for (char c = 0; c < SINGLETON_CHAR_SEQUENCE_CACHE.length; c++) {
			SINGLETON_CHAR_SEQUENCE_CACHE[c] = new SingleChar(c);
		}
	}
	
	public static CharSequence empty() {
		return EMPTY;
	}
	
	public static SingleChar of(char character) {
		if (character < SINGLETON_CHAR_SEQUENCE_CACHE.length) {
			return SINGLETON_CHAR_SEQUENCE_CACHE[character];
		}
		if (character == NOT_A_CHARACTER.getChar()) {
			return NOT_A_CHARACTER;
		}
		return new SingleChar(character);
	}
	
	public static CharSequence slice(CharSequence input, int fromIndex, int toIndex) {
		if (input == null) {
			throw new NullPointerException("input");
		}
		
		int inputLength = input.length();
		if (fromIndex == 0 && toIndex == inputLength) {
			return input;
		}
		
		int length = IndexFunctions.checkIndices(inputLength, fromIndex, toIndex);
		if (length == 0) {
			// Optimization that is weirdly absent in `String#substring`.
			return empty();
		}
		if (length == 1) {
			return of(input.charAt(fromIndex));
		}
		
		if (input instanceof Substring) {
			Substring substring = (Substring) input;
			return new Substring(
					substring.getOriginalString(),
					substring.getOffset() + fromIndex,
					length
			);
		}
		
		return new Substring(input.toString(), fromIndex, length);
	}
}

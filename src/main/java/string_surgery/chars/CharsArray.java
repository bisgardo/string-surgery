package string_surgery.chars;

import primitivo.array.CharArray;
import primitivo.array.IntArray;

import java.nio.charset.Charset;

/**
 * @author Michael Bisgaard Olesen
 */
public class CharsArray {
	
	public static byte[] bytesOf(char[] chars, Charset charset) {
		return JavaLangStringFunctions.charsToBytes(chars, charset);
	}
	
	public static byte[] bytesOf(char[] chars, String charsetName) {
		return JavaLangStringFunctions.charsToBytes(chars, charsetName);
	}
	
	public static char[] charsOf(byte[] bytes, Charset charset) {
		return JavaLangStringFunctions.bytesToChars(bytes, charset);
	}
	
	public static char[] charsOf(byte[] bytes, String charsetName) {
		return JavaLangStringFunctions.bytesToChars(bytes, charsetName);
	}
	
	public static char[] charsOf(StringBuffer stringBuffer) {
		return JavaLangStringFunctions.charsOf(stringBuffer);
	}
	
	public static char[] charsOf(StringBuilder stringBuilder) {
		return JavaLangStringFunctions.charsOf(stringBuilder);
	}
	
	public static char[] charsOf(CharSequence charSequence) {
		if (charSequence == null) {
			throw new NullPointerException("charSequence");
		}
		
		if (charSequence instanceof String) {
			return ((String) charSequence).toCharArray();
		}
		if (charSequence instanceof StringBuilder) {
			return charsOf((StringBuilder) charSequence);
		}
		if (charSequence instanceof StringBuffer) {
			return charsOf((StringBuffer) charSequence);
		}
		
		int length = charSequence.length();
		if (length == 0) {
			return CharArray.EMPTY;
		}
		
		char[] chars = new char[length];
		for (int index = 0; index < length; index++) {
			chars[index] = charSequence.charAt(index);
		}
		
		return chars;
	}
	
	public static int[] codePointsOf(CharSequence charSequence) {
		return IntArray.of(
				CharsIteration.codePointIteratorOf(charSequence),
				charSequence.length()
		);
	}
}

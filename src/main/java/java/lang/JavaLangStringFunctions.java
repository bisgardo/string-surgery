package java.lang;

import primitivo.array.CharArray;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * Utility class for exposing package-private functionality of
 * {@link java.lang} while wrapping legacy exceptions.
 *
 * @author Michael Bisgaard Olesen
 */
public class JavaLangStringFunctions {
	
	public static byte[] charsToBytes(char[] chars, Charset charset) {
		if (chars == null) {
			throw new NullPointerException("chars");
		}
		if (charset == null) {
			throw new NullPointerException("charset");
		}
		return StringCoding.encode(charset, chars, 0, chars.length);
	}
	
	public static byte[] charsToBytes(char[] chars, String charsetName) {
		if (chars == null) {
			throw new NullPointerException("chars");
		}
		if (charsetName == null) {
			throw new NullPointerException("charsetName");
		}
		try {
			return StringCoding.encode(charsetName, chars, 0, chars.length);
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedCharsetException(charsetName);
		}
	}
	
	public static char[] bytesToChars(byte[] bytes, Charset charset) {
		if (bytes == null) {
			throw new NullPointerException("bytes");
		}
		if (charset == null) {
			throw new NullPointerException("charset");
		}
		return StringCoding.decode(charset, bytes, 0, bytes.length);
	}
	
	public static char[] bytesToChars(byte[] bytes, String charsetName) {
		if (bytes == null) {
			throw new NullPointerException("bytes");
		}
		if (charsetName == null) {
			throw new NullPointerException("charsetName");
		}
		try {
			return StringCoding.decode(charsetName, bytes, 0, bytes.length);
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedCharsetException(charsetName);
		}
	}
	
	@SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
	public static char[] charsOf(StringBuffer stringBuffer) {
		synchronized (stringBuffer) {
			return charsOf((AbstractStringBuilder) stringBuffer);
		}
	}
	
	public static char[] charsOf(StringBuilder stringBuilder) {
		return charsOf((AbstractStringBuilder) stringBuilder);
	}
	
	static char[] charsOf(AbstractStringBuilder abstractStringBuilder) {
		if (abstractStringBuilder == null) {
			throw new NullPointerException("abstractStringBuilder");
		}
		int length = abstractStringBuilder.length();
		if (length == 0) {
			return CharArray.EMPTY;
		}
		
		char[] chars = new char[length];
		System.arraycopy(abstractStringBuilder.value, 0, chars, 0, length);
		return chars;
	}
}

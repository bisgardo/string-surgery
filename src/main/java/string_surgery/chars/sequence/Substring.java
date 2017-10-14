package string_surgery.chars.sequence;

import primitivo.iterate.CharIterator;
import string_surgery.chars.function.IndexFunctions;

import java.io.IOException;
import java.io.Serializable;
import java.util.NoSuchElementException;

public class Substring implements AppendingCharSequence, Serializable {
	private static final long serialVersionUID = 4697708162472844808L;
	
	private final String string;
	private final int offset;
	private final int length;
	
	Substring(String string, int offset, int length) {
		this.string = string;
		this.offset = offset;
		this.length = length;
	}
	
	public static Substring of(String string, int offset, int length) {
		IndexFunctions.checkIndices(string, offset, offset + length);
		return new Substring(string, offset, length);
	}
	
	public String getOriginalString() {
		return string;
	}
	
	public int getOffset() {
		return offset;
	}
	
	//@Override
	public int length() {
		return length;
	}
	
	//@Override
	public char charAt(int index) {
		return string.charAt(offset + index);
	}
	
	//@Override
	public CharSequence subSequence(int fromIndex, int toIndex) {
		return CharSequences.slice(this, fromIndex, toIndex);
	}
	
	@Override
	public String toString() {
		return string.substring(offset, offset + length);
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		
		Substring subSequence = (Substring) object;
		return offset == subSequence.offset &&
				length == subSequence.length &&
				string.equals(subSequence.string);
		
	}
	
	@Override
	public int hashCode() {
		return 31 * (31 * string.hashCode() + offset) + length;
	}
	
	//@Override
	public void appendTo(StringBuilder stringBuilder) {
		stringBuilder.append(string, offset, offset + length);
	}
	
	//@Override
	public void appendTo(Appendable appendable) throws IOException {
		appendable.append(string, offset, offset + length);
	}
	
	//@Override
	public CharIterator iterator() {
		return new CharIterator() {
			private int index;
			
			//@Override
			public boolean hasNext() {
				return index < length;
			}
			
			@Override
			public char nextChar() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return string.charAt(offset + index++);
			}
		};
	}
}

package string_surgery.sequence;

import primitivo.iterate.CharIterator;

import java.io.IOException;
import java.io.Serializable;

// TODO Add `SingleCodePoint`?
public class SingleChar implements AppendingCharSequence, Serializable {
	private static final long serialVersionUID = -8488207078567828258L;
	
	private final char character;
	
	public SingleChar(char character) {
		this.character = character;
	}
	
	public static SingleChar of(CharSequence input, int index) {
		if (input == null) {
			throw new NullPointerException("input");
		}
		return new SingleChar(input.charAt(index));
	}
	
	public char getChar() {
		return character;
	}
	
	//@Override
	public int length() {
		return 1;
	}
	
	//@Override
	public char charAt(int index) {
		if (index != 0) {
			throw new StringIndexOutOfBoundsException(index);
		}
		return character;
	}
	
	//@Override
	public CharSequence subSequence(int fromIndex, int toIndex) {
		if (fromIndex == 0) {
			if (toIndex == 0) {
				return CharSequences.empty();
			}
			if (toIndex == 1) {
				return this;
			}
		}
		throw new IndexOutOfBoundsException();
	}
	
	@Override
	public int hashCode() {
		return (int) character;
	}
	
	@Override
	public boolean equals(Object object) {
		if (object == this) {
			return true;
		}
		if (object == null || getClass() != object.getClass()) {
			return false;
		}
		
		SingleChar other = (SingleChar) object;
		return character == other.character;
	}
	
	@Override
	public String toString() {
		return String.valueOf(character);
	}
	
	//@Override
	public void appendTo(StringBuilder stringBuilder) {
		stringBuilder.append(character);
	}
	
	//@Override
	public void appendTo(Appendable appendable) throws IOException {
		appendable.append(character);
	}
	
	//@Override
	public CharIterator iterator() {
		return CharIterator.of(character);
	}
}

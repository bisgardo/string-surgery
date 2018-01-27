package string_surgery.iteration;

import primitivo.iterate.CharIterator;
import primitivo.iterate.IntIterator;

import java.util.NoSuchElementException;

/**
 * @author Michael Bisgaard Olesen
 */
public class CharsIteration {
	
	public static CharIterator charIteratorOf(final CharSequence charSequence) {
		if (charSequence == null) {
			throw new NullPointerException("charSequence");
		}
		final int length = charSequence.length();
		if (length == 0) {
			return CharIterator.EMPTY;
		}
		return new CharIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < length;
			}
			
			@Override
			public char nextChar() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				return charSequence.charAt(index++);
			}
		};
	}
	
	public static IntIterator codePointIteratorOf(final CharSequence charSequence) {
		if (charSequence == null) {
			throw new NullPointerException("charSequence");
		}
		final int length = charSequence.length();
		if (length == 0) {
			return IntIterator.EMPTY;
		}
		return new IntIterator() {
			private int index = 0;
			
			//@Override
			public boolean hasNext() {
				return index < length;
			}
			
			@Override
			public int nextInt() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				int codePoint = Character.codePointAt(charSequence, index);
				index += Character.charCount(codePoint);
				return codePoint;
			}
		};
	}
}

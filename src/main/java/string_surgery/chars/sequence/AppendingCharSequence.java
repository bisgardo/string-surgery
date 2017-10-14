package string_surgery.chars.sequence;

import primitivo.iterate.CharIterator;

public interface AppendingCharSequence extends CharSequence, Appender, Iterable<Character> {
	
	CharIterator iterator();
}

package string_surgery.sequence;

import primitivo.iterate.CharIterator;

public interface AppendingCharSequence extends CharSequence, Appender, Iterable<Character> {
	
	CharIterator iterator();
}

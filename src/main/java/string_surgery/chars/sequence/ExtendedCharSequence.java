package string_surgery.chars.sequence;

import primitivo.iterate.CharIterator;

import java.io.IOException;
import java.io.Writer;

public interface ExtendedCharSequence extends CharSequence, Iterable<Character> {
	
	void appendTo(StringBuilder stringBuilder);
	
	void writeTo(Writer writer) throws IOException;
	
	CharIterator iterator();
}

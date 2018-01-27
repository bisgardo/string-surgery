package string_surgery.sequence;

import java.io.IOException;

public interface Appender {
	
	void appendTo(StringBuilder stringBuilder);
	
	void appendTo(Appendable appendable) throws IOException;
}

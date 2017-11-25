package cls.gui_new;

import java.util.EventObject;

public class ListEvent extends EventObject {
	String info;
	int type;
	public ListEvent(Object source, String info,int type) {
		super(source);
		this.info = info;
		this.type = type;
	}
}

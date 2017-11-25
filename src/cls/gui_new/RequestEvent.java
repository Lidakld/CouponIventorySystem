package cls.gui_new;

import java.awt.event.ActionListener;
import java.util.EventObject;

public class RequestEvent extends EventObject {
	int type;
	
	public RequestEvent(ActionListener source, int type) {
		super(source);
		this.type = type;
	}	
}

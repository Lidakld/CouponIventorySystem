package cls.gui_new;

import java.util.EventObject;

import cls.beans.Msg;

public class ResultEvent extends EventObject {
	private String str;
	
	public ResultEvent(Object source, String str) {
		super(source);
		this.str = str;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@Override
	public String toString() {
		return str;
	}

	
}

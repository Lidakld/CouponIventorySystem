package cls.beans;

import cls.util.LinkedList;

public class Msg<E extends Comparable<E>> {
	private String message;
	private Integer error;//-1 for false 
	private LinkedList<E> data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Integer getError() {
		return error;
	}
	public void setError(Integer error) {
		this.error = error;
	}
	public LinkedList<E> getData() {
		return data;
	}
	public void setData(LinkedList<E> data) {
		this.data = data;
	}
	
}

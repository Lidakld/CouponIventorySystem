package cls.beans;

public class CouponProvider {
	private String name;

	public CouponProvider(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof CouponProvider) {
			if(this.name.equals(((CouponProvider)obj).getName())){
				return true;
			}
		}
		return false;
	}

}

package cls.beans;

public class Product{
	private String name;
	private Float price;

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Product(String name, Float price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Product) {
			if(this.price.equals(((Product)obj).getPrice()) && this.name.equals(((Product)obj).getName())) {
				return true;
			}
		}
		return false;
	}

}

package cls.gui_new;


import java.util.EventObject;

public class FormEvent extends EventObject {
	private String provider;
	private String prodName;
	private String prodPrice;
	private String dRate;
	private String expirePeriod;
	private String status;
	
	public FormEvent(Object source, String provider, String prodName, String prodPrice, String dRate, 
			String expirePeriod, String status) {
		super(source);
		this.provider = provider;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.dRate = dRate;
		this.expirePeriod = expirePeriod;
		this.status = status;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(String prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getdRate() {
		return dRate;
	}

	public void setdRate(String dRate) {
		this.dRate = dRate;
	}

	public String getExpirePeriod() {
		return expirePeriod;
	}

	public void setExpirePeriod(String expirePeriod) {
		this.expirePeriod = expirePeriod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}

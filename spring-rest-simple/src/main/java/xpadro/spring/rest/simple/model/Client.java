package xpadro.spring.rest.simple.model;

import java.io.Serializable;

public class Client implements Serializable {
	private static final long serialVersionUID = -6358742378177948329L;

	private final String id;
	private final double purchases;
	
	public Client(String id, double purchases) {
		this.id = id;
		this.purchases = purchases;
	}

	public String getId() {
		return id;
	}

	public double getPurchases() {
		return purchases;
	}
}

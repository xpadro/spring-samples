package xpadro.spring.rest.simple.model;

import java.io.Serializable;

public class Client implements Serializable {
	private static final long serialVersionUID = -6358742378177948329L;

	private final String name;
	private final double purchases;
	
	public Client(String name, double purchases) {
		this.name = name;
		this.purchases = purchases;
	}

	public String getName() {
		return name;
	}

	public double getPurchases() {
		return purchases;
	}
}

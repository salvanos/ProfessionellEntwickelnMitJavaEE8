package de.java2enterprise.onlineshop.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-02-03T09:20:04.517+0100")
@StaticMetamodel(Customer.class)
public class Customer_ {
	public static volatile SingularAttribute<Customer, Long> id;
	public static volatile SingularAttribute<Customer, String> email;
	public static volatile SingularAttribute<Customer, String> password;
	public static volatile SetAttribute<Customer, Item> offers;
	public static volatile SetAttribute<Customer, Item> purchases;
}

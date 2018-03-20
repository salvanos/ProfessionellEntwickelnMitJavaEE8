package de.java2enterprise.onlineshop.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-01-25T21:11:45.701+0100")
@StaticMetamodel(Item.class)
public class Item_ {
	public static volatile SingularAttribute<Item, Long> id;
	public static volatile SingularAttribute<Item, String> description;
	public static volatile SingularAttribute<Item, byte[]> foto;
	public static volatile SingularAttribute<Item, Double> price;
	public static volatile SingularAttribute<Item, LocalDateTime> sold;
	public static volatile SingularAttribute<Item, String> title;
	public static volatile SingularAttribute<Item, Customer> seller;
	public static volatile SingularAttribute<Item, Customer> buyer;
}

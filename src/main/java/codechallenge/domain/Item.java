package codechallenge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Item implements Comparable<Item> {
	
	private final static String DOMAIN = "ITEM";
	private final static int ITEM_COUNT = 10;
	
	private String name;
	private int price;
	private int shippingCost;
	private int rating;
	
	public Item(String name, int price, int shippingCost, int rating) {
		super();
		this.name = name;
		this.price = price;
		this.shippingCost = shippingCost;
		this.rating = rating;
	}

	public String getName() {
		return name;
	}

	public Item setName(String name) {
		this.name = name;
		return this;
	}

	public int getPrice() {
		return price;
	}

	public Item setPrice(int price) {
		this.price = price;
		return this;
	}

	public int getShippingCost() {
		return shippingCost;
	}

	public Item setShippingCost(int shippingCost) {
		this.shippingCost = shippingCost;
		return this;
	}

	public int getRating() {
		return rating;
	}

	public Item setRating(int rating) {
		this.rating = rating;
		return this;
	}
	
	public int getCost() {
		return getPrice() + getShippingCost();
	}
	
	@Override
	public int hashCode() {
	    return Objects.hashCode(getName());
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Item item = (Item) o;
        if (item.getName() == null || getName() == null) {
            return false;
        }
        return Objects.equals(getName(), item.getName());
    }
	
	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
	
	@Override
	public int compareTo(Item item) {
		int compare = Integer.compare(getCost(), item.getCost());
		if(compare == 0) {
			compare = Integer.compare(item.getRating(), getRating());
		}
		return compare;
	}
	
	public static List<Item> getItemsData() {
		List<Item> items = new ArrayList<Item>();
		for(int i=1; i<=ITEM_COUNT; i++) {
			String itemName = DOMAIN + i;
			int price = (int)(Math.random() * ((Constants.PRICE_MAX.getValue() - Constants.PRICE_MIN.getValue()) + 1)) + Constants.PRICE_MIN.getValue();
			int shippingCost = (int)(Math.random() * ((Constants.SHIPPINGCOST_MAX.getValue() - Constants.SHIPPINGCOST_MIN.getValue()) + 1)) + Constants.SHIPPINGCOST_MIN.getValue();
			int rating = (int)(Math.random() * ((Constants.RATING_MAX.getValue() - Constants.RATING_MIN.getValue()) + 1)) + Constants.RATING_MIN.getValue();
			items.add(new Item(itemName, price, shippingCost, rating));
		}
		return items;
	}
}
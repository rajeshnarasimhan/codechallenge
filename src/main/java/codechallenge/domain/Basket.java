package codechallenge.domain;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Basket {
	
	private int totalCost;
	private int totalRating;
	private List<BasketItem> basketItems;
	
	public Basket() {
		super();
		basketItems = new ArrayList<BasketItem>();
	}

	public int getTotalCost() {
		return totalCost;
	}

	public Basket setTotalCost(int totalCost) {
		this.totalCost = totalCost;
		return this;
	}
	
	public int addToTotalCost(int cost) {
		this.totalCost += cost;
		return getTotalCost();
	}

	public int getTotalRating() {
		return totalRating;
	}

	public Basket setTotalRating(int totalRating) {
		this.totalRating = totalRating;
		return this;
	}
	
	public int addToTotalRating(int rating) {
		this.totalRating += rating;
		return getTotalRating();
	}
	
	public List<BasketItem> getBasketItems() {
		return basketItems;
	}

	public Basket setBasketItems(List<BasketItem> basketItems) {
		this.basketItems = basketItems;
		return this;
	}
	
	public Basket addToBasketItems(BasketItem basketItem) {
		this.basketItems.add(basketItem);
		return this;
	}

	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}

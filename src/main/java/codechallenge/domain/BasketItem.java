package codechallenge.domain;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class BasketItem {
	
	private Category category;
	private Item item;
	
	public BasketItem(Category category, Item item) {
		super();
		this.category = category;
		this.item = item;
	}
	
	public Category getCategory() {
		return category;
	}

	public BasketItem setCategory(Category category) {
		this.category = category;
		return this;
	}

	public Item getItem() {
		return item;
	}

	public BasketItem setItem(Item item) {
		this.item = item;
		return this;
	}

	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
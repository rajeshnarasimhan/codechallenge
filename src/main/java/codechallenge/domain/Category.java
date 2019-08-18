package codechallenge.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class Category {
	
	private final static String DOMAIN = "CATEGORY";
	private final static int CATEGORY_COUNT= 20;
	private String name;
	private List<Item> items;
	
	public Category() {
		super();
		items = new ArrayList<Item>();
	}
	
	public Category(String name, List<Item> items) {
		super();
		this.name = name;
		this.items = items;
	}

	public String getName() {
		return name;
	}

	public Category setName(String name) {
		this.name = name;
		return this;
	}

	public List<Item> getItems() {
		return items;
	}

	public Category setItems(List<Item> items) {
		this.items = items;
		return this;
	}
	
	public Category addItem(Item item) {
		this.items.add(item);
		return this;
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
        Category category = (Category) o;
        if (category.getName() == null || getName() == null) {
            return false;
        }
        return Objects.equals(getName(), category.getName());
    }
	
	@Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
	
	public static List<Category> getCategoriesData(){
		List<Category> categories = new ArrayList<Category>();
		for(int i=1; i<=CATEGORY_COUNT; i++) {
			String name = DOMAIN + i;
			List<Item> items = Item.getItemsData();
			categories.add(new Category(name, items));
		}
		return categories;	
	}
}
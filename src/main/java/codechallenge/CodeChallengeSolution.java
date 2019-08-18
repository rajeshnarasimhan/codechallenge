package codechallenge;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;

import codechallenge.domain.Basket;
import codechallenge.domain.BasketItem;
import codechallenge.domain.Category;
import codechallenge.domain.Constants;
import codechallenge.domain.Item;

public class CodeChallengeSolution {
	
	public static final Logger LOGGER = Logger.getLogger(CodeChallengeSolution.class);

	public static void main(String[] args) {
		LOGGER.info("CodeChallenge Solution Started...");
		List<Category> categories = Category.getCategoriesData();
		sortItemsinEachCategory(categories);
		printInitialData(categories);
		Basket basket = pickForBasket(categories);
		printSelectedBasket(basket);
	}
	
	public static void printInitialData(List<Category> categories) {
		LOGGER.info("Printing initial data.");
		for(Category cat: categories) {
			LOGGER.info("****************************");
			LOGGER.info(String.format("Category=[%s]. ItemsCount=[%d]", cat.getName(), cat.getItems().size()));
			cat.getItems().forEach( item -> {
				LOGGER.info(String.format("Item=[%s]. Price=[%d]. ShippingCost=[%d]. Rating=[%d]", item.getName(), item.getPrice(), item.getShippingCost(), item.getRating()));
			});
			LOGGER.info("****************************");
		}
	}
	
	public static void sortItemsinEachCategory(List<Category> categories) {
		LOGGER.info("Sorting items in each Category.");
		for(Category cat: categories) {
			LOGGER.info(String.format("Sorting items in Category=[%s].", cat.getName()));
			Collections.sort(cat.getItems());
		}
	}
	
	public static Basket pickForBasket(List<Category> categories) {
		LOGGER.info("Picking items from each category in basket.");
		Basket basket = new Basket();
		for(Category cat: categories) {
			Item catItem = cat.getItems().get(0);
			if(basket.addToTotalCost(catItem.getCost()) > Constants.BASKET_TOTALCOST_LIMIT.getValue()) {
				basket.addToTotalCost(-catItem.getCost());
			}else{
				basket.addToBasketItems(new BasketItem(cat, catItem));
				basket.addToTotalRating(catItem.getRating());
			}
		}
		return basket;
	}
	
	public static void printSelectedBasket(Basket basket) {
		LOGGER.info("Printing items in selected basket.");
		LOGGER.info("****************************");
		LOGGER.info(String.format("Basket. TotalCost=[%d]. TotalRating=[%d]", basket.getTotalCost(), basket.getTotalRating()));
		LOGGER.info("Basket Items");
		basket.getBasketItems().forEach( basketItem -> {
			LOGGER.info(String.format("[%s]:[%s]. Cost=[%d]. Rating=[%d]", basketItem.getCategory().getName(), basketItem.getItem().getName(),
					basketItem.getItem().getCost(), basketItem.getItem().getRating()));
		});	
	}
}
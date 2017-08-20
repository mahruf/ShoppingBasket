package sb;

import java.util.Map;
import java.util.TreeMap;


public class ShoppingBasket {

	public static void main(String[] args) throws Exception {      

		Map<String,Item> tempBasket = new TreeMap<String,Item>();

		//Add items to the basket
		Item one = new Item();
		one.setItemName(ItemList.DRINK.name());
		one.setCost(ItemList.DRINK.getValue());
		one.setQuantity(1);
		tempBasket.put(one.getItemName(), one);

		Item two = new Item();
		two.setItemName(ItemList.CHIPS.name());
		two.setCost(ItemList.CHIPS.getValue());
		two.setQuantity(2);
		tempBasket.put(two.getItemName(), two);

		Item three = new Item();
		three.setItemName(ItemList.BURGER.name());
		three.setCost(ItemList.BURGER.getValue());
		three.setQuantity(3);
		tempBasket.put(three.getItemName(), three);
		
		Items cartItems = new Items();
		cartItems.setItem(tempBasket);
		System.out.println(cartItems.getBasketContents());
		System.out.println("-------");
		tempBasket.clear();
		
		//Add the same item to a basket
		Item four = new Item();
		four.setItemName(ItemList.BURGER.name());
		four.setCost(ItemList.BURGER.getValue());
		four.setQuantity(5);
		tempBasket.put(four.getItemName(), four);
		cartItems.setItem(tempBasket);
		System.out.println(cartItems.getBasketContents());
		System.out.println("-------");
		tempBasket.clear();
		
		//Remove an item from basket
		Item five = new Item();
		five.setItemName(ItemList.BURGER.name());
		five.setCost(ItemList.BURGER.getValue());
		five.setQuantity(-1);
		tempBasket.put(five.getItemName(), five);
		cartItems.setItem(tempBasket);
		System.out.println(cartItems.getBasketContents());
		System.out.println("-------");
		tempBasket.clear();
	}    

}

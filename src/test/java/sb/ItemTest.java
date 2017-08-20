package sb;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class ItemTest {

	private Map<String,Item> tempBasket;
	Items cartItems;

	private static final String addOneItemToBasket = " ItemName = DRINK | Unit Cost = 10 | Quantity = 1 | SubTotal = 10\n" + 
			" | Total = 10";

	private static final String addTwoItemsToBasket = " ItemName = CHIPS | Unit Cost = 50 | Quantity = 2 | SubTotal = 100\n" + 
			" ItemName = DRINK | Unit Cost = 10 | Quantity = 1 | SubTotal = 10\n" + 
			" | Total = 110";	

	private static final String addSameItemToBasket = " ItemName = CHIPS | Unit Cost = 50 | Quantity = 7 | SubTotal = 350\n" + 
			" | Total = 350";


	@Before
	public void setUp() throws Exception {
		tempBasket = new HashMap<String,Item>();
		cartItems = new Items();
	}


	@Test
	public void testPojos() throws Exception {

		//Add an Item to the basket
		Item one = new Item();
		one.setItemName(ItemList.DRINK.name());
		one.setCost(10);
		one.setQuantity(1);
		tempBasket.put(ItemList.DRINK.name(), one);
		cartItems.setItem(tempBasket);

		assertEquals(1, cartItems.getTotalItems());
		assertEquals(one, cartItems.getItem().get(ItemList.DRINK.name()));

		assertEquals(ItemList.DRINK.name(),one.getItemName());
		assertEquals(10, one.getCost());
		assertEquals(1, one.getQuantity());

		assertEquals(10, cartItems.getTotal());
		assertEquals(addOneItemToBasket, cartItems.getBasketContents());
		tempBasket.clear();

		//Add a second item to the basket
		Item two = new Item();
		two.setItemName(ItemList.CHIPS.name());
		two.setCost(50);
		two.setQuantity(2);
		tempBasket.put(ItemList.CHIPS.name(), two);
		cartItems.setItem(tempBasket);

		assertEquals(2, cartItems.getTotalItems());
		assertEquals(two, cartItems.getItem().get(ItemList.CHIPS.name()));

		assertEquals(ItemList.CHIPS.name(),two.getItemName());
		assertEquals(50, two.getCost());
		assertEquals(2, two.getQuantity());

		assertEquals(110, cartItems.getTotal());
		assertEquals(addTwoItemsToBasket, cartItems.getBasketContents());
		tempBasket.clear();
	}

	@Test
	public void testAddSameItem() throws Exception {

		//Add the same item to a basket
		itemTwo();
		Item three = new Item();
		three.setItemName(ItemList.CHIPS.name());
		three.setCost(50);
		three.setQuantity(5);
		tempBasket.put(ItemList.CHIPS.name(), three);
		cartItems.setItem(tempBasket);

		assertEquals(1, cartItems.getTotalItems());
		assertEquals(350, cartItems.getTotal());
		assertEquals(addSameItemToBasket, cartItems.getBasketContents());

	}
	
	@Test(expected = Exception.class)
	public void testAddInvalidQuantities() throws Exception{
		//invalid quantities added to the basket
		Item four = new Item();
		four.setItemName(ItemList.CHIPS.name());
		four.setCost(50);
		four.setQuantity(500);
		tempBasket.put(ItemList.CHIPS.name(), four);
		cartItems.setItem(tempBasket);
		tempBasket.clear();
	}


	public void itemTwo() throws Exception {
		Item two = new Item();
		two.setItemName(ItemList.CHIPS.name());
		two.setCost(50);
		two.setQuantity(2);
		tempBasket.put(ItemList.CHIPS.name(), two);
		cartItems.setItem(tempBasket);
		tempBasket.clear();
	}
}

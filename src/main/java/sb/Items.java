package sb;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Items {

	private Map<String,Item> basket = new HashMap<String,Item>();

	public Map<String,Item> getItem(){
		return basket;
	}

	public void setItem(Map<String,Item> ibasket) throws Exception {
		for (Entry<String, Item> entry : ibasket.entrySet()) {
			if(basket.containsKey(entry.getKey())) {
				Item i = basket.get(entry.getKey());
				if(i.getQuantity() + entry.getValue().getQuantity() <= getStock(entry.getKey())){
					i.setQuantity(i.getQuantity() + entry.getValue().getQuantity());
					basket.put(entry.getKey(), i);
				} else {
					throw new Exception("Invalid Quantity!");
				}
			} else {
				if(entry.getValue().getQuantity() <= getStock(entry.getKey())){
					basket.put(entry.getKey(),entry.getValue());
				}else {
					throw new Exception("Invalid Quantity!");
				}
			}
		}
	}

	public String getBasketContents() {
		StringBuilder sb = new StringBuilder();
		for (Entry<String, Item> entry : basket.entrySet()) {
			sb.append(
					" ItemName = " + entry.getValue().getItemName() + 
					" | Unit Cost = " + entry.getValue().getCost() + 
					" | Quantity = " + entry.getValue().getQuantity() + 
					" | SubTotal = " + (entry.getValue().getCost()*entry.getValue().getQuantity()));
			sb.append("\n");
		}
		sb.append(" | Total = " + getTotal());
		return sb.toString();
	}


	public int getTotal() {
		int totalcost = 0;
		for (Entry<String, Item> entry : basket.entrySet()) {
			totalcost += (entry.getValue().getCost()*entry.getValue().getQuantity());
		}
		return totalcost;
	}

	public int getTotalItems() {
		return basket.size();
	}

	public int getStock(String name){
		int stockQty = 0;
		if(ItemList.BURGER.name().equals(name)) {
			stockQty = ItemList.BURGER.getStockQuantity();
		} else if (ItemList.CHIPS.name().equals(name)) {
			stockQty = ItemList.CHIPS.getStockQuantity();
		} else if (ItemList.DRINK.name().equals(name)) {
			stockQty = ItemList.DRINK.getStockQuantity();
		}
		return stockQty;
	}



}
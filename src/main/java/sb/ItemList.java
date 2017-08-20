package sb;

public enum ItemList { BURGER(1,100), CHIPS(5,200), DRINK(10,1000), DESSERT(25,500); 
		
		private int value; 
		private int qty;
		
		private ItemList(int value, int qty) { 
			this.value = value; 
			this.qty = qty;
		} 
		
		public int getValue() { return value; }
		
		public int getStockQuantity() { return qty; }
	}; 
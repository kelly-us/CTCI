package CTCI.Chapter3;

public abstract class Animal {
	private int order;
	String name;
	
	public Animal(String n){
		name = n;
	}
	
	public abstract String name();
	
	public void setOrder(int ord){
		order = ord;
	}
	
	public int getOrder(){
		return order;
	}
	
	public boolean isOlderThan(Animal a){
		return this.order < a.getOrder();
	}
	
}

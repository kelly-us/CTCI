package CTCI.Chapter3;

import java.util.LinkedList;

public class AnimalQueue {
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	private int order = 0;
	
	public void enqueue(Animal a){
		a.setOrder(order);
		order++;
		if(a instanceof Dog){
			dogs.addLast((Dog) a);
		} else if(a instanceof Cat){
			cats.addLast((Cat) a);
		}
	}
	
	public Animal dequeueAny(){
		if(dogs.size() == 0){
			return dequeueCats();
		}else if(cats.size() == 0){
			return dequeueDogs();
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if(dog.isOlderThan(cat)){
			return dequeueDogs();
		}else{
			return dequeueCats();
		}
	}
	
	public Cat dequeueCats(){
		return cats.poll();
	}
	
	public Dog dequeueDogs(){
		return dogs.poll();
	}
	
	public int size(){
		return cats.size() + dogs.size();
	}
	
	public static void main(String[] args) {
		AnimalQueue animals = new AnimalQueue();
		animals.enqueue(new Cat("Callie"));
		animals.enqueue(new Cat("Kiki"));
		animals.enqueue(new Dog("Fido"));
		animals.enqueue(new Dog("Dora"));
		animals.enqueue(new Cat("Kari"));
		animals.enqueue(new Dog("Dexter"));
		animals.enqueue(new Dog("Dobo"));
		animals.enqueue(new Cat("Copa"));
		
		System.out.println(animals.dequeueDogs().name());
		System.out.println(animals.dequeueCats().name());
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		System.out.println(animals.dequeueAny().name());	
		
		animals.enqueue(new Dog("Dapa"));
		animals.enqueue(new Cat("Kilo"));
		
		while (animals.size() != 0) {
			System.out.println(animals.dequeueAny().name());	
		}
	}
}

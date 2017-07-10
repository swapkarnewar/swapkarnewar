package swapk.singleton;

public class EagerInitializedSingleton {

	/**
	 * We need
	 * private constructor to restrict instantiation of class from other class
	 * private static variable of same class that is the only instance of class exists
	 * public static method to get that instance of class, this is global access point for outer
	 * world to get the instance of the singleton class
	 * */
	
	private EagerInitializedSingleton(){}
	
	private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
	
	public static EagerInitializedSingleton getInstance(){
		return instance;
	}
	
}

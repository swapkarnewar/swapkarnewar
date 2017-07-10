package swapk.collection.CustHashMap;

public class HashMapCustomApp {

	public static void main(String[] args) 
	{
		HashMapCustomGen<Employee, Integer> hashMapCustom = new HashMapCustomGen<Employee, Integer>();
		hashMapCustom.put(new Employee(1, "Harneesha"), 1);
		hashMapCustom.put(new Employee(1, "Swapnil"), 2);
		hashMapCustom.put(new Employee(3, "Nitil"), 3);
		hashMapCustom.put(new Employee(4, "Aju"), 4);
		hashMapCustom.put(new Employee(5, "Priyanka"), 5);
		hashMapCustom.display();
		
		System.out.println(hashMapCustom.get(new Employee(4, "Aju")));
		System.out.println(hashMapCustom.remove(new Employee(4, "Aju")));
		hashMapCustom.display();
		
		/*Employee emp = new Employee("swapnil", "harneesha");
		System.out.println(emp);*/
	}

}

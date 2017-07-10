import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparableUsageExample {

	public static void main(String[] args) {
		Employee emp1 = new Employee("swap", "1");
		Employee emp2 = new Employee("harneesha", "2");
		Employee emp3 = new Employee("harneesha1", "3");
		
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		
		System.out.println(list);
		//Collections.sort(list);
		Collections.sort(list, new Comparator<Employee>() {

			@Override
			public int compare(Employee o1, Employee o2) {
				System.out.println("in");
				return o1.name.compareTo(o2.name);
			}
		});
		
		System.out.println(list);
	}

}

class Employee implements Comparable<Employee> {
    
	String name;
    String id;
    
    public Employee(String name, String id) {
        this.name = name;
        this.id = id;
    }
   
    @Override
    public int compareTo(Employee otherEmployee) {
       //sort Employee on basis of name(ascending order)
       return otherEmployee.name.compareTo(this.name);
    }
 
    // toString() method overrides Object class’s toString() method.
    // toString() method is used to give a string representation of an object.
    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", id=" + id  + '}';
    }
}
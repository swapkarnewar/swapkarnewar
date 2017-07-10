package swapk.collection.CustArrayList;


public class ArrayListCustomApp {

	public static void main(String[] args) {
		ArrayListCustom<Integer> arrayList = new ArrayListCustom<>();
		arrayList.add(1);
		arrayList.add(2);
		arrayList.add(3);
		System.out.println(arrayList);
		
		arrayList.remove(1);
		System.out.println(arrayList);

		/*List<Integer> arr = new ArrayList<Integer>();
		arr.add(1);
		System.out.println(arr.toString());*/
		
	}

}


public class DiamondTest {

	static String mobile;
	static String email;
	static int i = 1;
	int j = 1;
	static class InnerClassTest {
		private void disp() {
			System.out.println("in statisc inner class");
			i = 1;
			System.out.println(i);
			addNewFields();
		}
		static final int k = 0;
	}
	
	static void addNewFields() {
		String label = "swapnil";
		System.out.println("outetr="+label);
		
		class TextFieldSwap {
			
			public void add() {
				System.out.println(label);
				System.out.println(mobile);
				System.out.println(email);
				System.out.println(i);
			}
		}
		
		TextFieldSwap t = new TextFieldSwap();
		t.add();
		TextFieldSwap re = new TextFieldSwap();
		re.add();
	}
	
	public DiamondTest(String mobile, String email) {
		this.mobile = mobile;
		this.email = email;
	}
	
	public static void main(String[] args) {
		
		//DiamondTest t = new DiamondTest("12", "swa");
		
		InnerClassTest t1 = new DiamondTest.InnerClassTest();
		t1.disp();
		
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiamondTest other = (DiamondTest) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		return true;
	}



	

}

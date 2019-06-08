
public class CARDOrderAttribute {
	


	private static final long serialVersionUID = 1L;
	@Override
	public String toString() {
		return "CARDOrderAttribute [name=" + name + ", value=" + value + "]";
	}

	private String name = null;
	private String value = null;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}


	
}

import java.util.Arrays;



public class CARDDistributionOrderData {

	private static final long serialVersionUID = 1L;
	
	private CARDOrderAttribute[] orderAttributeList = null;

	

	public CARDOrderAttribute[] getOrderAttributeList() {
		return orderAttributeList;
	}

	public void setOrderAttributeList(CARDOrderAttribute[] orderAttributeList) {
		this.orderAttributeList = orderAttributeList;
	}

	@Override
	public String toString() {
		return "CARDDistributionOrderData [orderAttributeList="
				+ Arrays.toString(orderAttributeList) + "]";
	}

	
}

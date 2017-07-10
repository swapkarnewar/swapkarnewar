package swapk.design.abstractFactory;

import swapk.design.model.Computer;

public class ComputerFactory {
	public static Computer getComputer(ComputerAbstractFactory factory){
		return factory.craeteComputer();
	}
}

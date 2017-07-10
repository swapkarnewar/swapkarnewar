package swapk.design.abstractFactory;

import swapk.design.model.Computer;
import swapk.design.model.PC;

public class PCFactory implements ComputerAbstractFactory {

	private String ram;
	private String hdd;
	private String cpu;
	
	public PCFactory(String ram, String hdd, String cpu){
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}
	
	@Override
	public Computer craeteComputer() {
		// TODO Auto-generated method stub
		return new PC(ram, hdd, cpu);
	}

}

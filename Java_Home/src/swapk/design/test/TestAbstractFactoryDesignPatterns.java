package swapk.design.test;

import swapk.design.abstractFactory.ComputerFactory;
import swapk.design.abstractFactory.PCFactory;
import swapk.design.abstractFactory.ServerFactory;
import swapk.design.model.Computer;

public class TestAbstractFactoryDesignPatterns {
	
	public static void main(String args[]){
		
		Computer pc = ComputerFactory.getComputer( new PCFactory("8 Gb", "220 Gb", "2.2 GHz") );
		Computer server = ComputerFactory.getComputer( new ServerFactory("16 Gb", "100 Gb", "4.2 GHz") );
		
		System.out.println("Abstract Factory PC : "+pc);
		System.out.println("Abstract Factory Server : "+server);
	}
	
}

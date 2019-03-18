package arun.pkg.practice.design_patterns.creational_patterns.abstract_factory_pattern;

public class TestFactory {
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer(new PCAbstractFactory("2 GB", "500 GB", "2.4 GHz"));
		Computer server = ComputerFactory.getComputer(new ServerAbstractFactory("16 GB", "1 TB", "2.9 GHz"));
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::" + server);
	}
}

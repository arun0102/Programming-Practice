package arun.pkg.practice.design_patterns.creational_patterns.abstract_factory_pattern;

public class ComputerFactory {
	public static Computer getComputer(ComputerAbstractFactory abstractFactory) {
		return abstractFactory.createComputer();
	}
}

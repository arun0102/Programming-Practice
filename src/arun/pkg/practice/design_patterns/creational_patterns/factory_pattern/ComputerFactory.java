package arun.pkg.practice.design_patterns.creational_patterns.factory_pattern;

public class ComputerFactory {
	public static Computer getComputer(String type, String RAM, String HDD, String CPU) {
		if ("PC".equals(type)) {
			return new PC(RAM, HDD, CPU);
		} else if ("Server".equals(type)) {
			return new Server(RAM, HDD, CPU);
		}
		return null;
	}
}

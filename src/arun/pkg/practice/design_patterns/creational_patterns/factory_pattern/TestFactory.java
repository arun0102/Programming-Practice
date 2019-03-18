package arun.pkg.practice.design_patterns.creational_patterns.factory_pattern;

public class TestFactory {
	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer("PC", "2GB", "500GB", "2.4 GHz");
		Computer server = ComputerFactory.getComputer("Server", "2GB", "500GB", "2.4 GHz");

		System.out.println("PC config : " + pc);
		System.out.println("Server config : " + server);
	}
}

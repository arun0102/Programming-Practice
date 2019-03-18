package arun.pkg.practice.design_patterns.creational_patterns.abstract_factory_pattern;

public class Server extends Computer {
	private String RAM;
	private String HDD;
	private String CPU;

	public Server(String RAM, String HDD, String CPU) {
		this.RAM = RAM;
		this.HDD = HDD;
		this.CPU = CPU;
	}

	@Override
	String getRAM() {
		return RAM;
	}

	@Override
	String getHDD() {
		return HDD;
	}

	@Override
	String getCPU() {
		return CPU;
	}

}

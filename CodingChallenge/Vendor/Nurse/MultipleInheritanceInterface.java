package practice.experiment;

public class MultipleInheritance implements InterfaceOne, InterfaceTwo{
	@Override
	public void print() {
		InterfaceOne.super.print();
	}
}

interface InterfaceOne{
	default void print() {
		System.out.println("InterfaceOne");
	}
}
interface InterfaceTwo{
	default void print() {
		System.out.println("InterfaceTwo");
	}
}
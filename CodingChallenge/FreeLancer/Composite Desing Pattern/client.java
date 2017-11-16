package exam.com.pinky;

public class client {

	public static void main(String[] args) {

		Component cpu = new Leaf("CPU", 100F, "this is cpu");
		Component gpu = new Leaf("GPU", 110F, "this is gpu");
		Component memory = new Leaf("Memory", 150F, "this is memory");

		Component monitor = new Leaf("Monitor", 50F, "this is monitor");
		Component keyboard = new Leaf("Keyboard", 150F, "this is keyboard");

		Component graphCard = new Composite("GraphCard");
		Component computer = new Composite("Computer");

		computer.addComponent(keyboard);
		computer.addComponent(cpu);
		computer.addComponent(memory);
		computer.addComponent(monitor);
		computer.addComponent(graphCard);

		graphCard.addComponent(gpu);
		graphCard.addComponent(memory);

		computer.showPrice();

	}

}

package exam.com.pinky;

import java.util.ArrayList;
import java.util.List;

public class Composite extends Component{

	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	List<Component> list = new ArrayList<>();
	
	public Composite(String name) {
		super();
		this.name = name;
	}
	
	@Override
	public void showPrice() {
		System.out.println("Name : " + name);
		for(Component c : list){
			c.showPrice();
		}
	}
	
	public void addComponent(Component com){
		list.add(com);
	}
	
	public void removeComponent(Component com){
		list.remove(com);
	}
}

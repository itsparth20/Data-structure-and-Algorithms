package exam.com.pinky;

public class Leaf extends Component{
	
	String name;
	Float price;
	String description;
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
	public Leaf(String name, Float price, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	@Override
	public void showPrice() {
		System.out.println("Name : " + name + ", Price : " + price + ", Description : " + description);
	}

}

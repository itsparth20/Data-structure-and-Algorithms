
public class MyStack<T> implements MyStackADT<T>{
	
	private T[] arrayStack;
	private int numItems;
	private int maximumCapacity;
	
	@SuppressWarnings("unchecked")
	public MyStack() {
		arrayStack = (T[]) new Object[10];
		numItems = -1;
		maximumCapacity = 1000;
	}
	
	@SuppressWarnings("unchecked")
	public MyStack(int initialCapacity, int maxCap) {
		arrayStack = (T[]) new Object[initialCapacity];
		numItems = -1;
		maximumCapacity = maxCap;
	}
	
	/*public static void main(String[] args) {
		System.out.println("Hello");
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public void push(T dataItem) throws OverflowException{
		//if array have size then add dataItem to array
		if(numItems+1 < arrayStack.length) {
			arrayStack[++numItems] = dataItem;
			return;
		}
		
		//If array has no more space to add element then increase the size;
		int newArraySize = arrayStack.length < 60 ? arrayStack.length * 3 : arrayStack.length + 100;
		
		//Check that does size cross the limit of the maximum size then throws error.
		if(newArraySize > maximumCapacity) {
			throw new OverflowException("stack over flow");
		}
		
		//create new array and copy each element from old to new
		T[] newStack = (T[]) new Object[newArraySize];
		System.arraycopy(arrayStack, 0, newStack, 0, numItems+1);
		
		//change the reference of the array
		arrayStack = newStack;
		
		//add element to stack increase the pointer
		arrayStack[++numItems] = dataItem; 
	}

	@Override
	public T pop() {
		if(numItems < 0)
			throw new EmptyStackException("Stack is empty");
		
		T data = arrayStack[numItems];
		arrayStack[numItems] = null;
		numItems--;
		return data;
	}

	@Override
	public T peek() {
		if(numItems < 0)
			throw new EmptyStackException("Stack is empty");
		
		return arrayStack[numItems];
	}

	@Override
	public boolean isEmpty() {
		return numItems < 0 ? true : false;
	}

	@Override
	public int size() {
		return numItems+1;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i <= numItems; i++) {
			sb.append(arrayStack[i].toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	
	
}

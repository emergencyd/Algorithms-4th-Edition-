
public class RingBuffer<Item> {
	private Item[] buffer;
	private int head = 0;
	private int tail = 0;
	private int N;
	
	public RingBuffer(int x) {
		x++; // if not "++", can only deposit "x - 1" values
		N = x; 
		buffer = (Item[]) new Object[x];
	}
	
	public boolean isEmpty() {return head == tail;}
	public boolean isFull() {return (tail + 1) % N == head;}
	
	public boolean put(Item item) {
		if (isFull()) {return false;}
		buffer[tail] = item;
		tail = (tail + 1) % N;
		//System.out.println("Tail is " + tail);
		return true;
	}
	
	public Item get() {
		if (isEmpty()) {return null;}
		Item item = buffer[head];
		head = (head + 1) % N;
		//System.out.println("Head is " + head);
		return item;
		
	}
	
	public static void main(String[] args) {
		RingBuffer<Integer> buffer = new RingBuffer<Integer>(3);
		System.out.println("Get buffer: " + buffer.get());
		System.out.println("Put buffer: " + buffer.put(0));
		System.out.println("Put buffer: " + buffer.put(1));
		System.out.println("Put buffer: " + buffer.put(2));
		System.out.println("Put buffer: " + buffer.put(3));
		System.out.println("Get buffer: " + buffer.get());
		System.out.println("Get buffer: " + buffer.get());
		System.out.println("Put buffer: " + buffer.put(0));
		System.out.println("Get buffer: " + buffer.get());
		System.out.println("Get buffer: " + buffer.get());
		System.out.println("Get buffer: " + buffer.get());
	}

}

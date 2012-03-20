package list;

public abstract class ListInt implements Iterable<Integer> {

	protected int size;

	protected ListInt() {
	}

	public abstract void add(int index, int item);

	public abstract void addFirst(int item);

	public abstract void addLast(int item);

	public abstract void clear();

	public abstract void del(int index);

	public abstract int get(int index);

	public abstract void set(int index, int item);
	
	public abstract int indexOf(int item);
	
	public abstract java.util.Iterator<Integer> getInnerIterator();

	public java.util.Iterator<Integer> iterator() {
		return new m_Iterator(this);
	}
	
	/**
	 * @param item
	 * @return
	 */
	

	public int size() {
		return size;
	}

	public void sort() {

	}

}

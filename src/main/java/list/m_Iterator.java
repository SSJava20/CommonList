package list;

import java.util.Iterator;

public class m_Iterator implements Iterator<Integer> {
	private ListInt list;
	private int i = 0;

	public m_Iterator(ListInt list) {
		this.list = list;
	}

	public boolean hasNext() {
		if (i < list.size())
			return true;
		return false;
	}

	public Integer next() {
		return list.get(i++);
		//
	}

	public void remove() {
		// To change body of implemented methods use File | Settings | File
		// Templates.
	}
}
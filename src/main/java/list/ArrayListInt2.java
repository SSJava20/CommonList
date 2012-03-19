package list;

public class ArrayListInt2 extends ListInt {
	public static final int START_SIZE = 20;
	private int[] array = new int[START_SIZE];

	private int start;
	private int end;

	public TwoIndexList() {
		start = START_SIZE / 2;
		end = START_SIZE / 2;
	}

	@Override
	public int size() {
		return end - start;
	}

	public int Search(int value) {
		int i = 0;
		while (array[i] != value) {
			i++;
		}
		return (i - start - 1);
	}

	@Override
	public void add(int index, int item) {
		if (end >= array.length) {
			expandArray();
		}
		for (int i = end - 1; i > index + start; i--)
			array[i + 1] = array[i];

		array[index + start] = item;
		end++;
	}

	@Override
	public void addFirst(int item) {
		if (start <= (0)) {
			expandArray();
		}
		array[--start] = item;
	}

	@Override
	public void addLast(int item) {
		if (end >= (array.length)) {
			expandArray();
		}
		array[end++] = item;
	}

	@Override
	public void clear() {
		array = new int[START_SIZE];
		start = START_SIZE / 2;
		end = START_SIZE / 2;
	}

	@Override
	public void del(int index) {
		int newIndex = index + start + 1;
		if (newIndex >= start && newIndex <= end) {
			if (newIndex - start <= end - newIndex) {
				int i = 0;
				for (i = newIndex; i > start; i--) {
					array[i] = array[i - 1];
				}
				start++;
			} else {
				int i = 0;
				for (i = newIndex; i < end - 1; i++) {
					array[i] = array[i + 1];
				}
				end--;
			}
		}
	}

	@Override
	public int get(int index) {
		return array[index + start];
	}

	@Override
	public void set(int index, int item) {
		if (index + start >= start && index + start < end) {
			array[index + start] = item;
		}
	}

	private void expandArray() {
		int[] newArray = new int[array.length * 2];
		int j = newArray.length / 2 - size() / 2;
		int i = start;
		start = j;
		for (; i < end; i++, j++) {
			newArray[j] = array[i];
		}
		end = j;
		array = newArray;
	}

	@Override
	public void sort() {
		for (int i = start; i < end; i++) {
			for (int j = start; j < end; j++) {
				if (array[j] > array[i]) {
					int tmp = array[i];
					array[i] = array[j];
					array[j] = tmp;
				}
			}
		}
	}

	@Override
	public int indexOf(int item) {
		for (int i = start; i < end; i++) {
			if (array[i] == item)
				return i-start;
		}
		return -1;
	}
}

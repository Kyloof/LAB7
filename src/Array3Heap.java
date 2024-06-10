import java.util.Comparator;

public class Array3Heap<T> implements IHeap<T> {

    int size;
    int lastIndex = 0;
    T[] heapMap;
    Comparator<T> comparator;

    @SuppressWarnings("unchecked")
    public void copyAndIncreaseSize() {
        int newSize = size * 2;
        T[] newTab = (T[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            newTab[i] = this.heapMap[i];
        }
        this.heapMap = newTab;
        this.size = newSize;
    }

    @SuppressWarnings("unchecked")
    public Array3Heap(int size, Comparator<T> comparator) {
        this.size = size;
        this.heapMap = (T[]) new Object[size];
        this.comparator = comparator;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        this.heapMap = (T[]) new Object[size];
        this.lastIndex = 0;
    }

    public void showHeap() {
        for (int i = 0; i < lastIndex; i++) {
            System.out.print(heapMap[i] + " ");
        }
    }

    @Override
    public void add(T element) {
        if (lastIndex >= size) {
            copyAndIncreaseSize();
        }
        int indexOfElement = lastIndex;
        heapMap[lastIndex] = element;
        lastIndex++;
        int parentPos = parent(indexOfElement);

        while (indexOfElement > 0 && comparator.compare(heapMap[indexOfElement], heapMap[parentPos]) > 0) {
            T temp = heapMap[parentPos];
            heapMap[parentPos] = heapMap[indexOfElement];
            heapMap[indexOfElement] = temp;
            indexOfElement = parentPos;
            parentPos = parent(indexOfElement);
        }
    }

    void heapify(int i) {
        int largest = i;
        int l = 3 * i + 1;
        int m = 3 * i + 2;
        int r = 3 * i + 3;

        if (l < lastIndex && comparator.compare(heapMap[l], heapMap[largest]) > 0)
            largest = l;

        if (m < lastIndex && comparator.compare(heapMap[m], heapMap[largest]) > 0)
            largest = m;

        if (r < lastIndex && comparator.compare(heapMap[r], heapMap[largest]) > 0)
            largest = r;

        if (largest != i) {
            T swap = heapMap[i];
            heapMap[i] = heapMap[largest];
            heapMap[largest] = swap;
            heapify(largest);
        }
    }

    @Override
    public T maximum() { // Fixed method name
        if (lastIndex == 0) {
            return null;
        }
        T popped = heapMap[0];
        heapMap[0] = heapMap[--lastIndex];
        heapify(0);
        return popped;
    }

    @Override
    public T minimum() {
        if (lastIndex == 0) {
            return null;
        }
        T min = heapMap[0];
        for (int i = 1; i < lastIndex; i++) {
            if (comparator.compare(min, heapMap[i]) > 0) {
                min = heapMap[i];
            }
        }
        return min;
    }

    private int parent(int pos) {
        return (pos - 1) / 3;
    }
}

import java.util.Comparator;

public class Array3Heap<T> implements IHeap<T> {

    int size;
    int lastIndex = 0;
    T[] heapMap;
    Comparator<T> comparator;


    @SuppressWarnings("unchecked")
    public void copyAndIncreaseSize(){
        int newSize = size*2;
        T[] newTab = (T[]) new Object[newSize];
        for (int i=0;i<size;i++){
            newTab[i] = this.heapMap[i];
        }
        this.heapMap = newTab;
        this.size=newSize;
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

    public void showHeap(){
        for (int i = 0; i<lastIndex; i++){
            System.out.print(heapMap[i] + " ");
        }
    }
    @Override
    public void add(T element) {
        if (lastIndex>=size){
            copyAndIncreaseSize();
        }
        int indexOfElement = lastIndex;
        int parentPos = parent(indexOfElement);

        if (lastIndex==0) {
            heapMap[lastIndex] = element;
            lastIndex++;
            return;
        }
        heapMap[lastIndex] = element;

        while(comparator.compare(heapMap[indexOfElement],heapMap[parentPos])>0) {
            if (comparator.compare(element, heapMap[parentPos]) > 0) {
                T temp = heapMap[parentPos];
                heapMap[parentPos] = element;
                heapMap[indexOfElement] = temp;
                indexOfElement=parentPos;
                parentPos = parent(indexOfElement);
            } else {
                heapMap[lastIndex] = element;
                return;
            }
        }
        lastIndex++;
    }


    void heapify(int i)
    {
        int largest = i;
        int l = 3 * i + 1;
        int m = 3 * i + 2;
        int r = 3 * i + 3;

        if (l < size && comparator.compare(heapMap[l], heapMap[largest])>0)
            largest = l;

        if (m < size && comparator.compare(heapMap[m], heapMap[largest])>0)
            largest = m;

        if (r < size && comparator.compare(heapMap[r], heapMap[largest])>0)
            largest = r;

        if (largest != i) {
            T swap = heapMap[i];
            heapMap[i] = heapMap[largest];
            heapMap[largest] = swap;

            heapify(largest);
        }
    }

    @Override
    public T maximumum() {
        if (lastIndex == 0) {
            return null;
        }
        T popped = heapMap[0];
        heapMap[0] = heapMap[--lastIndex];
        heapify(0);
        return popped;
    }

    @Override
    public T minimum(){
        T min = heapMap[lastIndex];
        for (int i = (lastIndex + 1) / 2; i < lastIndex; i++) {
            if (comparator.compare(min, heapMap[i])>0) {
                min = heapMap[i];
            }
        }
        return min;
    }


    private int parent(int pos) {
        return (pos - 1) / 3;
    }



    private void maxHeap(int pos) {
        int parentPos = parent(pos);
        T maxValue = heapMap[parentPos];
        int maxValueIndex = parentPos;
        for (int i = 3 * parentPos + 1; i <= Math.min(lastIndex - 1, 3 * parentPos + 3); i++) {
            if (comparator.compare(maxValue, heapMap[i]) < 0) {
                maxValue = heapMap[i];
                maxValueIndex = i;
            }
        }
        if (maxValueIndex != parentPos) {
            T temp = heapMap[parentPos];
            heapMap[parentPos] = maxValue;
            heapMap[maxValueIndex] = temp;
            maxHeap(maxValueIndex);
        }
    }
}

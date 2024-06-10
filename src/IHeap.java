public interface IHeap<T> {
    void clear();
    void add(T Element);
    T maximum();
    T minimum();
}

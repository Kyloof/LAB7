public class Main {
    public static void main(String[] args){
        TComparator<Integer> intComp = new TComparator<>();
        Array3Heap<Integer> heap= new Array3Heap<>(7, intComp);

        heap.add(4);
        heap.add(5);
        heap.add(3);
        heap.add(2);
        heap.add(10);
        heap.add(15);
        heap.add(17);
        heap.add(20);
        heap.add(10);
        heap.add(2);




        heap.showHeap();
        System.out.println();
        System.out.println(heap.maximumum());
        System.out.println(heap.maximumum());
        System.out.println(heap.maximumum());

        System.out.println(heap.minimum());

        heap.showHeap();

    }
}

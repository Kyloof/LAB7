public class Main {
    public static void main(String[] args){
        TComparator<Integer> intComp = new TComparator<>();
        Array3Heap<Integer> heap= new Array3Heap<>(7, intComp);


        heap.add(11);
        heap.add(13);
        heap.add(2);
        heap.add(9);
        heap.add(10);
        heap.add(20);
        heap.add(18);
        heap.add(13);
        heap.add(15);
        heap.add(11);
        heap.add(12);
        heap.add(16);
        heap.add(10);
        heap.add(9);

        heap.add(1);







        heap.showHeap();
        System.out.println();
        System.out.println(heap.maximum());
        System.out.println(heap.maximum());
        System.out.println(heap.maximum());

        System.out.println(heap.minimum());

        heap.showHeap();

    }
}

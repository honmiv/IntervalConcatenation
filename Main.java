public class Main {

    public static void main(String[] args) {
	// example
	// creating of 7 intervals
        Intervals<Integer> ints = new Intervals<>(7);
        
        ints.addInterval(1, 3);
        ints.addInterval(2, 4);
        ints.addInterval(3, 5);
        
        ints.addInterval(12, 19);
        ints.addInterval(14, 21);
        // print intervals before concatenation
        ints.print();
	// concatenation
        ints = Intervals.concatenate(ints);
	// print intervals after concatentation
        ints.print();
    }
}

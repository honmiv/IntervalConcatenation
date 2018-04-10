import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Intervals <T extends Comparable<T>> {

    private List<T> left;
    private List<T> right;

    public Intervals (int initialCapacity) {
        left = new ArrayList<>(initialCapacity);
        right = new ArrayList<>(initialCapacity);
    }

    public Intervals () {
        left = new ArrayList<>();
        right = new ArrayList<>();
    }

    public void addInterval(T a, T b) {
        if (b.compareTo(a) < 0) {
            T tmp = a;
            a = b;
            b = tmp;
        }
        left.add(a);
        right.add(b);
    }

    public void rmInterval(int ind) {
        left.remove(ind);
        right.remove(ind);
    }

    public void print() {
        System.out.println("==============");
        if (left.size() == 0)
            System.out.println("Интервалов нет");
        for (int i = 0; i < left.size(); i++) {
            System.out.println(new StringBuilder().append("[").append(left.get(i)).append(" .. ").append(right.get(i)).append("]"));
        }
        System.out.println("==============");
    }
    
    public static <T extends Comparable<T>> Intervals<T> concatenate(Intervals<T> ints) {
        if (ints.left.size() != 0) {
        	Intervals<T> newInts = new Intervals<>();
            Collections.sort(ints.left);
            Collections.sort(ints.right);
            int lc = 0;
            int rc = 0;
            int start = 0;
            int end = ints.left.size() - 1;
            while (lc != ints.left.size()) {
                if (ints.left.get(lc).compareTo(ints.right.get(rc)) <= 0)
                    lc++;
                else {
                    rc++;
                    if (lc == rc) {
                        newInts.left.add(ints.left.get(start));
                        newInts.right.add(ints.right.get(rc - 1));
                        start = lc;
                    }
                }
            }
            newInts.left.add(ints.left.get(start));
            newInts.right.add(ints.right.get(end));
            return newInts;
        }
        return null;
    }
}

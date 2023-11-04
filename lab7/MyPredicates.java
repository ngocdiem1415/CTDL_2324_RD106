package lab7;

import java.util.*;

public class MyPredicates{

    // remove gia tri khi p.test : true
    public static <T> void remove(Collection<T> coll, Predicate<T> p){
        Iterator<T> iter = coll.iterator();
        while ( iter.hasNext()){
            T next = iter.next();
            if ( p.test(next)){
                iter.remove();
            }
        }
    }

    // remove gia tri khi p.test : false
    public static <T> void retain (Collection<T> coll, Predicate<T> p){
        Iterator<T> iter = coll.iterator();
        while ( iter.hasNext()){
            T next = iter.next();
            if ( ! p.test(next)){
                iter.remove();
            }
        }
    }

    public static <T> Set<T> collect (Collection<T> coll, Predicate<T> p){
        Set<T> result = new HashSet<>();
        Iterator<T> iter = coll.iterator();
        while ( iter.hasNext()){
            T next = iter.next();
            if ( p.test(next)){
                result.add(next);
            }
        }
        return result;
    }

    public static <T> int find ( Collection<T> coll, Predicate<T> p){
        Iterator<T> iter = coll.iterator();
        int count = -1;
        while ( iter.hasNext()){
            count++;
            T next = iter.next();
            if (p.test(next)) {
                return count;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(8);

        Even p = new Even();
        System.out.println(MyPredicates.find(list, p));
//        System.out.println(list);
    }
}

package lab7;

import java.util.*;

public class MyPredicates{

    public static <T> void remove(Collection<T> coll, Predicate<T> p){
        Iterator<T> iter = coll.iterator();
        while ( iter.hasNext()){
            T next = iter.next();
            if ( p.test(next)){
                iter.remove();
            }
        }
    }

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
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(3);

        Even p = new Even();
        MyPredicates.retain(list, p);
        System.out.println(list);
    }
}

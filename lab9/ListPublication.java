package lab9;

import java.util.*;

public class ListPublication {
    private List<Publication> list;

    public ListPublication() {
        this.list = new ArrayList<>();
    }

    public void add(List<Publication> listBook) {
        this.list.addAll(listBook);
    }

    public double totalCost() {
        int total = 0;
        for (Publication temp : list) {
            total += temp.getCost();
        }
        return total;
    }

    public ReferenceBook theMostChaper() {
        ArrayList<ReferenceBook> listRefernceBook = new ArrayList<>();
        ReferenceBook result = null;
        for (Publication temp : list) {
            if (temp.isType().equalsIgnoreCase("ReferenceBook")) {
                listRefernceBook.add((ReferenceBook) temp);
            }
        }
        result = listRefernceBook.get(0);
        for (int i = 1; i < listRefernceBook.size(); i++) {
            if (result.isSizeChaper() < listRefernceBook.get(i).isSizeChaper()) {
                result = listRefernceBook.get(i++);
            }
        }
        return result;
    }

    public boolean sameTitle(String str) {
        for (Publication temp : list) {
            if (temp.isType().equalsIgnoreCase("Focus") && temp.getTitle().equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public List<Focus> samePublishYear(int publishYear) {
        List<Focus> listRefernceBook = new ArrayList<>();
        for (Publication temp : list) {
            if (temp.isType().equalsIgnoreCase("Focus") && temp.getPublishYear() == publishYear) {
                listRefernceBook.add((Focus) temp);
            }
        }
        return listRefernceBook;
    }

    public void sortList() {
        Set<Publication> listSort = new TreeSet<>(new Comparator<Publication>() {
            @Override
            public int compare(Publication o1, Publication o2) {
                int sortTitle = o1.getTitle().compareTo(o2.getTitle());
                if (sortTitle == 0) {
                    return -(Double.compare(o1.getPublishYear(), o2.getPublishYear()));
                } else {
                    return sortTitle;
                }
            }
        });
        listSort.addAll(list);
        System.out.println(listSort.toString());
    }


    public Map<Integer, Integer> thongKeTheoNam (){
        int value =1;
        Map<Integer,Integer> result = new HashMap<>();
        for (Publication temp: list ) {
            int publishYear = temp.getPublishYear();
            if ( !result.containsKey(publishYear)){
                result.put(publishYear, value);
            }else{
                result.put(publishYear, value +1);
            }
        }
        return result;
    }
    @Override
    public String toString() {
        return "ListPublication{" + " " + list.toString();
    }

    public static void main(String[] args) {
        Chapter c1 = new Chapter("A", 100);
        Chapter c2 = new Chapter("D", 110);
        Chapter c3 = new Chapter("H", 230);
        Chapter c4 = new Chapter("D", 130);
        List<Chapter> list1 = new ArrayList<>();
        list1.add(c1);
        List<Chapter> list2 = new ArrayList<>();
        list2.add(c1);
        list2.add(c2);
        list2.add(c3);
        List<Chapter> list3 = new ArrayList<>();
        list3.add(c4);
        list3.add(c2);
        List<Chapter> list4 = new ArrayList<>();
        list4.add(c2);
        list4.add(c3);
        Publication tapChi1 = new Focus("Tap Chi Giao Duc", 50, 2021, "Le Thi B", 50000, "Giao Duc");
        Publication tapChi2 = new Focus("Tap Chi TS", 70, 2020, "Le Thi C", 530000, "TS");
        Publication tapChi3 = new Focus("Tap Chi CT", 30, 2025, "Le Thi D", 23000, "CT");
        Publication tapChi4 = new Focus("Tap Chi CT", 25, 2021, "Le Thi B", 10000, "KH");
        Publication sach1 = new ReferenceBook("Sach Y Hoc", 300, 2020, "Nguyen Van A", 150000, "Y Hoc", list1);
        Publication sach2 = new ReferenceBook("Sach Y Hoc2", 20, 2010, "Nguyen Van B", 750000, "Y Hoc2", list3);
        Publication sach3 = new ReferenceBook("Sach Y Hoc3", 60, 2011, "Nguyen Van H", 35000, "Y Hoc3", list4);
        Publication sach4 = new ReferenceBook("Sach Y Hoc4", 240, 2023, "Nguyen Van K", 74000, "Y Hoc4", list2);
        List<Publication> listPublication = new ArrayList<>();
        listPublication.add(tapChi1);
        listPublication.add(tapChi2);
        listPublication.add(tapChi3);
        listPublication.add(tapChi4);
        listPublication.add(sach1);
        listPublication.add(sach2);
        listPublication.add(sach3);
        listPublication.add(sach4);

        ListPublication test = new ListPublication();
        test.add(listPublication);
//        System.out.println(test);
//        System.out.println(tapChi1.isType());
//        System.out.println(sach3.isType());

//        System.out.println(tapChi2.isFocusAnd10PublishYear());
//        System.out.println(tapChi4.isFocusAnd10PublishYear());
//        System.out.println(sach2 .isFocusAnd10PublishYear());

//        System.out.println(tapChi1.sameAuthorAndSameType(tapChi4));
//        System.out.println(tapChi1.sameAuthorAndSameType(tapChi2));
//        System.out.println(tapChi1.sameAuthorAndSameType(sach1));
//        System.out.println(tapChi1.sameAuthorAndSameType(sach2));

//        System.out.println(test.totalCost());

//        System.out.println(sach1.isSizeChaper());
//        System.out.println(sach2.isSizeChaper());
//        System.out.println(sach3.isSizeChaper());
//        System.out.println(sach4.isSizeChaper());
//        System.out.println(test.theMostChaper());

//        System.out.println(test.sameTitle("Tap Chi TS"));
//        System.out.println(test.sameTitle("Tap Chi S"));

//        System.out.println(test.samePublishYear(2021));
//        System.out.println(test.samePublishYear(2020));

//        test.sortList();

        System.out.println(test.thongKeTheoNam());
    }

}

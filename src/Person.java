import org.junit.Test;

import java.util.ArrayList;

public class Person {

    String name;
    ArrayList<String> pnArray;
    private static final int MIDDLE_IDX = 2;

    public Person(String name, ArrayList<String> pnArray){
        this.name = name;
        this.pnArray = new ArrayList<>();
        this.pnArray.addAll(pnArray);
    }

    public String getName(){
        return this.name;
    }

    public boolean addPhoneNumber(String pn){
        if(!this.pnArray.contains(pn)){
            this.pnArray.add(pn);
            return true;
        }
        else{
            return false;
        }
    }

    public ArrayList<String> getPhoneNumbers(){
        MergeSort(this.pnArray,0,pnArray.size()-1);
        return this.pnArray;
    }
    private void MergeSort(ArrayList<String> list, int start, int end) {

        if (start < end)
        {
            int mid = start + (end - start) / MIDDLE_IDX;
            MergeSort(list, start, mid);
            MergeSort(list , mid + 1, end);

            merge(list, start, mid, end);
        }
    }

    private void merge(ArrayList<String> arr, int l, int m, int r) {

        int mergedSize = r - l + 1;

        ArrayList<String> mergedNums = new ArrayList<>();
        int left = l, right = m + 1;
        while (left <= m && right <= r) {
            if (arr.get(left).compareTo(arr.get(right)) <= 0) {
                mergedNums.add(arr.get(left));
                left++;
            }
            else {
                mergedNums.add(arr.get(right));
                right++;
            }
        }

        while (left <= m) {
            mergedNums.add(arr.get(left));
            left++;
        }
        while (right <= r) {
            mergedNums.add(arr.get(right));
            right++;
        }
        for (int i = 0; i < mergedSize; i++) {
            arr.set(l + i, mergedNums.get(i));
        }
    }

    public boolean deletePhoneNumber(String pn){
        if(this.pnArray.size() <= 2){
            throw new IllegalArgumentException();
        }
        if(this.pnArray.contains(pn)){
            pnArray.remove(pn);
            return true;
        }
        else{
            return false;
        }
    }

    public static void main(String[] args) {

        ContactList testList = new ContactList();
        ArrayList<String> sean_Num = new ArrayList<String>();
        sean_Num.add("123");
        sean_Num.add("1223");
        sean_Num.add("12344");
        Person Sean = new Person("Sean", sean_Num);
        //System.out.println(testList.createContact(Sean));
        System.out.println(Sean.deletePhoneNumber("12"));

    }
}


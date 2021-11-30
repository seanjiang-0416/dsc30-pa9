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
        if(this.pnArray.size() <= 1){
            throw new IllegalArgumentException();
        }
        return this.pnArray.remove(pn);
    }
}


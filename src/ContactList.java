import java.util.ArrayList;
import java.util.*;

public class ContactList {

    Hashtable<String,Person> contactList;
    private static final int MIDDLE_IDX = 2;

    public ContactList(){
        contactList = new Hashtable<>();
    }

    public boolean createContact(Person person){
        if(contactList.containsKey(person.getName())){
            return false;
        }else {
            contactList.put(person.getName(), person);
            return true;
        }
    }

    public boolean lookupContact(String name){
        if(contactList.containsKey(name)){
            return true;
        }
        else{
            return false;
        }
    }

    public Person getContact(String name){
        return contactList.get(name);
    }

    public Person[] getContactByRange(String start, String end){
        ArrayList<Person> temp = new ArrayList<Person>();
        if(start.compareTo(end) >= 0){
            throw new IllegalArgumentException();
        }
        Set<String> setOfKeys = this.contactList.keySet();

        for (String key : setOfKeys) {
            if (key.compareTo(start) >= 0 && key.compareTo(end) < 0) {
                temp.add(this.contactList.get(key));
            }
        }
        Person[] output = new Person[temp.size()];
        return temp.toArray(output);
    }

    public boolean deleteContact(String name){
        return this.contactList.remove(name) != null;
    }

    public int size(){
        return contactList.size();
    }

    public String[] fetchAllNames(){

        ArrayList<String> names =
                new ArrayList<String>(this.contactList.keySet());
        //MergeSort(names,0,this.contactList.size()-1);
        Collections.sort(names);
        String [] output = new String[names.size()];
        return names.toArray(output);
    }

    public String[] fetchAllPhoneNumbers(){
        HashSet<String> phoneNumbers = new HashSet<>();
        ArrayList<String> names =
                new ArrayList<String>(this.contactList.keySet());
        for (String name: names){
            phoneNumbers.addAll(this.contactList.get(name).getPhoneNumbers());
        }
        ArrayList<String> pbList = new ArrayList<String>(phoneNumbers);
        //MergeSort(pbList,0,pbList.size()-1);
        Collections.sort(pbList);
        String[] output = new String[pbList.size()];
        pbList.toArray(output);
        return output;
    }
    /*
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

     */

}

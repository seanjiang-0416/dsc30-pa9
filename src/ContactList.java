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
        QuickSort(pbList,0,pbList.size()-1);
        String[] output = new String[pbList.size()];
        pbList.toArray(output);
        return output;
    }

    /**
     * This method performs quick sort on the input arraylist
     *
     * @param list The arraylist we want to sort
     * @param start The inital index on subsection of Arraylist
     *              we want to sort
     * @param end The final index of the subsection of Arraylist we
     *            want to sort
     */
    public void QuickSort(ArrayList<String> list, int start, int end) {
        // TODO
        //make sure start is lower than end
        if(start < end) {
            int lowIndex = partition(list, start, end);
            //make two recursions to separate the list
            QuickSort(list, start, lowIndex);
            QuickSort(list, lowIndex + 1, end);
        }
    }
    /**
     * partition helper function for QuickSort
     *
     * @param arr The arraylist we want to sort
     * @param l left-most index we want to merge
     * @param h right-most index we want to merge
     */
    private int partition(ArrayList<String> arr, int l, int h) {
        // TODO
        int mid = l + (h-l)/2;
        String pivot = arr.get(mid);
        boolean finished = false;
        while(!finished){

            while(arr.get(l).compareTo(pivot) < 0){
                l += 1;
            }

            while(arr.get(h).compareTo(pivot) > 0){
                h -= 1;
            }
            if(l >= h){
                finished = true;
            }
            if(l < h){
                String temp = arr.get(l);
                arr.set(l,arr.get(h));
                arr.set(h,temp);
                l+=1;
                h-=1;
            }
        }
        return h;
    }

}

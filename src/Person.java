import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

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
        //MergeSort(this.pnArray,0,pnArray.size()-1);
        Collections.sort(this.pnArray);
        return this.pnArray;
    }

    public boolean deletePhoneNumber(String pn){
        if(this.pnArray.contains(pn)){
            if(this.pnArray.size() <= 1){
                throw new IllegalArgumentException();
            }
            this.pnArray.remove(pn);
            return true;
        }
        else{
            return false;
        }
    }


}


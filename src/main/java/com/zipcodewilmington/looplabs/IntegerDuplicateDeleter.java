package com.zipcodewilmington.looplabs;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Created by leon on 1/29/18.
 * @ATTENTION_TO_STUDENTS You are forbidden from modifying the signature of this class.
 */
public final class IntegerDuplicateDeleter extends DuplicateDeleter<Integer> {

    public IntegerDuplicateDeleter(Integer[] intArray) {
        super(intArray);
    }

    @Override
    public Integer[] removeDuplicates(int maxNumberOfDuplications) {


        return new Integer[0];
    }

    @Override
    public Integer[] removeDuplicatesExactly(int exactNumberOfDuplications) {
        int lastNumber = -1;
        Integer[] response = new Integer[0];
        for(int x=0; x < array.length; x++){
            if(lastNumber != array[x]){
                lastNumber = array[x];
                Integer[] temp = getSubArrayOfDuplicates(array[x]);
                if(temp.length != exactNumberOfDuplications) {
                    response = ArrayUtils.addAll(response, temp);
                }
            }
        }
        return response;
    }

    private Integer[] getSubArrayOfDuplicates(Integer input){
        Integer[] response = new Integer[0];
        Integer counter =0;
        for(int x=0; x < array.length; x++){
            if(array[x] == input){
                counter ++;
                Integer[] temp = new Integer[counter];
                System.arraycopy(response,0,temp,0,response.length);
                temp[temp.length-1] = array[x];
                response = temp;
            }
        }
        return response;
    }
}

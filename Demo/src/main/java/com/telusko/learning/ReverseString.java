package com.telusko.learning;

public class ReverseString {
    String reverseString(String str){
        char[] charArray=str.toCharArray();
        int n=str.length();
        for(int i=0; i<=(n/2); i++)
        {
            char temp=charArray[i];
            charArray[i]=charArray[n-i-1];
            charArray[n-i-1]=temp;
        }
        return new String(charArray);
    }
}

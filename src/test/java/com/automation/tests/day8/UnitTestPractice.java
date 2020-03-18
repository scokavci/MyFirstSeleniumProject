package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
        //unit test
        //to check if our method works properly
        //if assertion fails, that means our method doesn't work correctly
        //that means we have fix the method
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        //Assertion
        verifyEquals(expected,actual);

    }
    // outside the main method inside the class
    //annotation
    @Test (description = "Verify if method can reverse a string")
    public void test(){
        String expected = "elppa";
        String actual = reverseString("apple");
        // it coming from testNG , JUnit also has this assert class
        // you can compare any data types here: strings, primitives, arrays, objects
        //to verify if expected result equals to actual
        // assert class then method
        Assert.assertEquals(actual,expected);
    }
    @Test(description = "Verify if method can reverse a string")
    public void test2(){
        String expected ="rac";
        String actual = reverseString("car");
        Assert.assertEquals(actual,expected);
    }
    public static boolean verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("Test Passed");
            return true;
        }else{
            System.out.println("Test failed!!!");
            System.out.println("Expected: "+ expected);
            System.out.println("Actual: "+ actual);
            return false;
        }
    }

    /**
     * This method stands for reversing strings
     * @param str
     * @return reversed String
     */

      public static String reverseString(String str){
          String reversed ="";
          for (int i = str.length()-1; i >=0 ; i--) {
              reversed += str.charAt(i);
          }
          return reversed;
      }
}

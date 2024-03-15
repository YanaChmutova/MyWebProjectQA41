package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {
    public static void main(String[] args) {
        Assert.assertEquals(myCalc(5,5), 10);
    }
    public static int myCalc(int a, int b){
        return a+b;
    }
    public static boolean myValue(){
    return true;
    }
    @Test
    public void testCalc(){
        Assert.assertEquals(myCalc(5,5), 10);
    }

    @Test
    public void test2(){
        Assert.assertTrue(myValue());
    }

    @Test
    public void testDevideByZero(){
        Assert.assertThrows(ArithmeticException.class, ()->myTest());
    }
//    @Test
//    public void testDevideByZero(){
//        Assert.assertThrows(ArithmeticException.class, new Runnable(){
//            @Override
//            public void run(){myTest();}
//        });
//    }
    @Test
    public static int myTest(){
        return 10/0;
    }

    @Test
    public void failTest(){
    int actualResult = someFunction();
    int expectedResult = 10;
    Assert.assertEquals(actualResult,expectedResult, "my comment");

    Assert.fail("The test is fail...");
    }

    public static int someFunction() {
        return 5;
    }
}

package ru.muctr.ForTestedMethods;

/**
 * @author Evgenia Skichko
 */
public class VerySimpleMethods {

    public int sum(int a, int b){
        return a + b;
    }


    public double sumDouble(double a, double b){
        return a + b;
    }


    public boolean sumArrayMoreThan10(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        if (sum > 10) return true;
        return false;
    }

    public int sumArray(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum+= arr[i];
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return sum;
    }


    public String getSomeString(){
        return "New String";
    }
}

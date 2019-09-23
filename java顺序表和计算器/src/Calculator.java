public class Calculator {
    private int num1;
    private int num2;
    private String name;

    public int ADD(int n1,int n2){
        return n1+n2;
    }

    public int decrease(int n1,int n2){
        return n1-n2;
    }

    public int multiply(int n1,int n2){
        return n1*n2;
    }

    public int divide(int n1,int n2){
        return n1/n2;
    }

    public Calculator(String name,int n1,int n2){
        this.name=name;
        num1=n1;
        num2=n2;
    }

    public Calculator(String name){
        this.name=name;
    }

    public void reviseNum1(int n1){
        num1=n1;
    }

    public int getNum1(){
        return num1;
    }

    public void reviseNum2(int n2){
        num2=n2;
    }

    public int getNum2() {
        return num2;
    }

    public void change(int[] arr){
        int tmp=arr[0];
        arr[0]=arr[1];
        arr[1]=tmp;
    }

}

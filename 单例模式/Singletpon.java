public class Singletpon {
    private static int sing =0;
    Singletpon single=null;
    public Singletpon(){
        sing=100;
    }
    public void run(){
        System.out.println(sing);
    }

    public Singletpon getsingle(){
        if(single==null){
            synchronized (Singletpon.class){
                if(single==null){
                    single = new Singletpon();
                }
            }
        }
        return single;
    }
}






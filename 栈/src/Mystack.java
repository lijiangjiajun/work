public class Mystack {
    private int[] arr = new int[100];
    private int size = 0;
    public void push(int val){
        if(size == arr.length){
            System.out.println("不好意思，栈满了");
            return;
        }
        else{
            arr[size]=val;
            size++;
        }
    }

    public Integer pop(){
        if(size==0){
            return null;
        }
        else{
        int ret = arr[size-1];
        size--;
        return ret;
        }
    }

    public Integer peek(){
        if(size==0){
            return null;
        }
        else{
            return arr[size-1];
        }
    }

    public boolean isempty(){
        return size==0;
    }

    public int size(){
        return size;
    }

    public void show(){
        for(int i=0;i<size;i++){
            System.out.println(arr[i]);
        }
    }
}

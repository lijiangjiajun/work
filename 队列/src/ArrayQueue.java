public class ArrayQueue {
    public int[] arr = new int[100];
    public int size=0;
    int head=0;
    int Tail=0;

    public void offer(int val){
        if(size==arr.length){
            System.out.println("不好意思，队列满了");
            return;
        }
        arr[Tail]=val;
        Tail++;
        size++;
    }

    public Integer poll(){
        if(size==0){
            System.out.println("不好意思，这是空队列");
            return null;
        }
        else{
          int ret = arr[head];
          head++;
          size--;
          return ret;
        }
    }

    public Integer peek(){
        if(size==0){
            System.out.println("不好意思，这是空队列");
            return null;
        }
        else{
            int ret = arr[head];
            return ret;
        }
    }


    public void show(){
        int node = head;
        for(;node<Tail;node++){
            System.out.println(arr[node]);
        }
    }

}

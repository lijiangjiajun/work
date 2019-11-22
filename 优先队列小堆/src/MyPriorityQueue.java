public class MyPriorityQueue {  //小堆
    private int[] arr = new int[100];
    public int size=0;
    public void offer(int val){
        if(size>=arr.length){
            return;
        }
        arr[size]=val;
        size++;
        shiftUp(arr,size-1);
    }
    public void shiftUp(int[] arr,int index){
        if(index>=arr.length){
            return ;
        }
        int child=index;
        int parent = (index-1)/2;
        while(child>0){
            if(arr[child]<arr[parent]){
                int tmp = arr[child];
                arr[child]=arr[parent];
                arr[parent]=tmp;
            }
            else{
                break;
            }
            child=parent;
            parent=(child-1)/2;
        }
    }

    public void shiftDown(int[] arr ,int size,int index){
        if(index>=size){
            return;
        }
        int parent=index;
        int child = parent*2+1;
        while(child<size){
            if(arr[child+1]<arr[child]){
                child++;
            }
            if(arr[child]<arr[parent]){
                int tmp = arr[child];
                arr[child]=arr[parent];
                arr[parent]=tmp;
            }
            else{
                break;
            }
            parent=child;
            child=parent*2+1;
        }

    }

    public int poll(){
        int ret = arr[0];
        arr[0]=arr[size-1];
        size--;
        shiftDown(arr,size,0);
        return ret;
    }

    public Integer peek(){
        if(size<0){
            return null;
        }
        int ret = arr[0];
        return ret;
    }
}

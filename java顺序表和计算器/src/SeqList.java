public class SeqList {
        private int[] arr = new int[10];
        private int size=0 ;//实际元素个数
        public void display(){
            for(int i=0;i<size;i++){
                System.out.println(arr[i]);
            }
        }

        public void add(int pos,int num){
            if(size==arr.length){
                realloc();
            }


                for(int i=size;i>pos;i--){
                    arr[i]=arr[i-1];
                }
                size++;
                arr[pos]=num;

        }

        public void realloc(){
            int[] arr2 = new int[(arr.length)*2];
            for(int i=0;i<size;i++){
                arr2[i]=arr[i];
            }
            arr=arr2;
            System.out.println("扩容成功");
        }

        public boolean contain(int toFind){
            for(int i=0;i<size;i++){
                if(arr[i]==toFind){
                    return true;
                }
            }
            return false;
        }

        public int search(int toFind){
            for(int i=0;i<size;i++){
                if(arr[i]==toFind){
                    return i;
                }
            }
            return-1;
        }

        public void setPos(int num,int pos){
            arr[pos]=num;
        }

        public int getPos(int pos){
            if(pos<=size) {
                return arr[pos];
            }
            else{
                return -1;
            }
        }

        public void remove(int toRemove){
            int ret = search(toRemove);
            if(ret!=-1) {
               for (int i = ret; i < size; i++) {
                       arr[i] = arr[i + 1];
                   }
               size--;
               }
            if(ret==-1){
                System.out.println("该数字不存在");
            }

        }

        public int size(){
            return size;
        }

        public void clear(){
            size=0;
        }


    }



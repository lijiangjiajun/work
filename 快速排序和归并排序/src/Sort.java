import java.util.Stack;

public class Sort {
    public void quickSort(int[] arr){
        Help(arr,0,arr.length-1);
    }

    public void Help(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int index = patition(arr,left,right);
        Help(arr,left,index-1);
        Help(arr,index+1,right);
    }

    public int patition(int[] arr,int left,int right){
        int tmp = right;
        while(left<right){
            while(left<right && arr[left]<arr[tmp]){
                left++;
            }
            while(left<right && arr[right]>arr[tmp]){
                right--;
            }
            int t =arr[left];
            arr[left]=arr[right];
            arr[right]=t;
        }
        if(left>=right) {
            int t = arr[left];
            arr[left] = arr[tmp];
            arr[tmp] = t;
        }
        return left;
    }

    public void QuickSortLoop(int[] arr){
        Stack<Integer> stack = new Stack<>();
        stack.push(arr.length-1);
        stack.push(0);
        while(!stack.isEmpty()){
            int left =stack.pop();
            int right= stack.pop();
            if(left>=right){
                continue;
            }
            int index = patition(arr,left,right);
            stack.push(index-1);
            stack.push(left);
            stack.push(right);
            stack.push(index+1);
        }
    }

    public void mergeSort(int[] arr){
        Help2(arr,0,arr.length-1);
    }

    public void Help2(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int mid = left+(right-left)/2;
        Help2(arr,left,mid);
        Help2(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    public void merge(int[] arr, int left,int mid,int right){
        if(left>=right){
            return;
        }
        int[] ret = new int[right-left+1];
        int bound=0;
        int i=left;
        int j= mid+1;
        while(i<=mid && j<=right){
            if(i<=mid && arr[i]<arr[j]){
                ret[bound]=arr[i];
                bound++;
                i++;
            }
            else{
                ret[bound] =arr[j];
                j++;
                bound++;
            }
        }
        while(i<=mid){
            ret[bound]=arr[i];
            i++;
            bound++;
        }
        while(j<=right){
            ret[bound]=arr[j];
            j++;
            bound++;
        }

        for(int k =0;k<ret.length;k++){
            arr[left+k]=ret[k];
        }
    }

    public void mergeLoop(int[] arr){
        for(int gap=1;gap<arr.length;gap=gap*2){
            for(int i=0;i<arr.length;i=i+gap*2){
                int start = i;
                int end =i+gap*2-1;
                int mid=(start+end)/2;
                if(end>arr.length-1){
                    end=arr.length-1;
                }
                if(mid>arr.length-1){
                    mid = arr.length-1;
                }
                merge(arr,start,mid,end);
            }
        }
    }
}


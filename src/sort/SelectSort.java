package sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int [] arr = {5,3,6,2,10};
        new SelectSort().selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 选择排序,每次找到最小的
     * @param arr
     */
    public void selectionSort(int []arr){
        for(int i = 0;i<arr.length;++i){
            for(int j = i;j<arr.length;++j){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

    }


}

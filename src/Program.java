import java.util.Arrays;

public class Program {
    public static void main(String[] args) {
        int[] arr1 = getIntArr(10); // с перегрузкой, можно изменить диапазон
        System.out.println(Arrays.toString(arr1));
        heapSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void heapSort(int[] arr){
        for (int i = arr.length / 2 - 1; i >=0 ; i--) {
            heapify(arr, i, arr.length);
        }
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }
    public static void heapify(int[] arr, int root, int len){
        int largest = root;
        int left = 2 * root + 1;
        int right = 2 * root + 2;

        if (left < len && arr[left] > arr[largest]) largest = left;
        if (right < len && arr[right] > arr[largest]) largest = right;

        if (largest != root){
            swap(arr, root, largest);
            heapify(arr, largest, len);
        }
    }
    public static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }


    public static int[] getIntArr(int length){
        return getIntArr(length, 0, 10);
    }
    public static int[] getIntArr(int length, int min, int max){
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = ((int)(Math.random() * (max - min)) + min);
        }
        return array;
    }







}

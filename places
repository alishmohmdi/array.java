import java.util.Scanner;

public class inversion {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        int[] array = new int[n];
        
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        
        scanner.close();
        
        long inversionCount = countInversions(array, 0, n - 1);
        
        System.out.println(inversionCount);
    }
    
    private static long countInversions(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }
        
        int mid = (left + right) / 2;
        long inversions = 0;
        
        inversions += countInversions(array, left, mid);
        
        inversions += countInversions(array, mid + 1, right);
        
        inversions += mergeAndCount(array, left, mid, right);
        
        return inversions;
    }
    
    private static long mergeAndCount(int[] array, int left, int mid, int right) {
        int[] leftArray = new int[mid - left + 1];
        int[] rightArray = new int[right - mid];
        
        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = array[mid + 1 + i];
        }
        
        int i = 0, j = 0, k = left;
        long inversions = 0;
        
        while (i < leftArray.length && j < rightArray.length) {
            if (leftArray[i] <= rightArray[j]) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
                inversions += (leftArray.length - i);
            }
        }
        
        while (i < leftArray.length) {
            array[k++] = leftArray[i++];
        }
        while (j < rightArray.length) {
            array[k++] = rightArray[j++];
        }
        
        return inversions;
    }
}

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // nhập mảng
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }

        // tính tổng
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        // tính trung bình
        double avg = (double) sum / n;

        // sắp xếp mảng
        Arrays.sort(arr);

        // hiển thị kết quả
        System.out.println("Sorted array: " + Arrays.toString(arr));
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);
    }
}
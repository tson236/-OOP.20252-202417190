import java.util.Arrays;
import java.util.Scanner;
public class Sum 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("So phan tu: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) 
            {
            System.out.print("Nhap so " + (i + 1) + ": ");
            arr[i]=sc.nextInt();
        }
        int sum = 0;
        for (int i=0;i<n;i++) 
        {
            sum+=arr[i];
        }
        double avg=(double)sum/n;
        Arrays.sort(arr);
        System.out.println("Mang da sap xep: " + Arrays.toString(arr));
        System.out.println("Tong = " + sum);
        System.out.println("TB5 = " + avg);
    }
}
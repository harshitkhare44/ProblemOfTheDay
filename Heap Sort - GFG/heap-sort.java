//{ Driver Code Starts
import java.util.*;
class Heap_Sort
{
    void printArray(int arr[],int n)
    {
        //int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void main(String args[])
    {
        Scanner sc  = new Scanner(System.in);
        Heap_Sort hs = new Heap_Sort();
        int arr[] = new int[1000000];
        int T = sc.nextInt();
        while(T>0)
        {
            int n = sc.nextInt();
            for(int i=0;i<n;i++)
                arr[i] = sc.nextInt();
                
            Solution ob=new Solution();
            ob.heapSort(arr,n);
            hs.printArray(arr,n);
            T--;
        }
    }
    
}



// } Driver Code Ends


class Solution
{
    //Function to build a Heap from array.

    
    // Function to maintain the heap property.
    void heapify(int arr[], int n, int i) {
        int largest = i;      // Initialize largest as the root
        int leftChild = 2 * i + 1;  // Left child index
        int rightChild = 2 * i + 2; // Right child index

        // If the left child is larger than the root
        if (leftChild < n && arr[leftChild] > arr[largest])
            largest = leftChild;

        // If the right child is larger than the current largest
        if (rightChild < n && arr[rightChild] > arr[largest])
            largest = rightChild;

        // If the largest is not the root
        if (largest != i) {
            // Swap the largest element with the root
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest);
        }
    }

    // Function to build a max-heap from the array.
    void buildHeap(int arr[], int n) {
        // Start from the last non-leaf node and heapify each node in reverse order.
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
    }

    // Function to perform Heap Sort.
    public void heapSort(int arr[], int n) {
        // Build the max-heap from the array
        buildHeap(arr, n);

        // Extract elements one by one from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (maximum) to the end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap (excluding the sorted elements)
            heapify(arr, i, 0);
        }
    }


}
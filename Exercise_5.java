import java.util.Stack;

class IterativeQuickSort { 
    void swap(int arr[], int i, int j) 
    { 
        if(i!=j) {
            arr[i] = arr[i] + arr[j];
            arr[j] = arr[i] - arr[j];
            arr[i] = arr[i] - arr[j];
          }
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
    	int pivot = h;
    	
    	int i = l -1;
    	
    	for(int j = l; j<=h-1; j++) {
    		if(arr[j] <= arr[pivot]) {
    			i += 1;
    			swap(arr, i, j);   			
    		}
    	}
    	swap(arr, i+1, h);
    	return i+1;
    } 
  
    // Sorts arr[l..h] using iterative QuickSort 
    void QuickSort(int arr[], int l, int h) 
    { 
        Stack<Integer> s = new Stack<>();
        s.push(l);
        s.push(h);

        while(!s.isEmpty()){
          h = s.pop();
          l= s.pop();

          int p = partition(arr, l , h);

          if(p -1 > l){
            s.push(l);
            s.push(p-1);
          }

          if(p +1 < h){
            s.push(p+1);
            s.push(h);
          }
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
    public static void main(String args[]) 
    { 
        IterativeQuickSort ob = new IterativeQuickSort(); 
        int arr[] = { 4, 3, 5, 2, 1, 3, 2, 3 }; 
        ob.QuickSort(arr, 0, arr.length - 1); 
        ob.printArr(arr, arr.length); 
    } 
} 
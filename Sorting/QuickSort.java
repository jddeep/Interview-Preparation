/*
Divide and Conquer Algo. TC-O(nlogn)
Understand algo from here - https://www.geeksforgeeks.org/quick-sort/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
static int partition(int[] arr, int low, int high){

int i = low-1;
int pivot = arr[high];

for(int j = low; j<=high-1;j++){

if(arr[j]<=pivot){

i++;
int temp = arr[i];
arr[i] = arr[j];
arr[j] = temp;
}
}
int temp = arr[i+1];
arr[i+1] = arr[high];
arr[high] = temp;
return i+1;
}

static void quicksort(int[] arr, int low, int high){

if(low < high){

int pi = partition(arr, low, high);

quicksort(arr, low, pi-1);
quicksort(arr, pi+1, high);
}

}

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int arr[] = new int[]{4,1,2,3,0,5,9,6,7,8,11,10};
		quicksort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}

/* Divide and Conquer Algo. Keep on dividing array untill single seperated elements and then start joining them up.
TC - O(nlogn)
Understand more about algo here - https://www.geeksforgeeks.org/merge-sort/
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    
static void merge(int[] arr, int low, int mid, int high){

int n1= mid-low+1;
int n2 = high-mid;

int[] L = new int[n1];
int[] R = new int[n2];

for(int i = 0;i<n1;i++) L[i] = arr[low+i];

for(int i = 0;i<n2;i++) R[i] = arr[mid+i+1];

int k = low; int leftIndex = 0, rightIndex = 0;

while(leftIndex <n1 && rightIndex <n2){

if(L[leftIndex]  <= R[rightIndex]){
arr[k] = L[leftIndex];
leftIndex++;
}else{
arr[k] = R[rightIndex];
rightIndex++;

}
k++;

}

while(leftIndex<n1 && k<arr.length){
arr[k++] = L[leftIndex++];
}
while(rightIndex<n2 && k<arr.length){
arr[k++] = R[rightIndex++];
}

}

static void mergeSort(int[] arr, int low, int high){

if(low < high){
int mid = low + (high-low)/2;

mergeSort(arr, low, mid); 
mergeSort(arr, mid+1, high);

merge(arr, low, mid, high);

}

}

	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int[] arr = new int[]{4,8,1,2,3,9,5,2,11,13,12,7};
		mergeSort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
	}
}

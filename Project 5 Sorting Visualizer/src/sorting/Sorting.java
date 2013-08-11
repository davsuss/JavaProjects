package sorting;
import java.util.LinkedList;
import java.util.Random;

import main.*;
public class Sorting {
public static void InsertionSort(JArray array)
{
	int size = array.getSize();
	int lowestValue = 0;
	int valueIndex = 0;
	int temp = 0;
	for(int x = 0; x < size; x++)
		{
		lowestValue = array.getValueAt(x);
		valueIndex = x;
		for(int y = x + 1; y < size; y++){
			temp =array.getValueAt(y);
			if(temp < lowestValue)
			{
				lowestValue = temp;
				valueIndex = y;
			}
		}
		array.Swap(x,valueIndex);
		}

}
public static void BubbleSort(JArray array)
{
int size = array.getSize();
for(int x = size; x > 0; x--)
{
for(int y = 0; y < (x-1); y++)
{
if(array.getValueAt(y) > array.getValueAt(y+1))
	array.Swap(y,y+1);
}
}
}
public static void GnomeSort(JArray array)
{
	int size = array.getSize();
	int index = 1; 
	while(index < size)
	{
		if(array.getValueAt(index -1) <=array.getValueAt(index))
			index++;
		else
		{
		array.Swap(index-1,index);
		if(index > 1)
			index--;
		}
		
		
		
	}
}
public static void QuickSort(JArray array)
{
quicksort(array,0,array.getSize()-1);
}
private static void quicksort(JArray array,int low,int high)
{
int left = low;
int right = high;
int pivotValue = array.getValueAt(low + (high + low)/2);
while(left <= right)
{
	while(array.getValueAt(left) < pivotValue)
	{
		left++;
	}
	
	while(array.getValueAt(right) > pivotValue)
	{
		right--;
	}
	if(left <= right)
	{
		array.Swap(left,right);
		left++;
		right--;
	}
}
if(low < right)
	quicksort(array,low,right);
if(left < high)
	quicksort(array,left,high);
}

public static void MergeSort(JArray array)
{
	MergeSplit(array,0,array.getSize() -1);
}
private static void MergeSplit(JArray array, int indexA, int indexB)
{
	if(indexA == indexB)
		return;
	int half = indexB - (indexB-indexA)/2;
	MergeSplit(array,indexA,half-1);
	MergeSplit(array,half,indexB);
	Merge(array,indexA,half-1,half,indexB);
	
}
private static void Merge(JArray array, int indexA1, int indexA2, int indexB1, int indexB2)
{
LinkedList<Integer> temparray = new LinkedList<Integer>();
int beginingindex = indexA1;
while(indexA1 <= indexA2 || indexB1 <= indexB2)
{
if((indexA1 <= indexA2) && (indexB1 > indexB2 || array.getValueAt(indexA1) <= array.getValueAt(indexB1)))
{
temparray.add(array.getValueAt(indexA1));
	
indexA1++;
}
if((indexB1 <= indexB2) && (indexA1 > indexA2 || array.getValueAt(indexB1) <= array.getValueAt(indexA1)))
{
temparray.add(array.getValueAt(indexB1));	
indexB1++;
}
}
for(int result: temparray)	
{
array.setValueat(beginingindex,result);
beginingindex++;
}
}
}

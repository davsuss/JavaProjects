 //Class: JArray
/*
 * Description: A class that represents the gatekeeper for the array to be sorted, this class allows for the tracking of what elements were accessed and the number of accesses. 
 */
package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class JArray implements ArrayChangedEventGenerator {
private int m_accesstimes;
private ArrayList<Integer> m_array;
private ArrayList<ArrayChangedEventListener> m_listeners;

public JArray(int elements)
{
m_accesstimes = 0;
m_listeners = new ArrayList<ArrayChangedEventListener>();
m_array = new ArrayList<Integer>();

for(int x = 0; x <elements ; x++)
	m_array.add(x);
long seed = System.nanoTime();
Collections.shuffle(m_array, new Random(seed));
}
public int getValueAt(int index)
{
m_accesstimes++;
fireArrayChangedEvent(new ArrayChangedEvent(index,ArrayChangedEvent.Action.Access));
return m_array.get(index);
}
public void setValueat(int index, int value)
{
	m_array.set(index,value);
	fireArrayChangedEvent(new ArrayChangedEvent(index,ArrayChangedEvent.Action.Set));
}
@Override
public void addArrayChangedEventListener(ArrayChangedEventListener a) {
	m_listeners.add(a);
	
}
public void fireArrayChangedEvent(ArrayChangedEvent e)
{
	int y = m_listeners.size();
	if(y == 0)
		return;
	for(int x = 0; x < y; x++)
	{
	m_listeners.get(x).ArrayChangedEvent(e);
	}
	
}
public ArrayList<Integer> getArray() 
{
	return m_array;
}
public int getSize() 
{
return m_array.size();
}
public void Swap(int indexA, int indexB)
{
int temp = getValueAt(indexA);
setValueat(indexA,getValueAt(indexB));
setValueat(indexB,temp);
}
}

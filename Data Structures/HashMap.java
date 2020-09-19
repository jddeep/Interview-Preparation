// HashMap implementation using Arrays
class MyHashMap<K, V>{

Object[] keys;
Object[] values;
int currIndex;

MyHashMap(int size){
keys = new Object[size];
values = new Object[size];
currIndex = 0;
}

void put(Object key, Object value){
for(int i = 0;i<keys.length;i++){
if(key == keys[i]){
values[i] = value;
return;
}
}
keys[currIndex] = key;
values[currIndex] = value;
currIndex++;
}

void inString(){
for(int i = 0;i<currIndex;i++){
System.out.println((K)keys[i]+":"+(V)values[i]);
}
}
}

class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		MyHashMap<String, Integer> map = new MyHashMap<>(4);
		map.put("Wednesday", 3);
		map.put("Tuesday", 5);
		map.inString();
	}
}

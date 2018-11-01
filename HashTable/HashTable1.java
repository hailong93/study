package Hash;

import java.util.TreeMap;

public class HashTable1<K,V> {
	private TreeMap<K,V>[] hashtable;
	private int size;
	private int M;//代表开辟的空间
	
	public HashTable1(int M){
		this.M=M;
		this.size=0;
		hashtable = new TreeMap[M];
		for(int i=0;i<M;i++){
			hashtable[i]=new TreeMap<K, V>();
		}
	}
	
	public HashTable1(){
		this(97);
	}
	
	//获取hash值，即hashtable数组中相应的索引值
	private int getHash(K key){
		return (key.hashCode() & 0x7fffffff)%M;
	}
	
	public int size(){
		return size;
	}

	//添加方法
	public void add(K key,V value){
		TreeMap<K, V> map = hashtable[getHash(key)];
		if(map.containsKey(key)){
			map.put(key,value);
		}else{
			map.put(key,value);
			size++;
		}
	}
	//删除某个元素
	public V remove(K key){
		V ret = null;
		TreeMap<K,V> map = hashtable[getHash(key)];
		if(map.containsKey(key)){
			ret = map.remove(key);
			size--;
		}
		return ret;
	}
	//修改元素
	public void set(K key,V value){
		TreeMap<K,V> map = hashtable[getHash(key)];
		if(!map.containsKey(key)){
			throw new IllegalArgumentException(key+"doesn't exist!");
		}
		map.put(key,value);
	}

	public boolean contains(K key){
		return hashtable[getHash(key)].containsKey(key);
	}

	public V get(K key){
		return hashtable[getHash(key)].get(key);
	}
}

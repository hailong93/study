package Hash;

import java.util.TreeMap;

public class HashTable2<K,V> {
	private static final int uperTol=10;
	private static final int lowerTol=2;
	private static final int initCapacity=7;

	private TreeMap<K,V>[] hashtable;

	private int size;
	private int M;//代表开辟的空间

	public HashTable2(int M){
		this.M=M;
		this.size=0;
		hashtable = new TreeMap[M];
		for(int i=0;i<M;i++){
			hashtable[i]=new TreeMap<K, V>();
		}
	}

	public HashTable2(){
		this(initCapacity);
	}
	
	//获取hash值，即hashtable数组中相应的索引值
	private int getHash(K key){
		return (key.hashCode() & 0x7fffffff)%M;
	}
	private void resize(int newM){
		TreeMap<K,V> [] newHashTable  = new TreeMap[newM];
		for(int i =0;i<newM;i++){
			newHashTable[i]=new TreeMap<>();
		}
		int oldM = this.M;
		this.M=newM;
		for(int i=0;i<oldM;i++){
			TreeMap<K,V> map = hashtable[i];
			for(K key:map.keySet()){
				newHashTable[getHash(key)].put(key,map.get(key));
			}
		}
		this.hashtable=newHashTable;
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

			if(size>uperTol*M){
				resize(2*M);
			}
		}
	}
	//删除某个元素
	public V remove(K key){
		V ret = null;
		TreeMap<K,V> map = hashtable[getHash(key)];
		if(map.containsKey(key)){
			ret = map.remove(key);
			size--;
			if(size<lowerTol*M && M/2>=initCapacity){
				resize(M/2);
			}
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

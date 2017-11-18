public class Hashtable<K, V> {
		
	public class HashNode<K, V> {
		K key;
		V value;
		HashNode<K, V> next;
		
		public HashNode(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	private HashNode[] arr;
	private int size;
	
	public Hashtable() {
		arr = new HashNode[314527];
		size = 0;
	}
	
	public int getIndex(K key) {

		int hashCode = Math.abs(key.hashCode());
		int index = hashCode % arr.length;
		return index;
	}

	public String get(String key) {

		int pos = getIndex((K) key);
		String returnVal = null;
		HashNode start = arr[pos];

		while (start != null) {
			if (start.key == key) {
				returnVal = (String) start.value;
				return returnVal;
			}
			start = start.next;
		}

		return returnVal;
	}

	//check if the key exist
	public boolean containsKey(String key) {

		int index = getIndex((K) key);
		boolean returnVal = false;
		HashNode start = arr[index];
		while (start != null) {
			if (start.key.equals(key)) {
				returnVal = (boolean) start.value;
				return returnVal;
			}
			start = start.next;
		}
		return returnVal;

	}

	//add new pair to the arraylist
	public void put(String key, String value) {

		int index = getIndex((K) key);
		if (arr[index] == null) {
			arr[index] = new HashNode(key, value);
		} else {
			HashNode start = arr[index];
			if (start.key.equals(key)) {
				arr[index].value = value;
			}
			while ((start.next != null) && (start.next.key != key)) {
				start = start.next;
			}
			if (start.next != null) {
				start.next.value = value;
			}
			HashNode hn = new HashNode(key, value);
			start.next = hn;
		}

	}

	//remove key and return value
	public String remove(String key) {

		int index = getIndex((K) key);
		HashNode temp = arr[index];
		if (temp.key.equals(key)) {
			arr[index] = temp.next;
			return (String) temp.value;
		}
		while ((temp.next != null) && (temp.next.key != key)) {
			temp = temp.next;
		}
		if (temp.next != null) {
			temp.next = temp.next.next;
			return (String) temp.next.value;
		}
		return null;
	}
}
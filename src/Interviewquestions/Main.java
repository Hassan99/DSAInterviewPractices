package Interviewquestions;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        HashSet hashSet = new HashSet(107);  // Create a HashSet with capacity 107

        // Add elements
        hashSet.add(1);
        hashSet.add(100);
        hashSet.add(100);
        hashSet.add(106);

        // Check if elements exist
        System.out.println(hashSet.contains(1));  // Output: true
        System.out.println(hashSet.contains(2));  // Output: false
        System.out.println(hashSet.contains(110));

        // Remove an element
        hashSet.remove(1);
        System.out.println(hashSet.contains(1));
      /*  HashMapTest<String, Integer> map = new HashMapTest<>();

        // Add key-value pairs
        map.put("Alice", 25);
        map.put("Bob", 30);

        // Get values by key
        System.out.println(map.get("Alice"));  // Output: 25
        System.out.println(map.get("Bob"));    // Output: 30

        // Check if key exists
        System.out.println(map.containsKey("Alice"));  // Output: true
        System.out.println(map.containsKey("Charlie"));  // Output: false

        // Remove a key-value pair
        map.remove("Alice");
        System.out.println(map.get("Alice"));  // Output: null*/

        /*HashMapTest1 myHashMap = new HashMapTest1();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(""+myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(""+myHashMap.get(3));    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(""+myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(""+myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]*/
    }
}
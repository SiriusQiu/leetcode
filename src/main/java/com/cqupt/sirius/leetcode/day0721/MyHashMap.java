package com.cqupt.sirius.leetcode.day0721;

public class MyHashMap {
    static  class Entry{
        int key;
        int value;
        Entry next;
        Entry(int key, int value){
            this(key, value, null);
        }
        Entry(int key, int value, Entry next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private Entry[] table;
    private int capacity;
    private int size;
    private float loadFactor;


    /** Initialize your data structure here. */
    public MyHashMap() {
        this(0.75F);
    }

    public MyHashMap(float loadFactor){
        this.loadFactor = loadFactor;
        this.capacity = 1<<4;
        this.table = new Entry[this.capacity];
        this.size = 0;
    }



    /** value will always be non-negative. */
    public void put(int key, int value) {
        if(table[key&(capacity-1)]==null){
            Entry newEntry = new Entry(key, value);
            table[key&(capacity-1)] = newEntry;
            size++;
        }else {
            Entry p = table[key&(capacity-1)];
            while (p!=null&&p.key!=key) p = p.next;
            if(p==null){
                if (size + 1>=(capacity*loadFactor)){
                    resize();
                }
                Entry newEntry = new Entry(key, value,table[key&(capacity-1)]);
                table[key&(capacity-1)] = newEntry;
                size++;
            }else {
                p.value = value;
            }
        }
    }
    public void resize(){
        Entry[] oldTable = table;
        capacity = capacity << 1;
        Entry[] newtable = new Entry[capacity];
        for (Entry entry : oldTable){
            if (entry!=null){
                if (entry.next==null) newtable[entry.key&(capacity-1)]=entry;
                else {
                    Entry loHead=null, loTail=null, hiHead=null, hiTail=null,p = entry;
                    while (p!=null){
                        if ((p.key&(capacity>>>1))==0){
                            if (loTail==null){
                                loHead = p;
                                loTail = loHead;
                            }else {
                                loTail.next = p;
                                loTail = loTail.next;
                            }
                        }else {
                            if (hiTail==null){
                                hiHead = p;
                                hiTail = hiHead;
                            }else {
                                hiTail.next = p;
                                hiTail = hiTail.next;
                            }
                        }
                        p = p.next;
                    }
                    if (loHead!=null){
                        loTail.next = null;
                        newtable[loHead.key&(capacity-1)] = loHead;
                    }
                    if (hiHead!=null){
                        hiTail.next = null;
                        newtable[hiHead.key&(capacity-1)] = hiHead;
                    }
                }
            }
        }
        table = newtable;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        Entry entry = table[key&(capacity-1)];
        if (entry == null) return -1;
        while (entry!=null){
            if (entry.key == key) return entry.value;
            entry=entry.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        Entry entry = table[key&(capacity-1)];
        if (entry==null) return;
        else if (entry.key==key) table[key&(capacity-1)] = entry.next;
        else {
            while (entry.next!=null){
                if (entry.next.key==key){
                    entry = entry.next.next;
                }
                entry = entry.next;
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        System.out.println(myHashMap.get(79));
        myHashMap.put(72,7);
        myHashMap.put(77,1);
        myHashMap.put(10,21);
        myHashMap.remove(26);
        myHashMap.put(94,5);
        myHashMap.put(53,35);
        myHashMap.put(34,9);
        System.out.println(myHashMap.get(94));
        myHashMap.put(96,8);
        myHashMap.put(73,79);
        myHashMap.put(7,60);
        myHashMap.put(84,79);
        System.out.println(myHashMap.get(94));
        myHashMap.put(18,13);
        System.out.println(myHashMap.get(18));
        myHashMap.put(69,34);
        myHashMap.put(21,82);
        myHashMap.put(57,64);
        myHashMap.put(23,60);
        myHashMap.remove(0);
        myHashMap.put(12,97);
        System.out.println(myHashMap.get(12));
        myHashMap.put(56,90);
        System.out.println(myHashMap.get(56));
        myHashMap.put(44,57);
        System.out.println(myHashMap.get(44));
        myHashMap.put(30,12);
        System.out.println(myHashMap.get(30));
        myHashMap.put(17,10);
        System.out.println(myHashMap.get(17));
        myHashMap.put(42,13);
        System.out.println(myHashMap.get(42));
        myHashMap.put(62,6);
        System.out.println(myHashMap.get(62));
        System.out.println(myHashMap.get(34));

    }
}

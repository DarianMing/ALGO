package com.lm.demo.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K,V> extends LinkedHashMap<K,V>{

    private int CACHE_SIZE;

    /**
     * 传递进来最多能缓存多少数据
     *
     * @param cacheSize 缓存大小
     */
    public LRUCache (int cacheSize) {
        // true 表示让 LinkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }


    @Override
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        // 当 map 中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return size() > CACHE_SIZE;
    }

    public static void main(String[] args) {
        LRUCache<Integer , String> lruCache = new LRUCache(5);
        lruCache.put(1 , "1");
        lruCache.put(2 , "2");
        lruCache.put(3 , "3");
        lruCache.put(4 , "4");
        lruCache.put(5 , "5");
        lruCache.put(6 , "6");
        lruCache.forEach((key , val) -> System.out.println(key + "---->" + val));
    }

}

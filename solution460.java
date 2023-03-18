import java.util.HashMap;
import java.util.LinkedHashSet;
/**
 * solution460
 */
public class solution460 {

    
}
class LFUCache {
    /**
     * 基本原理：使用LinkedHashSet实现 元素有序+快速增删查改。LinkedHashSet底层使用 LinkedHashMap。
     *
     * 写代码步骤：
     * 1、搭大框架。建立 KV KF FV 映射，minFeq变量记录最小freq值
     * 2、实现2个供get/put方法调用的API：increaseFreq、removeMinFreqKey
     * 3、实现get/put方法
     * @param capacity
     */

    HashMap<Integer,Integer> keyToValue; //key到value的映射，称为KV表
    HashMap<Integer,Integer> keyToFreq; //key到freq（使用频率）的映射，称为KF表
    // 注意，因为可能有多个key使用频率相同，所以一个freq对应多个key。用LinkedHashSet来装多个key，LinkedHashSet内部对key按最近最少使用排序（LRU），左边（靠近头部）是最近最少使用的，右边（靠近尾部）是最近使用过的。
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys; //freq到多个key的映射，称为FK表。
    int minFreq; //记录最小频率值
    int cap; //最大容量

    public LFUCache(int capacity) {
        keyToValue = new HashMap<>();
        keyToFreq = new HashMap<>();
        freqToKeys = new HashMap<>();
        minFreq = 0;
        cap = capacity;
    }

    public int get(int key) {
        if(!keyToValue.containsKey(key)){
            return -1;
        }
        increaseFreq(key);
        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if(cap<=0){
            return;
        }
        
        if(keyToValue.containsKey(key)){ //已经存在相同key
            keyToValue.put(key,value);
            increaseFreq(key);
            return;
        }

        if(keyToValue.size() == cap){ //容量满了，移除使用频次最少的key
            removeMinFreqKey();
        }

        //加入新元素

        //插入KV表
        keyToValue.put(key,value);
        //插入KF表
        keyToFreq.put(key,1);
        //插入FK表
        freqToKeys.putIfAbsent(1,new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        //插入新key后minFreq肯定是1
        minFreq = 1;

    }


    //实现2个供get/put方法调用的API：increaseFreq、removeMinFreqKey
    //核心就是对3个映射表操作，不要漏掉

    public void increaseFreq(int key){
        //更新KF表
        int freq = keyToFreq.get(key);
        keyToFreq.put(key,freq+1);

        //更新FK表
        freqToKeys.get(freq).remove(key); //从原来的freq删除
        freqToKeys.putIfAbsent(freq+1, new LinkedHashSet<>()); //先判断是否有新的freq阵营。putIfAbsent：如果已经存在，则不做改变；如果不存在，则加入新元素
        freqToKeys.get(freq+1).add(key); //将该key加入到新的freq阵营

        //如果老的freq阵营因为移除key而变空了，就把那个阵营删掉
        if(freqToKeys.get(freq).isEmpty()){
            freqToKeys.remove(freq);
            //如果这个freq恰好是minFreq，更新minFreq
            if(freq == minFreq){
                minFreq ++; //新的minFreq肯定是原来+1，因为刚刚使key加入新阵营freq+1了
            }
        }
    }

    public void removeMinFreqKey(){
        //在FK表找到要删除的key，并删除之
        LinkedHashSet<Integer> keysList = freqToKeys.get(minFreq); //获取最小频率对应的key表
        int deleteKey = keysList.iterator().next(); //排在LinkedHashSet首位的就是最近最久未使用的key，要被删除
        keysList.remove(deleteKey); //删除deleteKey
        if(keysList.isEmpty()){
            freqToKeys.remove(minFreq); //如果minFreq对应的key都没了，则删除这个阵营
            //这里不用给minFreq赋新值，因为是put调用的removeMinFreqKey方法，后面会put新元素，put新元素时minFreq=1
        }

        //在KV表删除
        keyToValue.remove(deleteKey);
        //在KF表删除
        keyToFreq.remove(deleteKey);



    }


}
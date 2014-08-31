/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package collection1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class ListMapSet{
    
    public static void main(String args[]) {
        LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
        set.add(0);
        set.add(0);
        set.add(1);
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        
        List<Integer> list1 = list.subList(0, 4);
        list = list.subList(4, 9);
        list.addAll(list1);
        
        for (Integer ele : list) {
            System.out.println(ele);
        }
        
        
        Collections.shuffle(list);
        
        Iterator iterator = set.iterator();
        
        System.out.println("Set");
        while(iterator.hasNext())
            System.out.println(iterator.next());
        
        
        System.out.println("List");
        iterator = list.iterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());
        
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        map.put(0, 0);
        map.put(0, 1);
        
        int i = map.size();
        System.out.println("Map");
        while(--i >= 0)
            System.out.println(map.get(i));
        
    }
}

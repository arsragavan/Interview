/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package collection1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

class Card implements Comparable<Card>, Comparator<Card> {

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Card other = (Card) obj;
        if (this.number != other.number) {
            return false;
        }
        if (!Objects.equals(this.face, other.face)) {
            return false;
        }
        return true;
    }
    int number;
    String face;
    
    public Card(int number, String face) {
        this.face = face;
        this.number = number;
    }
    
      
    public String toString() {
        return number + " : "+face;
    }

    @Override
    public int compareTo(Card o) {
        
        return this.face.compareTo(o.face);
    }

    @Override
    public int compare(Card o1, Card o2) {
        System.out.println("Hello");
        return o1.face.compareTo(o2.face);
    }
    
}


class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
        
    }    
}

public class Comparator1 {
    
    public static void main(String args[]) {
        List<Card> card = new ArrayList<Card>();
        
        
        card.add(new Card(5, "Spade"));
        card.add(new Card(2, "Clubs"));
        card.add(new Card(6, "Hearts"));
        card.add(new Card(3, "Diamond"));
        card.add(new Card(4, "Spade"));
        card.add(new Card(1, "Clubs"));
        card.add(new Card(7, "Diamond"));
        
        List<String> str = new ArrayList<String>();
        str.add("abc");
        
        str.add("cde");
        str.add("def");
        str.add("efg");
        str.add("fgh");
        str.add("bcd");
        
        Collections.sort(str);
        
//        for(String strlist : str) {
//            System.out.println(strlist);
//        }
        
        Collections.sort(card, new Card(0, null));
        
        for (Card list: card) {
            System.out.println(list);
        }
        
        
    }

}

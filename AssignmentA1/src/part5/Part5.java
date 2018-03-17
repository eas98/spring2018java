package part5;

import part1.Node;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Part5{
	
	public static<E> Node<E> reverseLinkedList(Node<E> head) {
		Node<E> reversed = null;
		Node<E> temp = head;
		while(temp != null) {
			Node<E> tNext = temp.next;
			if(reversed == null) {
				reversed = temp;
				reversed.next = null;
			} else {
				Node<E> t1 = reversed;
				reversed = temp;
				reversed.next = t1;
			}			
			temp = tNext;
		}
		return reversed;
	}
	public static<E> Node<E> createLinkedList(E [] data) {
		
		Node<E> lastNode = null;
		for(Integer i = data.length-1;i>=0;i--) {
			Node<E> node = new Node<E>(data[i]);
			if(lastNode != null) {
				node.next = lastNode;
			}
			lastNode = node;
		}
		
		return lastNode;
	}
	public static<E> String getAsString(Node<E> linkedList) {
		String str = ""; 
		Node<E> nextNode = linkedList;
		while(nextNode != null) {
			if(!str.isEmpty())
				str += ", ";
			str += nextNode.data.toString();
			nextNode = nextNode.next;
		}
		str = "[" + str + "]";
		return str;
	}
	public static void testWithStaticData(Integer [] data) {
		System.out.println("------");
		Node<Integer> linkedlist = createLinkedList(data);
		String strLinkedList = getAsString(linkedlist);
		
		Node<Integer> reversedList = reverseLinkedList(linkedlist);
		String strReversedLinkedList = getAsString(reversedList);
		
		String strData = Arrays.toString(data);
		
		List<Integer> list = Arrays.asList(data);
		Collections.reverse(list);
		Object[] reversedData = list.toArray();
		String reversedStrData = Arrays.toString(reversedData);
				
		System.out.println("data:"+strData);
		System.out.println("Reversed Data:"+reversedStrData);
		System.out.println("LinkList:"+strLinkedList);
		System.out.println("Reversed LinkList:"+strReversedLinkedList);
		boolean originalAreEqual = strData.equals(strLinkedList);
		boolean reversedAreEqual = reversedStrData.equals(strReversedLinkedList);
		System.out.println("LinkList Build Passes:"+originalAreEqual);
		System.out.println("ReverseList Build Passes:"+reversedAreEqual);
		System.out.println("------");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("***part5***");
		Integer [] data1 = {-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10};
		Integer [] data2 = {-2,-1,0,1,2};
		Integer [] data3 = {10,20,30,40,50,60,70,80,90,100};
		testWithStaticData(data1);
		testWithStaticData(data2);
		testWithStaticData(data3);
	}
}

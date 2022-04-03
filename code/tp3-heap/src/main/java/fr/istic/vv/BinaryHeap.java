package fr.istic.vv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * BinaryHeap using a binary tree where the minimum element is always the root
 *
 * @param <T>
 */
class BinaryHeap<T> {

	private ArrayList<T> binaryTree;
	private Comparator<T> compare;

	public BinaryHeap(Comparator<T> comparator) {
		binaryTree = new ArrayList<T>();
		compare = comparator;
	}

	public T pop() {
		return null;
	}

	/**
	 * Return the minimum element of the binary heap
	 * 
	 * @return the minimum T object
	 */
	public T peek() {
		if (binaryTree.isEmpty()) {
			return null;
		}
		return binaryTree.get(0);
	}

	public void push(T element) {
		int parentIndex=(int)Math.floor((this.count()-1)/2);
		
		if (binaryTree.isEmpty()) {
			binaryTree.add(element);

		} else if (compare.compare(element, binaryTree.get((int)Math.floor((this.count()-1)/2))) >= 1) {
			// if the element to add is greater or equals than its parent,
			// then it is added because it is still ordered
			binaryTree.add(element);
			
		}else {
			
			while(parentIndex>-1) {
				T current = binaryTree.get(parentIndex);
				int childIndex= (2*parentIndex)+1;
				if (compare.compare(element, current) < 1) {
					binaryTree.set(parentIndex, element);
					
					if(childIndex>=this.count()) {
						binaryTree.add(current);
					}else {
						binaryTree.set(childIndex, current);
					}
					
				}
				parentIndex=(int)Math.floor((parentIndex-1)/2);

			}
			
		}

	}

	/**
	 * Returns the number of elements in the binary tree.
	 * 
	 * @return
	 */
	public int count() {
		return binaryTree.size();
	}

}
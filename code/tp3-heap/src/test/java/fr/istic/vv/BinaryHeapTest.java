package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

class BinaryHeapTest {

	BinaryHeap<Integer> tree;
	ComparatorSuperior comp;
	@BeforeEach
	public void setUp() {
		comp = new ComparatorSuperior();
		tree = new BinaryHeap<Integer>(comp);
	}
	
	@Test
	public void pushInEmptyTest() {
		tree.push(12);
		assertEquals(tree.count(), 1);
	}
	
	@Test
	public void pushTwoInOrderTest() {
		tree.push(12);
		tree.push(134);
		assertEquals(tree.count(), 2);
	}
	
	@Test
	public void pushTwoInDisorderTest() {
		tree.push(12);
		tree.push(134);
		assertEquals(tree.count(), 2);
	}
	
	@Test
	public void getMinTest() {
		tree.push(1422);
		tree.push(1);
		assertEquals(tree.peek(), 1);
	}
}
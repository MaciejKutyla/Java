package pl.edu.agh.kis.java2015.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapTest {
	
	@Test
	public void insert0intoNewHeap_topIs0() {
		
		Heap heap = new Heap();
		heap.insert(0);
		
		assertEquals("size should be 1",1,heap.size());
		assertEquals(0,heap.top(),0.001);
		assertEquals(1,heap.size());
	}
	
	@Test
	public void insert0AndThen2intoNewHeap_topIs2() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		
		assertEquals("size should be 2",2,heap.size());
		assertEquals(2,heap.top(),0.001);
	}
	
	@Test
	public void insert0And2And3And5And6intoNewHeap_topIs6() {
		
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		
		assertEquals(6,heap.top(),0.001);
	}
	@Test
	public void maxTest(){
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		heap.insert(30);
		heap.insert(15);
		heap.insert(1);


		assertEquals(30,heap.extractMax(),0.001);
		assertEquals(7,heap.size(),0.001);



	}

	@Test
	public void maxDelTest(){
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		heap.insert(16);
		heap.insert(15);
		heap.insert(1);

		heap.deleteMax();
		assertEquals(7,heap.size(),0.001);
		assertEquals(15,heap.extractMax(),0.001);


	}

	@Test
	public void replaceTest(){
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);
		heap.insert(6);
		heap.insert(16);
		heap.insert(15);
		heap.insert(1);

		System.out.print("\n***\n");
		heap.replace(50);
		assertEquals(8,heap.size(),0.001);
		assertEquals(50,heap.extractMax(),0.001);


	}

	@Test
	public void heapifyTest(){
		double[] t={32,43,1,53,2};
		Heap heap=new Heap();
		heap=heap.heapify(t);

		assertEquals(5,heap.size(),0.001);
		assertEquals(53,heap.extractMax(),0.001);


	}

	@Test
	public void repTest() {
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);

		Heap heap1=new Heap();
		heap1.insert(6);
		heap1.insert(16);
		heap1.insert(15);
		heap1.insert(1);

		Heap res = heap.merge(heap1);

		assertEquals(res.size(),heap.size()+heap1.size(),0.001);
		assertEquals(16,res.extractMax(),0.001);

	}

	@Test
	public void meldTest() {
		Heap heap = new Heap();
		heap.insert(0);
		heap.insert(2);
		heap.insert(3);
		heap.insert(5);

		Heap heap1=new Heap();
		heap1.insert(6);
		heap1.insert(16);
		heap1.insert(15);
		heap1.insert(1);

		heap.meld(heap1);

		assertEquals(8,heap.size(),0.001);
		assertEquals(16,heap.extractMax(),0.001);

	}

}

package pl.edu.agh.kis.java2015.domain;

import java.util.ArrayList;

public class Heap {

	private int heapSize = 0;
	private ArrayList<Double> tab = new ArrayList<>();

	public void insert(double value) {
		int currentIndex = heapSize;
		int parentIndex = parentIndex(currentIndex);
		tab.add(value);
		while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
		heapSize++;
	}

	public boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
		return tab.get(currentIndex) > tab.get(parentIndex);
	}

	public void swapElements(int currentIndex, int parentIndex) {
		Double parentValue = parentValue(currentIndex);
		Double currentValue = tab.get(currentIndex);
		tab.set(parentIndex, currentValue);
		tab.set(currentIndex, parentValue);
	}

	public Double parentValue(int currentIndex) {
		Double parentValue = tab.get(parentIndex(currentIndex));
		return parentValue;
	}

	public int parentIndex(int currentIndex) {
		return currentIndex/2;
	}

	public int size() {
		return heapSize ;
	}

	public double top() {
		return tab.get(0);
	}

	public double extractMax(){
		double temp=tab.get(0);
		int index=0;
		for(int i=0;i<heapSize;i++) {
			if (tab.get(i) > temp) {
				temp = tab.get(i);
				index = i;
			}
		}

		tab.remove(index);
		heapSize--;

		int currentIndex=heapSize-1;
		int parentIndex=parentIndex(currentIndex);

		while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
		return(temp);


	}

	public void deleteMax(){
		extractMax();
	}

	public void replace(double value){
		double temp=tab.get(0);
		int index=0;
		for(int i=0;i<heapSize;i++) {
			if (tab.get(i) > temp) {
				temp = tab.get(i);
				index = i;
			}
		}

		tab.set(index,value);

		int currentIndex=heapSize-1;
		int parentIndex=parentIndex(currentIndex);

		while( isChildGreaterThanParent(currentIndex, parentIndex) ) {
			swapElements(currentIndex, parentIndex);
			currentIndex = parentIndex;
			parentIndex = parentIndex(currentIndex);
		}
	}

	public Heap heapify(double[] t){
		Heap heap=new Heap();
		for (int i=0;i<t.length;i++){
			heap.insert(t[i]);
		}
		return heap;
	}

	public Heap merge(Heap h){
		Heap heap=new Heap();
		for (int i=0;i<heapSize;i++){
			heap.insert(tab.get(i));
		}
		for (int i=0;i<h.heapSize;i++){
			heap.insert(h.tab.get(i));
		}

		return heap;
	}

	public void meld(Heap h){
		for (int i=0;i<h.heapSize;i++){
			insert(h.tab.get(i));
		}
	}

}

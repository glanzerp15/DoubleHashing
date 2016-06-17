package i.hobs.gmocht;

public class Test {

	public static void main(String[] args) {
		int [] liste = {12, 53, 5 ,15, 2, 19};
		int [] liste2 = {12, 53, 5};
		
		DoubleHashing dh = new DoubleHashing(liste, 7);
		DoubleHashingBrent dhb = new DoubleHashingBrent(liste2, 7);
		
		//dh.showHashTable(dh.insertDoubleHashing());
		dh.showHashTable(dh.delete(dh.insertDoubleHashing(), 5));
		//dh.showHashTable(dhb.dHBrentAlgo());
	}

}

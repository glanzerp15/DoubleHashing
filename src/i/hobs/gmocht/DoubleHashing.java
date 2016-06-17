package i.hobs.gmocht;

public class DoubleHashing {

	private int [] liste;
	private int [] dH;
	
	public DoubleHashing(int [] liste, int groeﬂeHashTable)
	{
		this.liste = liste;
		dH = new int [groeﬂeHashTable];
	}
	
	public int [] insertDoubleHashing()
	{
		int h;
		int hstrich;
		
		for(int i = 0; i < liste.length; i++)
		{
			h = liste[i] % dH.length;
			hstrich = 1 + (liste[i] % (dH.length - 2));
			
			
			if(dH[h] == 0)
			{
				dH[h] = liste[i];
			}
			else
			{
				for(int j = 0; j < dH.length; j++)
				{
					
					int sf = (h - (j * hstrich)) % dH.length;
					
					if(sf < 0)
					{
						sf = dH.length - (-1) * sf;
					}
					
					if(dH[sf] == 0)
					{
						dH[sf] = liste[i];
						break;
					}
				}
			}
		}
		
		return dH;
		
	}
	
	public int [] delete(int [] hashTable, int index)
	{
		if(hashTable[index] != 0)
		{
			hashTable[index] = 0;
		}
		
		return hashTable;
	}

	
	public void showHashTable(int [] hashTable)
	{
		for(int i = 0; i < hashTable.length; i++)
		{
			System.out.println(i + " " + hashTable[i]);
		}
	}
}

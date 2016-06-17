package i.hobs.gmocht;

public class DoubleHashingBrent {

	private int [] liste;
	private int [] dHBrent;
	
	
	public DoubleHashingBrent(int [] liste, int groeﬂeHashTable)
	{
		this.liste = liste;
		this.dHBrent = new int [groeﬂeHashTable];
	}
	
	public int [] dHBrentAlgo()
	{
		int h;
		int hstrich;
		
		for(int i = 0; i < liste.length; i++)
		{
			h = liste[i] % dHBrent.length;
			hstrich = 1 + (liste[i] % (dHBrent.length - 2));


			
			if(dHBrent[h] == 0)
			{
				dHBrent[h] = liste[i];
			}
			else
			{
				for(int j = 0; j < dHBrent.length; j++)
				{
					
					int sf = (h - (j * hstrich)) % dHBrent.length;
					
					if(sf < 0)
					{
						sf = dHBrent.length - (-1) * sf;
					}
					
					int ih = h;
					
					while(dHBrent[ih] != 0)
					{
						int b = (ih - hstrich) % dHBrent.length;
						int b2 = (ih - (1 + (dHBrent[ih] % (dHBrent.length -2)))) % dHBrent.length;
						
						if(b < 0)
						{
							b = dHBrent.length - (-1) * b;
						}
						
						if(b2 < 0)
						{
							b2 = dHBrent.length - (-1) * b2;
						}
						
						if(dHBrent[b] == 0 || dHBrent[b2] != 0)
						{
							ih = b;
						}
						else
						{
							dHBrent[b2] = dHBrent[ih];
							dHBrent[ih] = 0;
						}
					}
					dHBrent[ih] = liste[i];
				}
			}
		}
		
		return dHBrent;	
	}
}

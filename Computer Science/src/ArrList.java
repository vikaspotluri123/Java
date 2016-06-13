public class ArrList<T>
{
	private T [] arr;
	
	@SuppressWarnings("unchecked")
	public ArrList()
	{
		this.arr = (T[]) new Object[0];
	}

	public T get(int index)
	{
		return arr[index];
	}
	
	public T set(int index, T value)
	{
		T ret = arr[index];
		arr[index] = value;
		return ret;
	}
	@SuppressWarnings("unchecked")
	public boolean add(T what)
	{
		
		T [] temp = (T[]) new Object [this.arr.length + 1];
		for(int i = 0; i < this.arr.length; i++)
			temp[i] =  this.arr[i];
		temp[temp.length-1] =  what;
		this.arr = temp;
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public boolean add(int index, T what)
	{
		T [] temp = (T[]) new Object [this.arr.length + 1];
		int i = 0;
		while(i < index)
		{
			temp[i] = this.arr[i];
			i++;
		}
		temp[index] = what;
		while(i < temp.length)
		{
			temp[i] = this.arr[i-1];
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public T remove(int index)
	{
		int i = 0;
		T [] temp = (T[]) new Object [this.arr.length - 1];
		while(i < index)
		{
			temp[i] = this.arr[i];
			i++;
		}
		i++;
		while(i < this.arr.length)
		{
			temp[i] = this.arr[i];
			i++;
		}
		T toRet = this.arr[index];
		this.arr = temp;
		return toRet;
		
	}
	
	@SuppressWarnings("unchecked")
	public boolean removeRange(int startIndex, int endIndex)
	{
		int i = 0;
		T [] temp = (T[]) new Object [this.arr.length - 1];
		while(i < startIndex)
		{
			temp[i] = this.arr[i];
			i++;
		}
		i = endIndex;
		while(i < this.arr.length)
		{
			temp[i] = this.arr[i];
			i++;
		}
		this.arr = temp;
		return true;
		
	}
	
	public int size()
	{
		return arr.length;
	}
	public String toString()
	{
		String ret = "[";
		for(T e : this.arr)
		{
			ret += e + ", ";
		}
		return ret + "]";
	}
	
	public int indexOf(T what)
	{
		for(int i = 0; i < arr.length - 1; i++)
		{
			if(arr[i] == what)
				return i;
		}
		return -1;
	}
	
	public boolean contains(T what)
	{
		for(T th : arr)
		{
			if(th == what)
				return true;
		}
		return false;
	}
	public static void main(String [] args)
	{
	}
}

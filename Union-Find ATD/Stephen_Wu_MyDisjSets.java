
/**
 * Required constructor.
 * @param numElements is the total number of elements, each element is initially in its own set.
 */
public class MyDisjSets implements DisjointSets{
	private int[] array; //Initialize an empty array of int
	private int count;
	
	//initialize a disjoint set with the passed in numbers
	public MyDisjSets(int numElements){
		array = new int[numElements + 1];
		for(int i = 0; i < array.length; i++){
			array[i] = -1;
		}
		count = numElements;
	}
	
	
    /**
     * Union (combine) two disjoint sets into one set. 
     * No restriction on which set should be added to the other set.
     * @param set1 the name of set 1.
     * @param set2 the name of set 2.
     * @throws InvalidSetNameException if either of set1 or set2 are 
     * not the name of sets.
     * @throws InvalidElementException if either of set1 or set2
     * is not a valid element. 
     */
	public void union(int set1, int set2){
		if(array[set1] > 0 || array[set2] > 0){
			throw new InvalidSetNameException();
		} else if (set1 > array.length || set2 > array.length){
			throw new InvalidElementException();
		}
		
		//if set1 is bigger than set2
		//merge set2 to set1 and update the total size of set1
		if (array[set1] <= array[set2]){
			array[set1] += array[set2];
			array[set2] = set1;
		} else {
			array[set2] += array[set1];
			array[set1] = set2;
		}
		
		//after union we have one less set
		count --;
		
	}
	
	/**
     * Find which set element x belongs to.
     * @param x the element being searched for.
     * @return the name of the set containing x.
     * @throws InvalidElementException if x is not a valid element. 
     */
    public int find(int x){
    	if(x > array.length){
    		throw new InvalidElementException();
    	}
    	
    	while(array[x] > 0){
    		x = array[x];
    	}
    	
    	return x;
    }

    /**
     * Returns the current total number of sets.
     * @return the current number of sets.
     */
    public int numSets(){
    	return count;
    }

    /**
     * Determine if an element is the name of a set.
     * @param x an element
     * @return true if x is the name of a set
     * @throws InvalidElementException if x is not a valid element. 
     */
    public boolean isSetName(int x){
    	if(x > array.length){
    		throw new InvalidElementException();
    	}
    	return array[x] < 0;
    }

    /**
     * Returns the total number of elements in the given set.
     * @param setNum the name of a set
     * @throws InvalidSetNameException if setNum is not the name of a set.
     * @throws InvalidElementException if setNum is not a valid element. 
     */
    public int numElements(int setNum){
    	if (array[setNum] > 0){
    		throw new InvalidSetNameException();
    	} else if (setNum > array.length){
    		throw new InvalidElementException();
    	}
    	
    	return Math.abs(array[setNum]);
    }

    /**
     * Prints out the elements in the given set.
     * setNum is assumed to be a root and represents the name of a set.
     * @param setNum the name of a set
     * @throws InvalidSetNameException if setNum is not the name of a set.
     * @throws InvalidElementException if setNum is not a valid element. 
     */
    public void printSet(int setNum){
    	if (array[setNum]>0){
    		throw new InvalidSetNameException();
    	} else if(setNum > array.length){
    		throw new InvalidElementException();
    	}
    	
    	System.out.print("{");
    	int [] print = getElements(setNum);
    	for (int i = 0; i< print.length - 1; i++){
    		System.out.print(print[i] + ", ");
    	}
    	System.out.print(print[print.length - 1] + "}");
    }

    /**
     * Returns an array containing the elements in the given set.
     * @param setNum the name of a set
     * @returns an array containing the elements in the given set.
     * @throws InvalidSetNameException if setNum is not the name of a set.
     * @throws InvalidElementException if setNum is not a valid element. 
     */
    public int [] getElements(int setNum){
    	if (array[setNum]>0){
    		throw new InvalidSetNameException();
    	} else if(setNum > array.length){
    		throw new InvalidElementException();
    	}
    	
    	//initialize new array
    	int [] data = new int[Math.abs(array[setNum])];
    	data[0] = setNum;
    	return getElementsHelper(setNum, data, 1);
    }
    
    //private helper method to help find the elements in the set
    private int[] getElementsHelper(int setNum, int[] data, int index){
    	if (index > data.length){
    		return data;
    	} else{
    		
    		//iterate the through the whole array to find correct
    		//elements
    		for(int i = 0; i < array.length; i++){
    			if(array[i] == setNum){
    				
    				//put element into the next open slot in the array
    				data[index] = i;
    				index++;
    				
    				//find all elements that are connect to that particular element
    				//basically set it as root and continue explore the array
    				data = getElementsHelper(i, data, index);
    			}
    		}
    		return data;
    	}
    }
}

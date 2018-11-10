
public abstract class Substitutor {
	
	private int numOfLetters = 26;
	
	// Abstract functions.
	public abstract char forwardTranslation(char permutation);
    public abstract char reverseTranslation(char permutation);
    
    // A function to change a given letter to an index.
    public int letterToIndex(char letter){
    	
        return (int) (Character.toUpperCase(letter)) - (int)('A');
        
    }

    // The iteration to the left.
    public int leftCircularShift(int letter, int numOfShifts){
    	
        return this.rightCircularShift(letter ,numOfLetters - numOfShifts);
        
    }

    // The iteration to the right.
    public int rightCircularShift(int letter, int numOfShifts){
    	
        if (numOfShifts < 0) return (letter + numOfLetters + numOfShifts) % numOfLetters;
        else return (letter + numOfShifts) % numOfLetters;
        		
    }
    
}
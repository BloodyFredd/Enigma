
public abstract class Substitutor {
	
	private int numOfLetters = 26;
	
	public abstract char forwardTranslation(char permutation);
    public abstract char reverseTranslation(char permutation);
    public int letterToIndex(char letter){
    	
        return (int) (Character.toUpperCase(letter)) - (int)('A');
        
    }

    public int leftCircularShift(int letter, int numOfShifts){
    	
        return this.rightCircularShift(letter ,numOfLetters - numOfShifts);
        
    }

    public int rightCircularShift(int letter, int numOfShifts){
    	
        if (numOfShifts < 0) return (letter + numOfLetters + numOfShifts) % numOfLetters;
        else return (letter + numOfShifts) % numOfLetters;
        		
    }
    
}
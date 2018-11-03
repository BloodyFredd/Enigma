
public abstract class Substitutor {
	
	private int numOfLetters = 26;
	
	public abstract char forwardTranslation(char permutation);
    public abstract char reverseTranslataion(char permutation);
    public int letterToIndex(char letter){
    	
        return (int) (Character.toUpperCase(letter)) - (int)('A');
        
    }

    public int leftCircularShift(char letter, int numOfShifts){
    	
        return this.rightCircularShift(letter ,26 - numOfShifts);
        
    }

    public int rightCircularShift(char letter, int numOfShifts){
    	
        if (numOfShifts < 0) return (letter + 26 + numOfShifts) % 26;
        else return (letter + numOfShifts) % 26;
        		
    }
    
}
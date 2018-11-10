import java.util.List;


public class Reflector extends Translator {

	private List<Character> reflector;
	
	Reflector(List<Character> reflector){
		
		super(reflector);
		this.reflector = reflector;
		
	}
	
	// The translation of each letter.
	@Override
	public char forwardTranslation(char permutation) {

		return reflector.get(this.letterToIndex(Character.toUpperCase(permutation)));
		
	}

	// The reverse translation of each letter.
	@Override
	public char reverseTranslation(char permutation) {

		return this.forwardTranslation(permutation);
		
	}

}

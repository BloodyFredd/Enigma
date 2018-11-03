import java.util.List;


public class Reflector extends Translator {

	private List<Character> reflector;
	
	Reflector(List<Character> reflector){
		
		super(reflector);
		this.reflector = reflector;
		
	}
	
	@Override
	public char forwardTranslation(char permutation) {

		return reflector.get(this.letterToIndex(Character.toUpperCase(permutation)));
		
	}

	@Override
	public char reverseTranslataion(char permutation) {

		return this.forwardTranslation(permutation);
		
	}

}

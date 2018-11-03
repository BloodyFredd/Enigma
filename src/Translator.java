import java.util.List;


public class Translator extends Substitutor {
	
	private List<Character> permutation;
	
	Translator(List<Character> permutation){
		
		this.permutation = permutation;
		
	}
	
	@Override
	public char forwardTranslation(char permutation) {
		
		return this.permutation.get(this.letterToIndex(permutation));
		
	}

	@Override
	public char reverseTranslataion(char permutation) {

		return (char) ((int)'A' + this.permutation.get(Character.toUpperCase(permutation)));
		
	}

}

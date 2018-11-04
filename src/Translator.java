import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Translator extends Substitutor {
	
	private Map<Integer, Character> dictionary;
	List<Character> permutation;
	List<Character> revPermutation;
	
	Translator(List<Character> permutation){
		
		this.permutation = permutation;
		int i = 0;
		revPermutation = new ArrayList<Character>();
		for(char tmp = 'A'; tmp != 'Z'; tmp++){
			
			revPermutation.add(i, tmp);
			System.out.println("i: " + i + ", letter: " + tmp);
			i++;
		
		}
		
	}
	
	@Override
	public char forwardTranslation(char permutation) {
		
		System.out.println(this.letterToIndex(permutation));
		return this.permutation.get(this.letterToIndex(permutation));
		
	}

	@Override
	public char reverseTranslation(char permutation) {

		System.out.println("!!!!"+ this.permutation.get(this.letterToIndex(permutation)));
		//return (char)(this.permutation.get(this.letterToIndex(permutation)));
		System.out.println(this.revPermutation.get(this.permutation.get(this.letterToIndex(permutation)) - 'A'));
		return this.revPermutation.get(this.permutation.get(this.letterToIndex(permutation)) - 'A');
	}

}

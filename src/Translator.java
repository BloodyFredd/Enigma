
import java.util.List;

public class Translator extends Substitutor {
	
	char [] permutation = new char[26];
	char [] revPermutation = new char[26];
	
	Translator(List<Character> permutation){
		
		int i = 0;
		char c = 'A';
		if(permutation != null) {
			for(char tmp: permutation) {
			
			this.permutation[i] = tmp;
			revPermutation[this.letterToIndex(tmp)] = c;
			i++;
			c++;
			
			}
		}
	}
	
	@Override
	public char forwardTranslation(char permutation) {
		
		return this.permutation[this.letterToIndex(permutation)];
		
	}

	@Override
	public char reverseTranslation(char permutation) {

		return this.revPermutation[this.letterToIndex(permutation)];
		
	}

}

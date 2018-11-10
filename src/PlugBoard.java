import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlugBoard extends Translator {

	private String[] configuration;
	Map<Character, Character> dictionary = new HashMap<Character, Character>();
	
	PlugBoard(List<Character> configuration){
		
		super(null);
		StringBuilder st = new StringBuilder();
		String config;
		for(Character c: configuration){
			
			st.append(c);
			
		}
		
		config = st.toString();
		if(config != null) 
			this.configuration = config.trim().split("\\s+");
		
		if(this.configuration.length != 1) {
			for(String pair: this.configuration){
			
			this.dictionary.put((pair.charAt(0)), pair.charAt(1));
			this.dictionary.put((pair.charAt(1)), pair.charAt(0));
			
			}
		}
		
		
	}
	
	// The translation of the letter in the plug.
	@Override
	public char forwardTranslation(char permutation) {
		
		if(dictionary.containsKey(permutation)) 
			return this.dictionary.get(permutation);
		return Character.toUpperCase(permutation);
		
	}

}

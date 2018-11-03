import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PlugBoard extends Translator {

	private String[] configuration;
	Map<Character, Character> dictionary = new HashMap<Character, Character>();
	
	PlugBoard(List<Character> configuration){
		
		super(configuration);
		StringBuilder st = new StringBuilder();
		String config;
		for(Character c: configuration){
			
			st.append(c);
			
		}
		
		config = st.toString();
		this.configuration = config.trim().split("\\s+");
		for(String pair: this.configuration){
			
			this.dictionary.put((pair.charAt(0)), pair.charAt(1));
			this.dictionary.put((pair.charAt(1)), pair.charAt(0));

		}
		
	}
	
	@Override
	public char forwardTranslation(char permutation) {
		
		if(dictionary.containsKey(permutation))
			return this.dictionary.get(permutation);
		
		return Character.toUpperCase(permutation);
		
	}

}

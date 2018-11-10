import java.util.ArrayList;
import java.util.List;


public class Enigma extends Substitutor {
	
	private Rotor[] rotors;
	private Reflector reflector;
	private PlugBoard plugBoard;
	
	Enigma(Rotor[] rotors, Reflector reflector, PlugBoard plugBoard){
		
		this.rotors = rotors;
		this.reflector = reflector;
		this.plugBoard = plugBoard;
		
	}
	
	// This is the function that moves the rotors for each iteration.
	public void moveRotors(){
		// If one of the rotors should move.
		if(this.rotors[2].isTurnOverNotch() || this.rotors[1].isTurnOverNotch()){
			// Move the rotor if needed.
			if(this.rotors[1].isTurnOverNotch())
				this.rotors[0].advanceOffset();
			this.rotors[1].advanceOffset();
			
		}
		
		this.rotors[2].advanceOffset();
		
	}
	
	// The function that makes the decryption or the encryption.
	public List<Character> encryptOrDecrypt(List<Character> word){
		
		List<Character> encrypted = new ArrayList<Character>();
		StringBuilder st = new StringBuilder();
		String config;
		for(Character c: word){
			
			st.append(c);
			
		}
		
		config = st.toString(); 
		config = config.replaceAll("\\s", "");
		
		// A loop to decrypt each letter through the plugboard, rotors and reflector.
		for(int i = 0; i < config.length(); i++){
			char letter = config.charAt(i);
			
			this.moveRotors();
			char translatedLetter = this.plugBoard.forwardTranslation(Character.toUpperCase(letter));
			
			int firstRotor = this.rotors[2].encryptedLetter(translatedLetter);

			int secondRotor = this.rotors[1].encryptedLetter((char)((int)'A' + firstRotor));

			int thirdRotor = this.rotors[0].encryptedLetter((char)((int)'A' + secondRotor));
			
			char reflected = this.reflector.forwardTranslation((char)((int)'A' + thirdRotor));
			
			firstRotor = this.rotors[0].decryptedLetter(reflected);
			
			secondRotor = this.rotors[1].decryptedLetter((char)((int)'A' + firstRotor));

			thirdRotor = this.rotors[2].decryptedLetter((char)((int)'A' + secondRotor));			
			
			translatedLetter = this.plugBoard.forwardTranslation((char)((int)'A' + thirdRotor));
			
			encrypted.add(translatedLetter);
			
		}
		
		return encrypted;
		
	}

	@Override
	public char forwardTranslation(char permutation) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public char reverseTranslation(char permutation) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}

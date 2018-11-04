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
	
	public void moveRotors(){
		
		if(this.rotors[2].isTurnOverNotch() || this.rotors[1].isTurnOverNotch()){
			
			if(this.rotors[1].isTurnOverNotch())
				this.rotors[0].advanceOffset();
			this.rotors[1].advanceOffset();
			
		}
		
		this.rotors[2].advanceOffset();
		
	}
	
	public List<Character> encryptOrDecrypt(List<Character> word){
		
		List<Character> encrypted = new ArrayList<Character>();
		
		for(char letter: word){
			
			this.moveRotors();
			System.out.println("The letter in: " + letter);
			char translatedLetter = this.plugBoard.forwardTranslation(Character.toUpperCase(letter));
			System.out.println("Before Trans let: " + translatedLetter);
			
			int firstRotor = this.rotors[2].encryptedLetter(translatedLetter);
			System.out.println("1First rotor: " + (char)((int)'A' + firstRotor));

			int secondRotor = this.rotors[1].encryptedLetter((char)((int)'A' + firstRotor));
			System.out.println("1Second rotor: " + (char)((int)'A' + secondRotor));

			int thirdRotor = this.rotors[0].encryptedLetter((char)((int)'A' + secondRotor));
			System.out.println("1Third rotor: " + (char)((int)'A' + thirdRotor));

			
			char reflected = this.reflector.forwardTranslation((char)((int)'A' + thirdRotor));
			
			firstRotor = this.rotors[0].decryptedLetter(reflected);
			System.out.println("2First rotor: " + (char)((int)'A' + firstRotor));
			
			secondRotor = this.rotors[1].decryptedLetter((char)((int)'A' + firstRotor));
			System.out.println("2Second rotor: " + (char)((int)'A' + secondRotor));

			thirdRotor = this.rotors[2].decryptedLetter((char)((int)'A' + secondRotor));
			System.out.println("2Third rotor: " + (char)((int)'A' + thirdRotor));
			
			
			translatedLetter = this.plugBoard.forwardTranslation((char)((int)'A' + thirdRotor));
			System.out.println("Trans let: " + translatedLetter);
			
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

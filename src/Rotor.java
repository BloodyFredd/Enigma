import java.util.List;


public class Rotor extends Translator {

	private int ringOffset;
	private int ringSetting;
	private int notch;
	
	Rotor(int ringOffset, int ringSetting, List<Character> permutation, int notch) {
		
		super(permutation);
        this.ringOffset = ringOffset;
        this.ringSetting = ringSetting;
        this.notch = notch;
		
	}
	
	// The function to encrypt each letter.
	public int encryptedLetter(char letter){
		
		int rightShift = this.rightCircularShift(this.letterToIndex(letter), this.ringOffset - 1);

		int leftShift = this.leftCircularShift(rightShift, this.ringSetting - 1);

		char translated = this.forwardTranslation((char)((int)'A' + leftShift));
		
		return this.rightCircularShift(this.letterToIndex(translated), this.ringSetting - 1 - (this.ringOffset - 1));
		
	}
	
	// The function to decrypt each letter.
	public int decryptedLetter(char letter){
		
		int rightShift = this.rightCircularShift(this.letterToIndex(letter), this.ringOffset - 1);

		int leftShift = this.leftCircularShift(rightShift, this.ringSetting - 1);

		char translated = this.reverseTranslation((char)((int)'A' + leftShift));

		return this.rightCircularShift(this.letterToIndex(translated), this.ringSetting - 1 - (this.ringOffset - 1));
		
	}
	
	// If the rotor is at the end and should move.
	public boolean isTurnOverNotch(){
		
		return this.ringOffset == this.notch;
		
	}
	
	// Move the offset of the rotor.
	public void advanceOffset(){
		
		this.ringOffset = this.rightCircularShift(this.ringOffset, 1);
		
	}

}

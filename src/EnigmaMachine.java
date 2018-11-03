import java.util.ArrayList;
import java.util.List;


public class EnigmaMachine {

	public static void main(String[] args) {
		
		Rotor rotor1 = new Rotor(19,3,makeList("EKMFLGDQVZNTOWYHXUSPAIBRCJ"),17);
		Rotor rotor2 = new Rotor(3,19,makeList("AJDKSIRUXBLHWTMCQGZNPYFVOE"),5);
		Rotor rotor3 = new Rotor(25,1,makeList("BDFHJLCPRTXVZNYEIWGAKMUSQO"),22);
		Rotor rotor4 = new Rotor(14,24,makeList("ESOVPZJAYQUIRHXLNFTGKDCMWB"),10);
		Rotor rotor5 = new Rotor(15,9,makeList("VZBRGITYUPSDNHLXAWMJQOFECK"),26);
		
		Reflector reflector = new Reflector(makeList("YRUHQSLDPXNGOKMIEBFZCWVJAT"));
		
		PlugBoard plugBoard = new PlugBoard(makeList("ZU HL CQ WM OA PY EB TR DN VI"));

		Rotor rotors[] = new Rotor[3];
		rotors[0] = rotor1;
		rotors[1] = rotor2;
		rotors[2] = rotor3;
		
		Enigma enigmaMachine = new Enigma(rotors, reflector, plugBoard);
		
		System.out.println(enigmaMachine.encryptOrDecrypt(makeList("CON")));
		
	}
	
	public static List<Character> makeList(String str){
		
		List<Character> list = new ArrayList<Character>();
		for(char c: str.toCharArray())
			list.add(c);
		return list;
		
	}

}

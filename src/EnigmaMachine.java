import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class EnigmaMachine {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String rot1, rot2, rot3, plug, ringSet1, ringSet2, ringSet3, ringOff1, ringOff2, ringOff3;
		int tmp = 0, rotor1, rotor2, rotor3;
		
		System.out.println("Welcome to the Enigma M3.");
		System.out.println("Please choose which three rotors you would like to use: (1-5)");
		
		do{
			System.out.println("Please choose the first rotor:");
			rot1 = sc.nextLine();
			try {
			tmp = Integer.parseInt(rot1);
			} catch (NumberFormatException e) {
				System.out.println("Not a good choise, I'll take rotor 1 for you.");
				rotor1 = 1;
				tmp = 1;
				continue;
				}
			rotor1 = tmp;
			
		}while(tmp < 0 || tmp > 5);
		
		tmp = 0;
		
		do{
			System.out.println("Please choose the second rotor: (should be different than the first one)");
			rot2 = sc.nextLine();
			try {
			tmp = Integer.parseInt(rot2);
		} catch (NumberFormatException e) {
			System.out.println("Not a good choise, I'll take rotor 2 for you.");
			rotor2 = 2;
			tmp = 2;
			continue;
			}
		rotor2 = tmp;
			
		}while(tmp < 0 || tmp > 5 || tmp == Integer.parseInt(rot1));
		
		tmp = 0;
		
		do{
			System.out.println("Please choose the third rotor: (should be different than the first and the second)");
			rot3 = sc.nextLine();
			try {
			tmp = Integer.parseInt(rot3);
		} catch (NumberFormatException e) {
			System.out.println("Not a good choise, I'll take rotor 3 for you.");
			rotor3 = 3;
			tmp = 3;
			continue;
			}
		rotor3 = tmp;
			
		}while(tmp < 0 || tmp > 5 || tmp == Integer.parseInt(rot2) || tmp == Integer.parseInt(rot1));
		
		tmp = 0;
		
		System.out.println("Please choose the ring setting: (A-Z)");
		
		do{
			System.out.println("Please choose the ring setting for the first rotor:");
			ringSet1 = sc.nextLine();
			
		}while(ringSet1.charAt(0) < 'A' || ringSet1.charAt(0) > 'Z' || ringSet1.length() != 1);
		
		do{
			System.out.println("Please choose the ring setting for the second rotor:");
			ringSet2 = sc.nextLine();
			
		}while(ringSet1.charAt(0) < 'A' || ringSet2.charAt(0) > 'Z' || ringSet2.length() != 1);
		
		do{
			System.out.println("Please choose the ring setting for the third rotor:");
			ringSet3 = sc.nextLine();
			
		}while(ringSet3.charAt(0) < 'A' || ringSet3.charAt(0) > 'Z' || ringSet3.length() != 1);
		
		System.out.println("Please choose the ring offsets: (A-Z)");
		
		do{
			System.out.println("Please choose the ring offset for the first rotor:");
			ringOff1 = sc.nextLine();
			
		}while(ringOff1.charAt(0) < 'A' || ringOff1.charAt(0) > 'Z' || ringOff1.length() != 1);
		
		do{
			System.out.println("Please choose the ring offset for the second rotor:");
			ringOff2 = sc.nextLine();
			
		}while(ringOff1.charAt(0) < 'A' || ringOff2.charAt(0) > 'Z' || ringOff2.length() != 1);
		
		do{
			System.out.println("Please choose the ring offset for the third rotor:");
			ringOff3 = sc.nextLine();
			
		}while(ringOff3.charAt(0) < 'A' || ringOff3.charAt(0) > 'Z' || ringOff3.length() != 1);
		
		Rotor rotr1 = new Rotor(6, 1, makeList("EKMFLGDQVZNTOWYHXUSPAIBRCJ"), 17);
		Rotor rotr2 = new Rotor(4, 1, makeList("AJDKSIRUXBLHWTMCQGZNPYFVOE"), 5);
		Rotor rotr3 = new Rotor(22, 1, makeList("BDFHJLCPRTXVZNYEIWGAKMUSQO"), 22);
		Rotor rotr4 = new Rotor(14, 24, makeList("SOVPZJAYQUIRHXLNFTGKDCMWB"), 10);
		Rotor rotr5 = new Rotor(15, 9, makeList("VZBRGITYUPSDNHLXAWMJQOFECK"), 26);
		
		Reflector reflector = new Reflector(makeList("YRUHQSLDPXNGOKMIEBFZCWVJAT"));
		
		PlugBoard plugBoard = new PlugBoard(makeList(""));

		Rotor rotors[] = new Rotor[3];
		rotors[0] = rotr1;
		rotors[1] = rotr2;
		rotors[2] = rotr3;
		
		Enigma enigmaMachine = new Enigma(rotors, reflector, plugBoard);
		
		System.out.println(enigmaMachine.encryptOrDecrypt(makeList("ENIGMA")));
		
	}
	
	public static List<Character> makeList(String str){
		
		List<Character> list = new ArrayList<Character>();

		if(str.length() == 0) {
			return list;
		
		}
		
		for(char c: str.toCharArray())
			list.add(c);
		return list;
		
	}

}

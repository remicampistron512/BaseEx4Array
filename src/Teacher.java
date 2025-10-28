import java.util.Scanner;
import java.util.HashMap;


public class Teacher {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Saisir le prenom de l'élève");
		
		HashMap<String, String> listeEtudiants = new HashMap<String, String>();
		
		while (scan.hasNextLine()) {
			// initialise un objet scanner, et utilisation de newline pour éviter un bug si on avait utilisé next() 
			
			
			String firstName = scan.nextLine();
			
			System.out.println("Saisir le nom de l'élève");
			String lastName = scan.nextLine();
			
			System.out.println("Saisir les notes de l'élève chacune séparée d'un espace");		
			String gradesString = scan.nextLine();
			
			String[] gradesStringArray = {};
			int averageGrade = 0;
			
			if(gradesString != null && !gradesString.trim().isEmpty()) {
				gradesStringArray = gradesString.split(" ");		
			
				int[] gradesIntArray = new int[gradesStringArray.length];
				
				for(int i =0;i<gradesStringArray.length;i++) {
					 gradesIntArray[i] = Integer.parseInt(gradesStringArray[i]);
					 System.out.println(gradesStringArray[i]);
				}
				 averageGrade = BaseEx4Array.averageGrade(gradesIntArray);
			 }
			 
			 
			 System.out.println(firstName + " " + lastName + ". moyenne : " +  averageGrade);
			 
			 System.out.println("Voulez-vous rentrer les details d'un autre éleve ? Oui / Non");
			 
			 String completeName = firstName + " " + lastName;
			 
			 listeEtudiants.put(completeName, gradesString);
			 
			
			 
			 String proceedToNextStudent = scan.nextLine();
			 
			 if(proceedToNextStudent.equals("o") || proceedToNextStudent.equals("Oui")  || proceedToNextStudent.equals("oui")) {
				 System.out.println("Saisir le prenom de l'élève");
				 continue;
			 } else {
				 System.out.println("Voici la liste des étudiants");
				// Print keys and values
				 for (String i : listeEtudiants.keySet()) {
				   System.out.println("key: " + i + " value: " + listeEtudiants.get(i));
				 }
				 break;
			 }
		 }
			 
	}

}

import java.util.*;

public class Teacher {

	public static void main(String[] args) {

		// Initialisations

		int averageGrade = 0;
		String lastName = null;
		String firstName = null;
		HashMap<String, String> studentsList = new HashMap<String, String>();

		String[] fullNames = { "Elise Dubois", "Lucas Martin", "Chloé Lefèvre", "Hugo Bernard", "Camille Moreau",
				"Léa Fontaine", "Thomas Laurent", "Manon Rousseau", "Antoine Petit", "Inès Robert", "Julien Lambert",
				"Zoé Marchand" };
		
		ArrayList<String> extractedFirstNames = extractFirstName(fullNames);
		System.out.println(extractedFirstNames);
		System.out.println(sortAlpha(extractedFirstNames));
		System.out.println(sortReverseAlpha(extractedFirstNames));
		
		
		String[] gradesStr = { "18 14 12", "11 13 15", "7 9 10", "20 17 19", "3 8 6", "15 16 14", "9 12 11", "14 13 15",
				"5 7 4", "19 18 16", "11 10 12", "2 6 5" };

		for (int i = 0; i < fullNames.length; i++) {
			studentsList.put(fullNames[i], gradesStr[i]);
		}

		Scanner scan = new Scanner(System.in);

		System.out.println("Voulez vous saisir un nouvel élève ou voir la liste des élèves (taper 1 ou 2) ");
		String firstActionChoice = scan.nextLine();

		while (true) {
			if (firstActionChoice.equals("1")) {
				

				if (firstName == null) {
					firstName = inputFirstName(scan);
				}
				if (firstName != null && !firstName.trim().isEmpty()) {
					lastName = inputLastName(scan);
				}

				String completeName = firstName + " " + lastName;

				String gradesString = "";
				for (String i : studentsList.keySet()) {
					if (i.equals(completeName)) {
						System.out.println(
								"L'élève est dèjà dans la liste, voulez vous consulter ses notes et sa moyenne ? Oui / Non");
						String proceedToStudentGrades = scan.nextLine();
						if (proceedToStudentGrades.equals("o") || proceedToStudentGrades.equals("O") || proceedToStudentGrades.equals("Oui")
								|| proceedToStudentGrades.equals("oui")) {
							System.out.println("Nom de l'élève : " + i + ". Notes : " + studentsList.get(i)
									+ ". moyenne : " + convertToIntAndAverage(studentsList.get(i)));
						} else {
							gradesString = inputGrades(scan);
							break;
						}
					}
				}

				if (gradesString != null && !gradesString.trim().isEmpty()) {
					// Si la liste des notes existe on transforme le tout en tableau contenant des
					// entiers pour ensuite pouvoir calculer la moyenne
					averageGrade = convertToIntAndAverage(gradesString);
					studentsList.put(completeName, gradesString);
				}

				if (completeName != null && !completeName.trim().isEmpty()) {
					System.out.println("Voulez-vous rentrer les details d'un autre éleve ? Oui / Non");

					String proceedToNextStudent = scan.nextLine();

					if (proceedToNextStudent.equals("o") || proceedToNextStudent.equals("Oui")
							|| proceedToNextStudent.equals("oui")) {
						System.out.println("Saisir le prenom de l'élève");
						continue;
					} else {

						break;
					}
				}
			} else {
				System.out.println("Voici la liste des étudiants");

				for (String i : studentsList.keySet()) {
					System.out.println("Nom de l'élève : " + i + ". Notes : " + studentsList.get(i));
				}
				break;
			}
		}

	}
	
	public static ArrayList<String> extractFirstName(String[] names) {
		
		ArrayList<String> firstNameList = new ArrayList<String>();

		for (int i=0;i<names.length;i++) {
			String[] fullNameArray = names[i].split(" ");
			firstNameList.add(fullNameArray[0]);
		}
		return firstNameList;
	}

	public static ArrayList<String>  sortAlpha(ArrayList<String> firstNameList){
		
		ArrayList<String> sortedFirstNameList = firstNameList;
		
		Collections.sort(sortedFirstNameList);

		return sortedFirstNameList;
	}
	
	
	public static ArrayList<String>  sortReverseAlpha(ArrayList<String> firstNameList){
		
		ArrayList<String> sortedFirstNameList = firstNameList;
		
		sortedFirstNameList.sort(Comparator.reverseOrder());
		
		return sortedFirstNameList;
	}
	public static String inputGrades(Scanner scan) {
		String gradesString;
		System.out.println("Saisir les notes de l'élève chacune séparée d'un espace");
		gradesString = scan.nextLine();
		return gradesString;
	}

	public static String inputLastName(Scanner scan) {
		System.out.println("Saisir le nom de l'élève");
		String lastName = scan.nextLine();
		return lastName;
	}

	public static String inputFirstName(Scanner scan) {
		System.out.println("Saisir le prenom de l'élève");
		String firstName = scan.nextLine();
		return firstName;
	}

	public static int convertToIntAndAverage(String gradesString) {
		String[] gradesStringArray;
		int averageGrade = 0;
		if (gradesString != null && !gradesString.trim().isEmpty()) {
			gradesStringArray = gradesString.split(" ");

			int[] gradesIntArray = new int[gradesStringArray.length];

			for (int i = 0; i < gradesStringArray.length; i++) {
				gradesIntArray[i] = Integer.parseInt(gradesStringArray[i]);

			}
			averageGrade = BaseEx4Array.averageGrade(gradesIntArray);
		}
		return averageGrade;
	}

}

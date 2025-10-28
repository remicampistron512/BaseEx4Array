
public class BaseEx4Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grades[] = {18,13,12,14,8,17,6,4,3,7};
		int highestGrade = 0;
		int lowestGrade = 0;
		int averageGrade = 0;
		averageGrade = averageGrade(grades);
		for (int i=0;i<grades.length;i++) {
			if(isHighestGrade(grades[i],grades)) highestGrade = grades[i];
			if(isLowestGrade(grades[i],grades)) lowestGrade = grades[i];			
		}
		System.out.println("plus haute note : " + highestGrade);
		System.out.println("plus basse note : " + lowestGrade);
		System.out.println("moyenne : " + averageGrade);
	}
	
	public static boolean isHighestGrade(int grade,int grades[]) {
		
		for (int i=0;i<grades.length;i++) {
			if(grade < grades[i]) {
				return false;
			} 
		}
		return true;				
	}
	
	public static int averageGrade (int grades[]) {
		int sumGrades = 0;
		for (int i=0;i<grades.length;i++) {
			sumGrades += grades[i];
		}
		return sumGrades / grades.length;
	}
	
	public static boolean isLowestGrade(int grade,int grades[]) {
		for (int i=0;i<grades.length;i++) {
			if(grade > grades[i]) {
				return false;
			} 
		}
		return true;	
	}
}

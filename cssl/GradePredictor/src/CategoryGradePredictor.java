import java.util.List;


public class CategoryGradePredictor {

	private static List<Integer> ans1;
	private static int per1;
	
	public CategoryGradePredictor(List<Integer> x, int y)
	{
		x = ans1;
		y = per1;
	}
	public double calculateCategoryGrade()
	{
		int sum = 0;
		for(int i = 0; i < ans1.size(); i++)
		{
			sum += ans1.get(i);
		}
		int grade = sum/(ans1.size());
		double cgrade = grade*(per1/100);
		return cgrade;
	}
}

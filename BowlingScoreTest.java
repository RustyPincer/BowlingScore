import org.junit.*;
import static org.junit.Assert.*;

public class BowlingScoreTest{
	@Test
	public void getScorePoints(){
		String str = "x x x x x x x x x x x x";
		int points = BowlingScore.getScore(str);

		String str1 = "11 11 11 11 11 11 11 11 11 11";
		int points1 = BowlingScore.getScore(str1);

		String str2 = "x x x 1/ x x 11 1/ 11 11";
		int points2 = BowlingScore.getScore(str2);

		assertTrue(points == 300);
		assertTrue(points1 == 20);
		assertTrue(points2 == 141);
	}
}
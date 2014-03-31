import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;


public class configuration {
//[0][x] refers to the piece images as listed in the reference image
//[1][x] refers to the orientation (0,1,2,3) indicating number of clockwise turns from correct orientation 
int[][] pieces;
double score;

//makes a configuration with random numbers from 0 to maxValue
public configuration(int length, int maxValue)
{
	pieces=new int[2][length];
	for(int x=0;x<pieces[0].length;x++)
	{
		pieces[0][x]=(int)(Math.random()*maxValue);
		pieces[1][x]=0;
	}
}
//makes a configuration using every value from list exactly once
public configuration(int[] list)
{
	pieces=new int[2][list.length];
	ArrayList<Integer> alist=new ArrayList<Integer>();
	for(int x=0;x<list.length;x++)
	{
		alist.add(list[x]);
	}
	for(int x=0;x<list.length;x++)
	{
		pieces[0][x]=alist.remove((int)(Math.random()*alist.size()));
		pieces[1][x]=0;
	}
}
//just sets pieces equal to list
public configuration(int[][] list)
{
	pieces=list;
}

//creates a child with mate
configuration procreateWith(configuration mate, int min, int max, double mutationRate) 
{
	if (pieces.length != mate.getPieces().length) {
		throw new IllegalArgumentException("The list sizes must be equal.");
	}
	int[][] child = new int[2][pieces.length];
	Random rng = new Random();

	for (int i = 0; i < pieces.length; i++) {
		if (rng.nextDouble() < mutationRate) {
			child[0][i] = rng.nextInt(max - min) - min;
		} else if (rng.nextDouble() < 0.5) {
			child[0][i] = pieces[0][i];
		} else {
			child[0][i] = mate.getPieces()[0][i];
		}
		child[1][i]=0;
	}
	return new configuration(child);
}

//scores the configuration in wrt the reference image
public void score(BufferedImage[] pieceImgList)
{
	//TODO: actually write this!!!
	score=0;
}
//scores the configuration in wrt the reference image average colors
//score is equal to the negative sum distance of every piece's average color to the correct average color
public void score(vector[] pieceAveList)
{
	double sum=0;
	for(int x=0;x<pieces[0].length;x++)
	{
		sum+=pieceAveList[x].minus(pieceAveList[pieces[0][x]]).magnitude();
	}
	score=-sum;
}









public int[][] getPieces() {
	return pieces;
}
public void setPieces(int[][] pieces) {
	this.pieces = pieces;
}
public double getScore() {
	return score;
}

}

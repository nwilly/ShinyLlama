import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


public class main {
BufferedImage reference;//this is the full reference image
String referencePath="src/320px-Toronto_Reference_Library_atrium.jpg";//path to reference image

int pieceSize=16;//pixel size of pieces (squares)
BufferedImage[] pieceImgList;//list of all piece images ordered upper left corner going along the rows
vector[] pieceAveList;//list of all piece average colors (in same order)

public main()
{
	reference = null;
	try {
	    reference = ImageIO.read(new File(referencePath));
	} catch (IOException e) {
		System.err.println("didn't find the image yo!");
	}
	
	//create pieces images
	int numPieces=(reference.getWidth()/pieceSize)*(reference.getHeight()/pieceSize);
	pieceImgList=new BufferedImage[numPieces];
	
	int index=0;
	for(int y=0;y<reference.getHeight()-1;y+=pieceSize)
	{
		for(int x=0;x<reference.getWidth()-1;x+=pieceSize)
		{
			pieceImgList[index]=reference.getSubimage(x, y, pieceSize, pieceSize);
		}
	}
	
	//find average colors of pieces
	pieceAveList=new vector[pieceImgList.length];
	for(int x=0;x<pieceImgList.length;x++)
	{
		pieceAveList[x]=average(pieceImgList[x]);
	}
}
//returns the average color (r,g,b) of the given image
public vector average(BufferedImage i)
{
	vector v=new vector();
	for(int x=0;x<i.getWidth();x++)
	{
		for(int y=0;y<i.getHeight();y++)
		{
			Color c=new Color(i.getRGB(x, y));
			v.add(new vector(c.getRed(),c.getGreen(),c.getBlue()));
		}
	}
	v.mult(1/(i.getHeight()*i.getWidth()));
	return v;
}
public static void main(String[] args)
{
	main m=new main();
}
}

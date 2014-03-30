public class vector {
	private double x;
	private double y;
	private double z;
	
	public vector(double dir)
	{
		x=(double) (Math.cos(dir));
		y=(double) (Math.sin(dir));
	}
	public vector()
	{
		x=0;y=0;z=0;
	}
	public vector(double posx,double posy,double posz)
	{
		x=posx;
		y=posy;
		z=posz;
	}
	public vector add(vector v)
	{
		vector result=new vector(this.x+v.x,this.y+v.y,this.z+v.z);
		return result;
	}
	public vector minus(vector v)
	{
		vector result=new vector(this.x-v.x,this.y-v.y,this.z-v.z);
		return result;
	}
	public vector mult(double c)
	{
		vector result=new vector(this.x*c,this.y*c,this.z*c);
		return result;
	}
	public vector cross(vector v)
	{		
		return new vector(this.y*v.z-this.z*v.y,-(this.x*v.z-this.z*v.x),this.x*v.y-this.y*v.x);
	}
	public double dot(vector v)
	{
		return this.x*v.x+this.y*v.y+this.z*v.z;
	}
	public double magnitude()
	{
		return (double) Math.sqrt(this.x*this.x+this.y*this.y+this.z*this.z);
	}
	public vector unit()
	{
		return this.mult(1/this.magnitude());
	}
	public String print()
	{
		System.out.println(this.x+","+this.y+","+this.z);
		return this.x+","+this.y;
	}
	public String print2()
	{
		//System.out.println(this.x+","+this.y);
		return this.x+","+this.y+","+this.z;
	}
	public double posdirection()
	{
		return (double) Math.atan(this.y/this.x);
	}
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	
}

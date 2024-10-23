interface Shape
{
	abstract public String shape();
	abstract public int number();
	abstract double area();
}

class Circle implements Shape
{
	int radius;

	Circle(int x)
	{
		radius = x;
	}

	public String shape()
	{
		return "Circle";
	}

	public int number()
	{
		return 0;
	}

	public double area()
	{
		return 3.14159 * radius * radius;
	}
}

abstract class Quadilateral implements Shape
{
	public String shape()
	{
		return "Quadilateral";
	};

	public int number()
	{
		return 4;
	}

	abstract public double area();
}

class Square extends Quadilateral
{
	int side;

	Square(int s)
	{
		side = s;
	}

	public String shape()
	{
		return "Square";
	}

	public int number()
	{
		return 4;
	}

	public double area()
	{
		return (double)side * (double)side;
	}
}

class Rectangle extends Quadilateral
{
	int length, breadth;

	Rectangle(int l, int b)
	{
		length = l;
		breadth = b;
	}

	public String shape()
	{
		return "Rectangle";	
	}

	public double area()
	{
		return 2.0 * (length + breadth);
	}
}

abstract class Triangle implements Shape
{
	int side1, side2, side3;

	Triangle(int x, int y, int z)
	{
		side1 = x;
		side2 = y;
		side3 = z;
	}

	public String shape()
	{
		return "Triangle";
	}

	public int number()
	{
		return 3;
	}

	abstract public double area();
}

class Equilateral extends Triangle
{
	Equilateral(int s1, int s2, int s3)
	{
		super(s1, s2, s3);
	}

	public String shape()
	{
		return "Equilateral Triangle";
	}

	public double area()
	{
		return (Math.sqrt(3) * side1 * side1) / 4.0;
	}
}

class Isoscles extends Triangle
{
	Isoscles(int s1, int s2, int s3)
	{
		super(s1, s2, s3);
	}

	public String shape()
	{
		return "Isoscles Triangle";
	}

	public double area()
	{
		return 0.5 * side2 * Math.sqrt(side1 * side1 - side2 * side2 / 4.0);
	}
}

class Scalene extends Triangle
{
	Scalene(int s1, int s2, int s3)
	{
		super(s1, s2, s3);
	}

	public String shape()
	{
		return "Scalene Triangle";
	}

	public double area()
	{
		double s = (side1 + side2 + side3) / 2.0;
		return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
	}
}






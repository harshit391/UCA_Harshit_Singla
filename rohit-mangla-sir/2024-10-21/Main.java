public class Main 
{
    public static void main(String[] args) 
    {
        Shape s = new Square(5);
        Shape r = new Rectangle(5, 10);
        
        System.out.println("Area of Square: " + s.area());
        System.out.println("Area of Rectangle: " + r.area());    
    }    
}

import java.util.function.*;

public class PredicateExp
{
    public static void main(String[] args)
    {
        // Basically Works as a Boolean Functions

        // You can pass a value and Then Add the Logic in Predicate

        // Like This Predicate will return boolean value according to given number is even or not even
        Predicate<Integer> predicate = (p1) -> {
            
            return (p1&1) == 0;
        };

        
        System.out.println(predicate.test(2));
        System.out.println(predicate.test(3));
        System.out.println(predicate.test(124312));
    }
}

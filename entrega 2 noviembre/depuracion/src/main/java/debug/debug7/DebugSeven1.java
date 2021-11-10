package debug.debug7;

// Makes String comparisons
public class DebugSeven1
{

    public static final String ROGER = "Roger";

    public static void main(String[] args)
    {
        String name1 = ROGER;
        String name2 = ROGER;
        String name3 = "Stacy";

        if(name1.equals(name2))
            System.out.println(name1 + " and " + name2 +
                    " are the same");
        if(name1.equals(name3))
            System.out.println(name1 + " and " + name3 +
                    " are the same");
        if(name1.equals("roger"))
            System.out.println(name1 + " and 'roger' are the same");
        if(name1.equals(ROGER))
            System.out.println(name1 + " and 'Roger' are the same");
    }
}


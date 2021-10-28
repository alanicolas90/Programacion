package main_principal;

public class Dibujitos {


    public static void extracted(int intentosRestantes) {
        switch (intentosRestantes) {
            case 8:
                System.out.println(" ___________\n |         \n |\n |\n |\n |\n/ \\");
                break;
            case 7:
                System.out.println(" ___________\n |         |\n |\n |\n |\n |\n/ \\");
                break;
            case 6:
                System.out.println(" ___________\n |         |\n |        ( )\n |\n |\n |\n/ \\");
                break;
            case 5:
                System.out.println(" ___________\n |         |\n |        ( )\n |         |\n |\n |\n/ \\");
                break;
            case 4:
                System.out.println(" ___________\n |         |\n |        ( )\n |        /|\n |\n |\n/ \\");
                break;
            case 3:
                System.out.println(" ___________\n |         |\n |        ( )\n |        /|\\ \n |\n |\n/ \\");
                break;
            case 2:
                System.out.println(" ___________\n |         |\n |        ( )\n |        /|\\ \n |        /\n |\n/ \\");
                break;
            case 1:
                System.out.println(" ___________\n |         |\n |        ( )\n |        /|\\ \n |        / \\ \n |\n/ \\");
                break;
            default:
                break;
        }
    }
}
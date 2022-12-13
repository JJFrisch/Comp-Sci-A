import java.util.Scanner;
import java.util.Random;
public class CharacterPrinter {
    public static void main(String[] args) {

        String name = "lool";
        int a = 5;
        int b = a;

        System.out.println(b);


//        var("l", [1. 2])
//        var("tyt");
//        intro();
//        var("l", [1, 2, 3]);
//        l += 1;
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter an adjective: ");
        String adjective = userInput.nextLine();
        System.out.print("Enter a noun: ");
        String noun = userInput.nextLine();
        System.out.print("Enter an animal: ");
        String animal = userInput.nextLine();
        System.out.print("Enter a sound: ");
        String sound = userInput.nextLine();
        printMadLib(adjective, noun, animal, sound);
    }
    public static void var(String name){
        System.out.println(name);

    }
    public static void var(String name, Object new_var){

        System.out.println(new_var);

    }


    public static void intro(){
        System.out.println("Welcome to MadLibs!");
    }

    public static void printMadLib(String adjective, String noun, String animal, String noise){
        System.out.println(adjective + " Macdonald had a " + noun + ", E-I-E-I-O");
        System.out.println("and on that " + noun + " he had an " + animal + ", E-I-E-I-O");
        System.out.println("with a " + noise + " " + noise + " here");
        System.out.println("and a " + noise + " " + noise + " there,");
        System.out.println("here a " + noise + ", there a " + noise + ",");
        System.out.println("everywhere a " + noise + " " + noise + ",");
        System.out.println(adjective + " Macdonald had a " + noun + ", E-I-E-I-O.");
    }

}
class Dog {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
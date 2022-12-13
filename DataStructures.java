import java.util.LinkedList;
import java.util.*;

public class DataStructures {
    public static void main(String[] args) {
        paladrome("tacocat");



    }

    public static boolean paladrome(String word) {
        System.out.println("Is '" + word + "' a paladrome?");
        Stack word_ = new Stack();
        String reversedWord = "";

        for (int i = 0; i < word.length(); i++){
            word_.push(word.charAt(i));
        }
        while (word_.isEmpty() == false){
            reversedWord = reversedWord + word_.pop();
        }
        if(word.equals(reversedWord)){
            System.out.println("Yes");
            return true;
        }
        else{
            System.out.println("No");
            return false;
        }

    }

    public void students() {
        LinkedList<String> students = new LinkedList<>();
        students.add("Allison");
        students.add("Luke");
        students.add("Mo");
        students.add("Ruth");

        System.out.println("Roster : " + students);

        students.add(2, "JoJo");

        System.out.println("Student at index 2 : " + students.get(2));

        students.remove("JoJo");
        System.out.println("Student at index 2 : " + students.get(2));

        students.clear();
    }
}
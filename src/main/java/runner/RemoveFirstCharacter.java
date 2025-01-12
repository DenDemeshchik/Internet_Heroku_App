package runner;
import java.util.ArrayList;
import java.util.List;

// Remove the first character from the first 5 elements of the list

    public class RemoveFirstCharacter {
        public static void main(String[] args) {

            // Create a list with example strings

            List<String> strings = new ArrayList<>();
            strings.add("apple");
            strings.add("banana");
            strings.add("cherry");
            strings.add("date");
            strings.add("elderberry");
            strings.add("fig");
            strings.add("grape");

            for (int i = 0; i < strings.size() && i < 5; i++) {
                String original = strings.get(i);
                if (original.length() > 0) {
                    strings.set(i, original.substring(1)); // Delete the first character
                }
            }

            // Display the modified list
            System.out.println(strings);
        }
    }

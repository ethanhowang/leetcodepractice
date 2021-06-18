/*
This problem focuses on creating a list of all combinations of letters given
a string of digits from 2-9, with each number associated with 3 or more strings.
Based on the string, this function would return an ArrayList of all the possible
letter combinations consisting of the associated numbers from our given string
*/

import java.util.*;

class LetterPhone {
    public List<String> letterCombinations(String digits) {
        // take in digits
        // parse first digit, split into 3 letters, find all combinations for each letter, recursively
        // parameters: current list, more numbers to add, dictionary of digit to letters mappings
        // return value: whole list of strings based on digits
        Hashtable<Character, String> my_dict = new Hashtable<Character, String>();
        my_dict.put('2', "abc");
        my_dict.put('3', "def");
        my_dict.put('4', "ghi");
        my_dict.put('5', "jkl");
        my_dict.put('6', "mno");
        my_dict.put('7', "pqrs");
        my_dict.put('8', "tuv");
        my_dict.put('9', "wxyz");
        
        return find(my_dict, digits, new ArrayList<String>());
        
        
    }
    
    public ArrayList<String> find(Hashtable<Character, String> dictionary, String digits, ArrayList<String> current) {
        // System.out.println(dictionary);
        if (digits.equals("")) {
            System.out.println("okay");
            return new ArrayList<String>();
        }
        String elem = dictionary.get(digits.charAt(0));
        // System.out.println(dictionary.get(digits.charAt(0)));

        for (int i = 0; i < elem.length(); i++) {
            System.out.println(elem.charAt(i));
            if (find(dictionary, digits.substring(1), current).isEmpty()) {
                current.add(String.valueOf(elem.charAt(i)));
            } else {
                for (String j : find(dictionary, digits.substring(1), current)) {
                    // System.out.println(find(dictionary, digits.substring(1), current));
                    current.add(String.valueOf(elem.charAt(i)) + j);
                }

            }
        }

        return current;
        
    }

    public static void main(String[] args) {
        LetterPhone test = new LetterPhone();
        System.out.println(test.letterCombinations("23"));

    }
}
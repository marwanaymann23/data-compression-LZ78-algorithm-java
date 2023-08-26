import java.util.ArrayList;
import java.util.Scanner;

public class LZ78 {
    
    static ArrayList<Tag> tags = new ArrayList<Tag>();
    static ArrayList<int[]> dictionary = new ArrayList<int[]>();
    
    static int[] stringToAscii(String input) {
        int[] arr = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            arr[i] = (int)input.charAt(i);
        }
        return arr;
    }
    
    static String asciiToString(int[] arr) {
        String ascii = "";
        for (int i = 0; i < arr.length; i++) {
            ascii+= Character.toString((char)arr[i]);
        }
        return ascii;
    }
    
    static int getIndex(String text) {
        for(int i = 0; i < dictionary.size(); i++) {
            if(text.equals(asciiToString(dictionary.get(i)))) {
                return i;
            }
        }
        return 0;
    }
    
    public static void compress() {
        int[] arr = {0};
        boolean added = false;
        dictionary.add(arr);
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string you wish to compress.");
        String text = scanner.next();
        scanner.close();
        
        for(int i = 0; i < text.length(); i++) {
        	String temp = Character.toString(text.charAt(i));
            added = false;
            for (int j = i; j < text.length(); j++) {
                if (added) {
                    break;
                }
                for(int k = 0; k < dictionary.size(); k++) {
                    if (added) {
                        break;
                    }
                    if(temp.equals(asciiToString(dictionary.get(k)))){
                    	if(j == text.length() - 1) {
                    		
                    	}
                    	else {
                    		temp += Character.toString(text.charAt(j+1));
                            break;
                    	}
                    	
                    }
                    else if(k == dictionary.size() - 1) {
                        dictionary.add(stringToAscii(temp));
                        if (j - i == 0) {
                            tags.add(new Tag(0, (int)text.charAt(i)));
                            added = true;
                        }
                        else {
                            tags.add(new Tag(getIndex(text.substring(i, j)), (int)text.charAt(j)));
                            i = j;
                            added = true;
                        }
                    }
                }
            }    
        }
        System.out.println("Tags");
        for(int i = 0; i < tags.size(); i++) {
            System.out.println(i + 1 + "- <" + tags.get(i).index + ", " + tags.get(i).ascii + ">");
        }
    }

    
    public static void main(String[] args) {
        compress();
    }

}
//ABAABABAABABBBBBBBBBBA
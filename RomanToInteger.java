import java.util.ArrayList;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = args[0];
        char prevChar;
        int result = 0;
        ArrayList<Character> romanNumerals = new ArrayList<>();
        romanNumerals.add('I');
        romanNumerals.add('V');
        romanNumerals.add('X');
        romanNumerals.add('L');
        romanNumerals.add('C');
        romanNumerals.add('D');
        romanNumerals.add('M');
        int[] romanToIntList = {1, 5, 10, 50, 100, 500, 1000};

        result += romanToIntList[romanNumerals.indexOf(s.charAt(s.length()-1))];
        prevChar = s.charAt(s.length()-1);
        for(int i = s.length()-2; i >= 0 ; --i) {
            if(s.charAt(i) == 'I') {
                if(prevChar == 'X' || prevChar == 'V') {
                    --result;//subtract 1
                } else {
                    ++result;
                }
            } else if (s.charAt(i) == 'X') {
                if(prevChar == 'L' || prevChar == 'C') {
                    result -= 10;
                } else {
                    result += 10;
                }
            } else if (s.charAt(i) == 'C') {
                if(prevChar == 'D' || prevChar == 'M' ) {
                    result -= 100;
                } else {
                    result += 100;
                }
            } else {
                result += romanToIntList[romanNumerals.indexOf(s.charAt(i))];
            }
            prevChar = s.charAt(i);
        }
        System.out.println(result);
    }
}

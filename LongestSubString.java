public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int substr_index;//index of first character of substring
        int substr_len = 0;
        int max_substr_len = 0;
        int s_length = s.length();//did this to save time ? idk
        int pos; //position in substring

        if (s_length == 0 || s_length == 1) return s_length;

        substr_index = 0;//init start of substr as first char of string
        substr_len = 1;
        for (int i = 1; i < s_length; ++i) {

            pos = 1;//position in substring
            //substring test
            for(int j = substr_index; j < i; ++j) {//we chose i because (we go from substring to i-1(right before the current character))
                
                if(s.charAt(i) == s.charAt(j)) {
                    substr_index = j + 1;
                    substr_len -= pos;
                    break;
                }
                ++pos;//go to next position
                
            }
            ++substr_len;
            //here is final length of current substring
            max_substr_len = (max_substr_len < substr_len) ? substr_len : max_substr_len;
        }
        return max_substr_len;
    }
}
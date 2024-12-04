package Problems;

public class Q2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        int index = 0;
        for(char c: str1.toCharArray()) {
            if(c == str2.charAt(index) || c + 1 == str2.charAt(index) || (c == 'z' && str2.charAt(index) == 'a')) {
                index++;
            }
            if(index == str2.length()) {
                return true;
            }
        }
        return false;
    }
}

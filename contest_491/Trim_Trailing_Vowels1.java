package contest_491;

// 🎯 Rule Simple Hai

// Leading vowels → start wale

// Trailing vowels → end wale

public class Trim_Trailing_Vowels1 {
    public static void main(String[] args){
        String s = "aeioudaeiou";
        String ans = trimhelper(s);
        System.out.println(ans);
    }
    public static String trimhelper(String s){
        int n = s.length();
        int i = n - 1;
        while (i >= 0 && isVowel(s.charAt(i))) {
            i--;
        }
        return s.substring(0,i+1);
    }
    public static boolean isVowel(char ch){
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            return true;
        }
        return false;
    }
}

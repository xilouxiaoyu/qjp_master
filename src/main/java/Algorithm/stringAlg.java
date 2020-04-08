package Algorithm;

public class stringAlg {

    //无重复字符的最长子串
    public static int maxLength(String s){
        if(s.length()==0){
            return 0;
        }else {
            String s1;
            s1 = s.charAt(0) + "" ;
            int max = 0;

            for(int i = 0; i < s.length(); i++){
                if(s1.indexOf(s.charAt(i)) == -1){
                    s1 = s1 + s.charAt(i);
                }else {
                    s1 = s1.substring(s1.indexOf(s.charAt(i))+1);
                }
                max = Math.max(max,s1.length());
            }
            return max;
        }
    }

    //最长回文子串
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    //字符串转换整数 (atoi)
    public static int stringToInt(String s) {
        if (s.length() == 0 || s == null) {
            return 0;
        }
        int n = 0;
        int j = 0;
        boolean is_negative = false;
        while (j < n && s.charAt(j) == ' ') {
            ++j;
        }
        if (s.charAt(j) == '-') {
            is_negative = true;
        }
        if (s.charAt(j) == '-' || s.charAt(j) == '+') {
            ++j;
        }

        for (int i = j; i < s.length(); i++) {
            if (48 < s.charAt(i) && s.charAt(i) < 58) {

                if (!is_negative && (n > 214748364 || (n == 214748364 && s.charAt(i) >= 7))) {
                    return 2147483647;
                }
                //判断是否小于 最小32位整数
                if (is_negative && (-n < -214748364 || (-n == -214748364 && s.charAt(i) >= 8))) {
                    return -2147483648;
                }
                n = n * 10 + (s.charAt(i) - 48);

            }
        }
        if (is_negative) {
            return -n;
        }
            return n;

    }

    public static void main(String[] args) {
        String s = "-23a6abc";
        System.out.println(stringToInt(s));
    }
}

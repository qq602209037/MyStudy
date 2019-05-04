package com.leetcode.china.array;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 *
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * 示例 2:
 *
 * 输入: "race a car"
 * 输出: false
 */
public class PalindromeString {
    public static void main(String[] args) {
        String s = "0p";
        System.out.println(new PalindromeString().isPalindrome(s));
    }

    /**
     * 左右动工,时间复杂度案例说是O(n)
     * @param s
     * @return
     */
    public boolean isPalindrome(String s){
        s = s.toLowerCase();
        char[] temp = s.toCharArray();
        int left=0,right=s.length()-1;
        while(left<right){

            if(!Character.isLetterOrDigit(temp[left])){
                left++;
            }else if(!Character.isLetterOrDigit(temp[right])){
                right--;
            }else if(s.charAt(left) == s.charAt(right)){
                left++;right--;
            }else{
                return false;
            }

        }
        return true;
    }
}

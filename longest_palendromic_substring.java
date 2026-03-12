class Solution {
    public void main(String args[]){
        String s="babad";

        System.out.println("The longest palindromic substring is : " + longestPalindrome(s));
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        
        if (n == 1) {
			return s;
		}
        
        StringBuilder result = new StringBuilder();
        char[] sChar = s.toCharArray();
        
        for (int i = 0; i < n; i++) {
			int right = n - 1;
			String temp = "";
			
			while (i <= right) {
				if (isRangePalindrome2(i, right, sChar)) {
					temp = new String(sChar, i, right - i + 1);
					break;
				}
				
				right--;
			}
			
			if (temp.length() > result.toString().length()) {
				result = new StringBuilder(temp);
			}
		}
        
        return result.toString();
    }

	public boolean isRangePalindrome2(int left, int right, char[] sChar) {
		while (left <= right) {
			if (sChar[left] != sChar[right]) {
				return false;
			}
			
			left++;
			right--;
		}
		
		return true;
	}
}
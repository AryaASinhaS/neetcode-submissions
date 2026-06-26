class Solution {
    public int numDecodings(String s) {
        
        if(s.length() == 0)
            return 1;
        
        if(s.charAt(0) == '0')
            return 0;

        if(s.length() <= 1)
            return 1;

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 1; i < s.length(); i++)
        {
            int num = Integer.parseInt("" + s.charAt(i-1) + s.charAt(i));
            int n = Integer.parseInt(s.charAt(i-1) + "");
            if((s.charAt(i) == '0' && n > 2) || 
               (s.charAt(i) == '0' && n == 0)
              )
              {
                
                return 0;

              }


            if(s.charAt(i) == '0')
            {
                dp[i+1] = dp[i-1];
                continue;
            }

            if(s.charAt(i-1) == '0')
            {
                dp[i+1] = dp[i];
                continue;
            }

            if(num > 26)
            {
                dp[i+1] = dp[i];
            }
            else
            {
                dp[i+1] =  dp[i-1] + dp[i];
            }
        }

        return dp[s.length()];
    }
}

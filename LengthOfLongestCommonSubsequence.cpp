#include <bits/stdc++.h>
using namespace std;
/*
    Time Complexity: O(N * M)
    Space Complexity: O(N * M)

    where 'N' and 'M' are the lengths of the "str1" and "str2" respectively.
*/

// Returns the length of lcs of "str1" and "str2".
int lcs(int i, int j, string & str1, string & str2, vector < vector < int >> & dp) {
    if (i == 0 || j == 0) {
        // One of the string is empty.
        return 0;
    } else if (dp[i][j] != -1) {
        // Solution already exists.
        return dp[i][j];
    } else if (str1[i - 1] == str2[j - 1]) {
        /* 
          The last character of both String matches. Include the current character in LCS.
          int length = lcs(i - 1, j - 1, str1, str2, dp) + 1;
        */
        int length = lcs(i - 1, j - 1, str1, str2, dp) + 1;

        // Store the result in "dp" matrix.
        dp[i][j] = length;

        return length;
    } else {
        // Get the maximum of both possibilities.
        int length = max(lcs(i, j - 1, str1, str2, dp), lcs(i - 1, j, str1, str2, dp));

        // Store the result in "dp" matrix.
        dp[i][j] = length;

        return length;
    }
}

int getLengthOfLCS(string & str1, string & str2) {
    int n = str1.size();
    int m = str2.size();

    // Dynamic programming matrix to store the length of LCS.
    vector < vector < int >> dp(n + 1, vector < int > (m + 1, -1));

    // Get the length of LCS.
    return lcs(str1.size(), str2.size(), str1, str2, dp);
}
signed main(){
    // declaring and taking inputs of string 
    string s1,s2;
    cin>>s1>>s2;

    // calling lcs fun to get length of common subsequece of two string
    cout<< getLengthOfLCS(s1,s2); 
return 0 ;
}

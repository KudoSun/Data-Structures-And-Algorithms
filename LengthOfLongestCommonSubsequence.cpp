#include <bits/stdc++.h>
using namespace std;
/*
    Time Complexity: O(2^(N + M))
    Space Complexity: O(max(N, M))

    where 'N' and 'M' are the lengths of the "str1" and "str2" respectively.
*/

// Returns the length of lcs of "str1" and "str2".
int lcs(int i, int j, string & str1, string & str2) {
    if (i == 0 || j == 0) {
        // One of the string is empty.
        return 0;
    } else if (str1[i - 1] == str2[j - 1]) {
        /* 
          The last character of both String matches. Include the current character in LCS.
          int length = lcs(i - 1, j - 1, str1, str2, dp) + 1;
        */
        return lcs(i - 1, j - 1, str1, str2) + 1;
    } else {
        // Get the maximum of both possibilities.
        return max(lcs(i, j - 1, str1, str2), lcs(i - 1, j, str1, str2));
    }
}

int getLengthOfLCS(string & str1, string & str2) {
    int n = str1.size();
    int m = str2.size();

    // Get the length of LCS.
    return lcs(n, m, str1, str2);
}
signed main(){
    // declaring and taking inputs of string 
    string s1,s2;
    cin>>s1>>s2;

    // calling lcs fun to get length of common subsequece of two string
    cout<< getLengthOfLCS(s1,s2); 
return 0 ;
}
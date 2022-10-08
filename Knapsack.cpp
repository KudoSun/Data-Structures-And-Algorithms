
int Knapsack2(vector<int>& weight, vector<int>& value, int maxWeight){
    //dp[n][m] is the value we can collect if the array is of size n and we can carry maxWeight m
    vector<vector<int>> dp(value.size()+1,vector<int>(maxWeight+1));

    
    //if maxWeight is 0 then value we can get is 0,
    //Initializig row 1 with zero
    for(int i=0;i<=maxWeight;i++){
        dp[0][i] = 0;
    }

    //if size of array is zero then there is noting to take 
    //Initializing column 1 with 0
    for(int j=1;j<=value.size();j++){
        dp[j][0] = 0;
    }
    for(int i=1;i<=value.size();i++){
        for(int j = 1; j<=maxWeight; j++){
            //Not Including
            int x = dp[i-1][j];

            //Including if within limits
            int y = 0;
    //j is current maxWeight
    // i is the size of array so the last value will ne i-1th
    // so the last weight include is weight[i-1] is we are moving from start to edn
    // Or we can have first element as weight[values.size()-i] if we are assumin to add 1 element t front in each iteration
            
            if(j - weight[i-1] >=0){
                y = value[i-1] + dp[i-1][j-weight[i-1]];
            }


            dp[i][j] = max(x,y);
        }
    }
    

    return dp[value.size()][maxWeight];
}

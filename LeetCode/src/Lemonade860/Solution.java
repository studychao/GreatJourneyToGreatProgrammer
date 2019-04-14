package Lemonade860;

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int change[] = {0,0};
        for ( int i = 0 ; i < bills.length ; i++)
        {
            if (bills[i] == 5)
            {
                change[0] = change[0] + 1;
            }
            if (bills[i] == 10)
            {
                if (change[0] == 0)
                    return false;
                else {
                    change[0] = change[0] - 1;
                    change[1] = change[1] + 1;
                }
            }
            if (bills[i] == 20)
            {
                if (change[1] != 0)
                {
                    if (change[0] == 0)
                        return false;
                    else{
                        change[0] = change[0] - 1;
                        change[1] = change[1] - 1;
                    }
                }
                else
                {
                    if (change[0] < 3)
                        return false;
                    else{
                        change[0] = change[0] - 3;
                    }
                }

            }


        }
        return true;
    }
}
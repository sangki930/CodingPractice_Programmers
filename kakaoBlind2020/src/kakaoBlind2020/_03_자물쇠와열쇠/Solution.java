package kakaoBlind2020._03_切弘取人伸取;

class Solution {

    public int[][] roll(int[][] mat)
    {
        int[][] temp = new int[mat.length][mat.length];

        for (int i = 0; i < mat.length; i++)
        {
            for (int j = 0; j < mat.length; j++)
            {
                temp[i][j] = mat[mat.length - j - 1][i];
            }
        }

        return temp;
    }

    public int[][] move(int[][] key, int length, int row, int col)
    {
        int[][] temp = new int[length][length];

        for (int i = 0; i < key.length; i++)
        {
            for (int j = 0; j < key.length; j++)
            {
                if (i + row >= 0 && i + row < length && j + col >= 0 && j + col < length)
                {
                    temp[i + row][j + col] = key[i][j];
                }
            }
        }

        return temp;
    }

    public boolean same(int[][] key, int[][] lock)
    {
         for (int n = 0; n < lock.length; n++)
        {
            for (int m = 0; m < lock.length; m++)
            {
                if ((key[n][m] ^ lock[n][m]) == 0)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean check(int[][] key, int[][] lock)
    {
        int[][] mat = new int[lock.length * 2 - 1][lock.length * 2 - 1];

        for (int i = (1 - key.length); i < lock.length; i++)
        {
            for (int j = (1 - key.length); j < lock.length; j++)
            {
                int[][] temp = move(key, lock.length, i, j);
                if (same(temp, lock))
                {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;

        for (int i = 0; i < key.length; i++)
        {
            if (check(key, lock))
            {
                return true;
            }

            key = roll(key);
        }

        return answer;
    }
}

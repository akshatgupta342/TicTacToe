/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
//0 computer
//x human
//n null
public class NextMove {

    public static boolean moved = false;

    public static char[][] main(char board[][],boolean mov) {
        moved=mov;
        board = winmove(board);
        if (!moved) {
            board = blockmove(board);
        }
        if (!moved) {
            board = makeFork(board);
        }
        if (!moved) {
            board = blockFork(board);
        }
        if (!moved) {
            board = centermove(board);
        }
        if (!moved) {
            board = oppcorner(board);
        }
        if (!moved) {
            board = emptycorner(board);
        }
        if (!moved) {
            board = emptyside(board);
        }
        else
        {
            for(int i=0;i<3&&!moved;i++)
            {
                for(int j=0;j<3&&!moved;j++)
                {
                    if(board[i][j]=='n')
                    {
                        board[i][j]='0';
                        moved=true;
                    }
                }
            }
        }
        return board;
    }

    private static char[][] winmove(char[][] board) {
        for (int j = 0; j < 3 && !moved; j++) {
            int cocc = 0;
            int emp = 0;
            int x = 0, y = 0;
            for (int i = 0; i < 3; i++) {
                if (board[j][i] == '0') {
                    cocc += 1;
                } else if (board[j][i] == 'n') {
                    emp += 1;
                    x = j;
                    y = i;
                }
            }
            if (cocc == 2 && emp == 1) {
                board[x][y] = '0';
                moved = true;
                return board;
            }
        }
        for (int i = 0; i < 3 && !moved; i++) {
            int cocc = 0;
            int emp = 0;
            int x = 0, y = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == '0') {
                    cocc += 1;
                } else if (board[j][i] == 'n') {
                    emp += 1;
                    x = j;
                    y = i;
                }
            }
            if (cocc == 2 && emp == 1) {
                board[x][y] = '0';
                moved = true;
                return board;
            }
        }
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0;
            for(int i=0;i<3;i++)
            {
                if(board[i][i]=='0')
                {
                    cocc+=1;
                }
                else if(board[i][i]=='n')
                {
                    emp+=1;
                    x=i;
                }
            }
            if(cocc==2&&emp==1)
            {
                board[x][x]='0';
                moved=true;
                return board;
            }
        }
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0,y=0;
            if(board[0][2]=='0')
                cocc+=1;
            else if(board[0][2]=='n')
            {
                emp+=1;
                x=0;
                y=2;
            }
            if(board[1][1]=='0')
                cocc+=1;
            else if(board[1][1]=='n')
            {
                emp+=1;
                x=1;
                y=1;
            }
            if(board[2][0]=='0')
                cocc+=1;
            else if(board[2][0]=='n')
            {
                emp+=1;
                x=2;
                y=0;
            }
            if(cocc==2&&emp==1)
            {
                board[x][y]='0';
                moved=true;
                return board;
            }
        }
        return board;
    }

    
    private static char[][] blockmove(char[][] board) {
        for (int j = 0; j < 3 && !moved; j++) {
            int cocc = 0;
            int emp = 0;
            int x = 0, y = 0;
            for (int i = 0; i < 3; i++) {
                if (board[j][i] == 'x') {
                    cocc += 1;
                } else if (board[j][i] == 'n') {
                    emp += 1;
                    x = j;
                    y = i;
                }
            }
            if (cocc == 2 && emp == 1) {
                board[x][y] = '0';
                moved = true;
                return board;
            }
        }
        for (int i = 0; i < 3 && !moved; i++) {
            int cocc = 0;
            int emp = 0;
            int x = 0, y = 0;
            for (int j = 0; j < 3; j++) {
                if (board[j][i] == 'x') {
                    cocc += 1;
                } else if (board[j][i] == 'n') {
                    emp += 1;
                    x = j;
                    y = i;
                }
            }
            if (cocc == 2 && emp == 1) {
                board[x][y] = '0';
                moved = true;
                return board;
            }
        }
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0;
            for(int i=0;i<3;i++)
            {
                if(board[i][i]=='x')
                {
                    cocc+=1;
                }
                else if(board[i][i]=='n')
                {
                    emp+=1;
                    x=i;
                }
            }
            if(cocc==2&&emp==1)
            {
                board[x][x]='0';
                moved=true;
                return board;
            }
        }
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0,y=0;
            if(board[0][2]=='x')
                cocc+=1;
            else if(board[0][2]=='n')
            {
                emp+=1;
                x=0;
                y=2;
            }
            if(board[1][1]=='x')
                cocc+=1;
            else if(board[1][1]=='n')
            {
                emp+=1;
                x=1;
                y=1;
            }
            if(board[2][0]=='x')
                cocc+=1;
            else if(board[2][0]=='n')
            {
                emp+=1;
                x=2;
                y=0;
            }
            if(cocc==2&&emp==1)
            {
                board[x][y]='0';
                moved=true;
                return board;
            }
        }
        return board;
    }

    
    private static char[][] makeFork(char[][] board) {
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0,y=0;
            if(board[0][0]=='0')
                cocc+=1;
            else if(board[0][0]=='n')
            {   emp+=1;
                x=0;
                y=0;
            }
            if(board[2][0]=='0')
                cocc+=1;
            else if(board[2][0]=='n')
            {
                emp+=1;
                x=2;
                y=0;
            }
            if(board[0][2]=='0')
                cocc+=1;
            else if(board[0][2]=='n')
            {
                emp+=1;
                x=0;
                y=2;
            }
            if(cocc==2&&emp==1)
            {
                board[x][y]='0';
                moved=true;
                return board;
            }
        }
        
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0,y=0;
            if(board[0][0]=='0')
                cocc+=1;
            else if(board[0][0]=='n')
            {   emp+=1;
                x=0;
                y=0;
            }
            if(board[0][2]=='0')
                cocc+=1;
            else if(board[0][2]=='n')
            {
                emp+=1;
                x=0;
                y=2;
            }
            if(board[2][2]=='0')
                cocc+=1;
            else if(board[2][2]=='n')
            {
                emp+=1;
                x=2;
                y=2;
            }
            if(cocc==2&&emp==1)
            {
                board[x][y]='0';
                moved=true;
                return board;
            }
        }
        
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0,y=0;
            if(board[0][2]=='0')
                cocc+=1;
            else if(board[0][2]=='n')
            {   emp+=1;
                x=0;
                y=2;
            }
            if(board[2][2]=='0')
                cocc+=1;
            else if(board[2][2]=='n')
            {
                emp+=1;
                x=2;
                y=2;
            }
            if(board[2][0]=='0')
                cocc+=1;
            else if(board[2][0]=='n')
            {
                emp+=1;
                x=2;
                y=0;
            }
            if(cocc==2&&emp==1)
            {
                board[x][y]='0';
                moved=true;
                return board;
            }
        }
        
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0,y=0;
            if(board[0][0]=='0')
                cocc+=1;
            else if(board[0][0]=='n')
            {   emp+=1;
                x=0;
                y=0;
            }
            if(board[2][0]=='0')
                cocc+=1;
            else if(board[2][0]=='n')
            {
                emp+=1;
                x=2;
                y=0;
            }
            if(board[2][2]=='0')
                cocc+=1;
            else if(board[2][2]=='n')
            {
                emp+=1;
                x=2;
                y=2;
            }
            if(cocc==2&&emp==1)
            {
                board[x][y]='0';
                moved=true;
                return board;
            }
        }
        return board;
    }

    private static char[][] blockFork(char[][] board) {
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0,y=0;
            if(board[0][0]=='x')
                cocc+=1;
            else if(board[0][0]=='n')
            {   emp+=1;
                x=0;
                y=0;
            }
            if(board[2][0]=='x')
                cocc+=1;
            else if(board[2][0]=='n')
            {
                emp+=1;
                x=2;
                y=0;
            }
            if(board[0][2]=='x')
                cocc+=1;
            else if(board[0][2]=='n')
            {
                emp+=1;
                x=0;
                y=2;
            }
            if(cocc==2&&emp==1)
            {
                board[x][y]='0';
                moved=true;
                return board;
            }
        }
        
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0,y=0;
            if(board[0][0]=='x')
                cocc+=1;
            else if(board[0][0]=='n')
            {   emp+=1;
                x=0;
                y=0;
            }
            if(board[0][2]=='x')
                cocc+=1;
            else if(board[0][2]=='n')
            {
                emp+=1;
                x=0;
                y=2;
            }
            if(board[2][2]=='x')
                cocc+=1;
            else if(board[2][2]=='n')
            {
                emp+=1;
                x=2;
                y=2;
            }
            if(cocc==2&&emp==1)
            {
                board[x][y]='0';
                moved=true;
                return board;
            }
        }
        
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0,y=0;
            if(board[0][2]=='x')
                cocc+=1;
            else if(board[0][2]=='n')
            {   emp+=1;
                x=0;
                y=2;
            }
            if(board[2][2]=='x')
                cocc+=1;
            else if(board[2][2]=='n')
            {
                emp+=1;
                x=2;
                y=2;
            }
            if(board[2][0]=='x')
                cocc+=1;
            else if(board[2][0]=='n')
            {
                emp+=1;
                x=2;
                y=0;
            }
            if(cocc==2&&emp==1)
            {
                board[x][y]='0';
                moved=true;
                return board;
            }
        }
        
        if(!moved)
        {
            int cocc=0;
            int emp=0;
            int x=0,y=0;
            if(board[0][0]=='x')
                cocc+=1;
            else if(board[0][0]=='n')
            {   emp+=1;
                x=0;
                y=0;
            }
            if(board[2][0]=='x')
                cocc+=1;
            else if(board[2][0]=='n')
            {
                emp+=1;
                x=2;
                y=0;
            }
            if(board[2][2]=='x')
                cocc+=1;
            else if(board[2][2]=='n')
            {
                emp+=1;
                x=2;
                y=2;
            }
            if(cocc==2&&emp==1)
            {
                board[x][y]='0';
                moved=true;
                return board;
            }
        }
        return board;
    }

    private static char[][] centermove(char[][] board) {
        if(board[1][1]=='n')
        {
            board[1][1]='0';
            moved=true;
        }
        return board;
    }

    private static char[][] oppcorner(char[][] board) {
        if(board[0][0]=='x'&&board[2][2]=='n')
        {
            board[2][2]='0';
            moved=true;
            return board;
        }
        else if(board[0][0]=='n'&&board[2][2]=='x')
        {
            board[0][0]='0';
            moved=true;
            return board;
        }
        else if(board[0][2]=='x'&&board[2][0]=='n')
        {
            board[2][0]='0';
            moved=true;
            return board;
        }
        else if(board[0][2]=='n'&&board[2][0]=='x')
        {
            board[0][2]='0';
            moved=true;
            return board;
        }
        return board;
    }

    private static char[][] emptycorner(char[][] board) {
        if(board[0][0]=='n')
        {
            board[0][0]='0';
            moved=true;
            return board;
        }
        else if(board[0][2]=='n')
        {
            board[0][2]='0';
            moved=true;
            return board;
        }
        else if(board[2][0]=='n')
        {
            board[2][0]='0';
            moved=true;
            return board;
        }
        else if(board[2][2]=='n')
        {
            board[2][2]='0';
            moved=true;
            return board;
        }
        return board;
    }

    private static char[][] emptyside(char[][] board) {
        if(board[0][1]=='n')
        {
            board[0][1]='0';
            moved=true;
            return board;
        }
        else if(board[1][0]=='n')
        {
            board[1][0]='0';
            moved=true;
            return board;
        }
        else if(board[1][2]=='n')
        {
            board[1][2]='0';
            moved=true;
            return board;
        }
        else if(board[2][1]=='n')
        {
            board[2][1]='0';
            moved=true;
            return board;
        }
        return board;
    }
}
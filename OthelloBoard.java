/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package othello_game;

/**
 *
 * @author Harpreet Singh
 */
public class OthelloBoard {
    

	private int board[][];
	final static int player1Symbol = 1;
	final static int player2Symbol = 2;

	public OthelloBoard() {
		board = new int[8][8];
		board[3][3] = player1Symbol;
		board[3][4] = player2Symbol;
		board[4][3] = player2Symbol;
		board[4][4] = player1Symbol;
	}

	public void print() {
            System.out.print("  ");
            for(int i = 0; i < 8; i++)
			System.out.print(i+" ");
            System.out.println();
		for(int i = 0; i < 8; i++) {
			System.out.print(i+" ");
			for(int j = 0; j < 8; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
        
        public void result()
        {
             int op1=0;
        for(int i=0;i<8;i++)
        {
            for(int j=0;j<8;j++)
            {
                if(board[i][j]==1)
                    op1++;
            }
        }
        if(op1>32)
            System.out.println("Player one wins");
        else
            System.out.println("Player one wins");
            
        }

	public boolean move(int symbol, int x, int y){
		
      if(x>7||y>7||y<0||x<0)
        return false;
      int xdir[]=new int[]{1,1,0,-1,-1,-1,0,1};
      int ydir[]=new int[]{0,1,1,1,0,-1,-1,-1};
      int t=7;
      boolean mademove=false;
      while(t>=0)
      {
        int startx=x,starty=y;
        int endx=0,endy=0;
        int flag1=0;int flag2=0;
        int j=x+xdir[t];
        int k=y+ydir[t];
        if(j>7||k>7||k<0||j<0)
        {
            t--;continue;
        }
        if(board[j][k]==0)
        {
            t--;continue;
        }
        //while loop to check for changes
        if(board[j][k]!=symbol){
        while(j<8&&j>-1&&k<8&&k>-1)
        {
          if(board[j][k]==0)
          {
            break;
          }
          if(board[j][k]!=symbol)
          {
            
            flag1=1;
            j=j+xdir[t];
            k=k+ydir[t];
            continue;
          }
          if(board[j][k]==symbol)
          {
            flag2=1;
            endx=j;
            endy=k;
            break;
          }
          
        }// while end
        
        //if statement to make changes if required
        if(flag1==1&&flag2==1)
        {
            //System.out.println("startx="+startx+"  endx="+endx+"  starty="+starty+"  endy="+endy);
          mademove=true;
          if(startx==endx)
          {
            while(starty!=endy)
          {
            board[startx][starty]=symbol;
           
            starty=starty+ydir[t];
          }   
          }//first if
          if(starty==endy)
          {
            while(startx!=endx)
          {
            board[startx][starty]=symbol;
           
            startx=startx+xdir[t];
          }   
          }//second if
          if(startx!=endx&&starty!=endy)
          {
          while(startx!=endx&&starty!=endy&&startx>=0&&startx<=7&&endx>=0&&endx<=7)
          {
            board[startx][starty]=symbol;
            startx=startx+xdir[t];
            starty=starty+ydir[t];
          }
          }//third if
          
          
          
        }
        }
        
        t--;
      }//second while
   return mademove;
	}


}

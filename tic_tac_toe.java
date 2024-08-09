import java.util.Random;
import java.util.Scanner;

import javax.swing.BoundedRangeModel;

/**
 * tic_tac_toy
 */
public class tic_tac_toe {

    char bound[][];
    tic_tac_toe(){
        bound = new char[3][3];
        for(int i =0; i<3 ; i++)
            for(int j=0; j<3 ; j++)
                bound[i][j]=' ';
    }
    void display()
    {
        System.out.println(".........");
        for(int i =0; i<3 ; i++){
            for(int j=0; j<3 ; j++){
                System.out.print(bound[i][j]+" ");
                if(j<2)
                System.out.print("| ");
            }
            System.out.println();
        }
        System.out.println(".........");
    }
    void fill_char(int x,int y, char ch){
        if((x>=0 || x<3)&& (y>=0 || y<3))
            bound[x][y]= ch;
        else
            System.out.println("Enter valid address!");
    }
    boolean checkRow(){
        for(int j=0; j<3;j++){
            if((bound[0][j] != ' ' )&&(bound[0][j]==bound[1][j]) && (bound[1][j]==bound[2][j]))
                return true;
        }
        return false;
    }
    boolean checkCol(){
        for(int i=0; i<3;i++){
            if((bound[i][0] != ' ' )&&(bound[i][0]==bound[i][1]) && (bound[i][1]==bound[i][2]))
                return true;
        }
        return false;
    }
    boolean checkDiog(){
        if(((bound[0][0] != ' ' )&&(bound[0][0]==bound[1][1]) && (bound[1][1]==bound[2][2])) || ((bound[2][0] != ' ' )&&(bound[2][0]==bound[1][1]) && (bound[1][1]==bound[0][2])))
            return true;
        return false;
    }


    public static void main(String[] args) {
        tic_tac_toe obj  = new tic_tac_toe();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("--------- Welcome to TIC TAC TOE Game ---------\n\n");
        System.out.println("Enter First Player Name: ");

        String player1 = sc.nextLine();
        System.out.println("Enter Second Player Name: ");
        String player2 = sc.nextLine();
        String [] arr = {player1,player2};
        int rd = rand.nextInt(2);
        
        for(int i=0; i<9;i++){
            if(i%2==0){
                obj.display();
                System.out.println(arr[(rd+i)%2] + "'s Chance...");
                System.out.println("Enter Coordinates whrer you want to fill X");
                int row = sc.nextInt();
                int col = sc.nextInt();
                obj.fill_char(row,col,'X');
                if(obj.checkRow()|| obj.checkDiog() || obj.checkCol()){
                    System.out.println("\n");
                    System.out.println("Well Played "+arr[(rd+i)%2]+" you won the match" );
                    return;
                }
            }
            else{
                obj.display();
                System.out.println(arr[(rd+i)%2] + "'s Chance...");
                System.out.println("Enter Coordinates whrer you want to fill O");
                int row2 = sc.nextInt();
                int col2 = sc.nextInt();
                obj.fill_char(row2,col2,'O');
                if(obj.checkRow()|| obj.checkDiog() || obj.checkCol()){
                    System.out.println("\n");
                    System.out.println("Well Played "+arr[(rd+i)%2]+" you won the match" );
                    return;
                }
            }
        }
    }
}
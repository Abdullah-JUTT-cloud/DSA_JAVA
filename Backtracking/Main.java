public class Main {
    public static void subSets(String str,String ans,int i){
        if(i==str.length()){
            if(ans.length()==0){
                System.out.println("null");
            }else{
                System.out.println(ans);
            }
            return;
        }
        subSets(str,ans+str.charAt(i),i+1);
        subSets(str,ans,i+1);
    }
    public static void NQueens(char board[][],int row){
        if(row==board.length){
            printBoard(board);
            return;
        }

            for(int i=0;i< board.length;i++){
                if (isSafe(board,row,i)){
                    board[row][i]='Q';
                    NQueens(board,row+1);
                    board[row][i]='*';
                }
            }

    }
    public static boolean isSafe(char board[][],int row,int col){
        for(int i=row-1;i>=0;i--){
            if(board[i][col]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col+1;i>=0&&j< board.length;i--,j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    public static void printBoard(char board[][]){
        System.out.println("--------chess board----------");
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static int gridWays(int i,int j,int n,int m){
        if(i==n-1&&j==m-1){
            return 1;
        }else if(i==n || j==m){
            return 0;
        }
        int w1=gridWays(i+1,j,n,m);
        int  w2=gridWays(i,j+1,n,m);
        return  w1+w2;

    }
    public static void main(String[] args) {
//        String str="abc";
//        subSets(str,"",0);
//        int n=4;
//        char board[][]=new char [n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                board[i][j]='*';
//            }
//        }
//        NQueens(board,0);
        System.out.println(gridWays(0,0,113,113));
    }
}
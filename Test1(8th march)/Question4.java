public class Question4{
    public static void main(String[] args) {
        int[][] A={{1,2},{3,4}};
        int[][] B={{5,6},{7,8}};
        int[][] C= new int[2][2];
        for(int i=0;i<2;i++){
            for(int j=0;j<2;j++){
                C[i][j] =A[i][j]+B[i][j];
            }
        }
        for(int[] row:C){
            for(int k:row){
                System.out.print(k+" ");
            }
            System.out.println();   

        }
    }
}

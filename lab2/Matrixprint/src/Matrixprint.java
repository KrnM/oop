public class Matrixprint {
    public static void main(String args[]){
        int [][] anArray = new int [5][5];
        int a = 1;
        for (int i = 0; i < anArray.length; i++) {
            for (int j = 0; j < anArray.length; j++) {
                if ((i ==j) | (i + j == anArray.length - 1))
                    System.out.print(" * ");
                else if (a<10){
                    System.out.print (" " + a + " ");
                }
                else {
                    System.out.print (a + " ");
                }
                a = a+1;
            }
            System.out.println();
        }
    }
}
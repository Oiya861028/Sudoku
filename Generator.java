public class Generator {
    public static void main(String[] args){
        printCell(generateOneCell());
        printCell(generateOneCell());
        printCell(generateOneCell());
        printCell(generateOneCell());
    }
    public static int[][] generateOneCell(){
        int[][] arr = new int[3][3];
        StringBuilder generatedNumbers = new StringBuilder();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int num = (int) (Math.random() * 9) +1;
                while(generatedNumbers.toString().contains(Integer.toString(num))) num = (int) (Math.random() * 9) +1;
                arr[i][j] = num;
                generatedNumbers.append(Integer.toString(num));

            }
        }
        return arr;
    }
    public static void printCell(int[][] cell){
        for(int i=0;i<3; i++){
            for(int j=0;j<3;j++){
                System.out.print(cell[i][j]+" ");
            }
            System.out.println();
        }
    }


}

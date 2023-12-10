public class Generator {
    public static void main(String[] args){
        System.out.println();
        printCell(generateThreeVerticalCells());
    }
    public static int[][] generateOneCell(){
        int[][] arr = new int[3][3];
        StringBuilder generatedNumbers = new StringBuilder();
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                int num = (int) (Math.random() * 9) +1;
                while(generatedNumbers.toString().contains(Integer.toString(num))) num = (int) (Math.random() * 9) +1;
                arr[i][j] = num;
                generatedNumbers.append(num);
            }
        }
        return arr;
    }
    public static int[][] generateThreeHorizontalCells(){
        int[][] arr = new int[3][9];
        int[][] leftCell = generateOneCell();
        //adding leftcell to the horizontal
        for(int i=0;i<leftCell.length;i++){
            System.arraycopy(leftCell[i], 0, arr[i], 0, 3);
        }
        //Creating the middle cell and adding to arr
        StringBuilder middleCellTaken = new StringBuilder(); //use for checking the middle cell
        StringBuilder rightCellTaken = new StringBuilder(); //use for checking the right cell
        for(int i=0;i<arr.length;i++){
            StringBuilder rowTakenNum = new StringBuilder(); //use for checking the rows
            for(int n:leftCell[i]){
                rowTakenNum.append(n);
            }

            for(int j=3;j<arr[i].length-3;j++){
                int num = (int) (Math.random() * 9) +1;
                while(rowTakenNum.toString().contains(Integer.toString(num)) || middleCellTaken.toString().contains(Integer.toString(num))){
                    num = (int) (Math.random() * 9) +1;
                }
                arr[i][j] = num;
                rowTakenNum.append(num);
                middleCellTaken.append(num);
            }
            //Adding numbers to the right cell
            for(int j=arr[i].length-3;j<arr[i].length;j++){
                int num = (int) (Math.random() * 9) +1;
                while(rowTakenNum.toString().contains(Integer.toString(num)) || rightCellTaken.toString().contains(Integer.toString(num))){
                    num = (int) (Math.random() * 9) +1;
                }
                arr[i][j] = num;
                rowTakenNum.append(num);
                rightCellTaken.append(num);
            }
        }
        return arr;

    }
    public static int[][] generateThreeVerticalCells(){
        int[][] arr = new int[9][3];
        int[][] topCell = generateOneCell();
        //adding topcell to arr
        for(int i = 0; i< topCell.length; i++){
            System.arraycopy(topCell[i], 0, arr[i], 0, 3);
        }
        StringBuilder middleCell = new StringBuilder(); //Notate middle cell taken numbers
        StringBuilder bottomCell = new StringBuilder(); //Notate bottom cell taken numbers
        for(int col=0;col<arr[0].length;col++){
            StringBuilder colTaken = new StringBuilder(); //Notate taken number in the columns
            for(int[] n: topCell){
                colTaken.append(n[col]);
            }
            for(int row=3;row<6;row++){
                int num = (int) (Math.random() * 9) +1;
                while(colTaken.toString().contains(Integer.toString(num)) || middleCell.toString().contains(Integer.toString(num))){
                    num = (int) (Math.random() * 9) +1;
                }
                arr[row][col] = num;
                colTaken.append(num);
                middleCell.append(num);
            }
            for(int row=6;row<arr.length;row++){
                int num = (int) (Math.random() * 9) +1;
                while(colTaken.toString().contains(Integer.toString(num)) || bottomCell.toString().contains(Integer.toString(num))) {
                    num = (int) (Math.random() * 9) +1;
                }
                arr[row][col] = num;
                colTaken.append(num);
                bottomCell.append(num);
            }
        }
        return arr;
    }
    public static void printCell(int[][] cell){
        for (int[] ints : cell) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


}

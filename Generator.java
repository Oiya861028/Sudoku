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
    /* Shuffle not random enough. Discarded
    public static int[][] shuffle(int[][] arr,int times){
        //Comvert the two Dimensional arr into 1D so the shuffle can be performed in 1D
        int[] shuffleDeck = new int[arr.length*arr[0].length];
        int index = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++) {
                shuffleDeck[index] = arr[i][j];
                index++;
            }
        }
        //shuffle for n times. Each shuffle will update the shuffleDeck[]
        for(int n = 0; n <times; n++){
            int[] temp = new int[shuffleDeck.length];
            int k=0;
            for(int i=0;i<temp.length/2;i++){
                temp[k] = shuffleDeck[i];
                temp[k+1] = shuffleDeck[shuffleDeck.length/2+i];
                k+=2;
            }
            temp[temp.length-1] = 9;
            shuffleDeck = temp;
        }
        //Convert the shuffledDeck back to arr
        index =0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++) {
                arr[i][j] = shuffleDeck[index];
                index++;
            }
        }
        return arr;
    }

     */

}

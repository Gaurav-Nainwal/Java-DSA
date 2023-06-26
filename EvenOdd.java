class EvenOdd{
    public static void number(int n){
        if((n&1)==0){
            System.out.println("even");
            
        }else{
            System.out.println("odd");
        }
    }
    public static void main(String[] args) {
        number(4);
        number(5);
    }
}
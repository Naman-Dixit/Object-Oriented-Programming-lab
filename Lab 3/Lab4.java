//Write a program to calculate the sum of all integers between 10 to 950 which are divisible by both 6 and 9

class Lab4 {

    public static void main(String args[]) {
        int sum = 0;
        int s = 10;
        int e = 950;
        for (int i = s; i < e; i++) {

            if ((i % 6 == 0) && (i % 9 == 0)) {
                sum += i;
            }
        }
        System.out.println("Sum=" + sum);
    }

}

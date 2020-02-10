public class Main {

    public static void main(String[] args) {

        System.out.println( findKthNumber(220,21) );

    }

       public static int findKthNumber(int n, int k) {

            if (n < k || k < 1) return 0;
            else if (n < 10) return k;
            int cur = 1;

            // let's do this with 0 based index!
            --k;

            while (k > 0) {

                // note that step will reset at the start of each while loop; first will be set to cur
                long step = 0, first = cur, last = cur + 1;

                // how many steps from FIRST to n [FIRST (cur) keeps getting updated]

                // if steps less than k, then we just need to go right [this means that we are at the right row of the denary tree], moving to right involves
                // passing over all children of number of left, therefore: k -= step; e.g when cur is 10 and cur gets incremented to 11
                // i need to pass through 10 , 100, 101 , 102 , ... , 109 -> 11 steps

                // else, multiply cur by 10 and go left [this means that we have to go next, to get steps <= k]
                // in this case, k is reduced by 1 since only 1 number is out of our way
                while (first <= n) {
                    step += Math.min( (long)n + 1, last ) - first;
                    first *= 10;
                    last *= 10;
                }
                //e.g: from 10 to 11 is 1 step; then from 100 to 110 is 10 steps, overall 11 steps, so when steps is less than k and wehave to go right
                // we have to k =+ step


                // we have to go to the right
                if (step <= k) {
                    ++cur;
                    k -= step;
                // we have to visit left most child
                } else {
                    cur *= 10;
                    --k;
                }

            }

            return cur;

        }
    }
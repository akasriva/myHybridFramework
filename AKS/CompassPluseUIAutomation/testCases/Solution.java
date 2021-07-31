package testCases;

 

public class Solution {

 

 

 

      public static int solutions() {

 

            int temp = 0;

            int flag=0;

      int[] A= new int[5];

 

            A[0]=1;

            A[1]=2;

            A[2]=4;

            A[3]=5;

            A[4]=7;

 

            for(int i=0;i<A.length;i++) {

                  for(int j=0;j<A.length;j++) {

                        if((i+1)==A[j]) {

                              flag=1;

                              break;

                             

                        }

                  }if(flag==0) {

                        temp=i+1;

                  }

 

            }

            System.out.println("Miss positive integer="+temp);

            return temp;     

      }

      public static void main(String[] args) {

            solutions();

 

      }

 

}
package Java;

/*
 * The Test class contains the test for the program, 
 * and a main function to run the selected tests.
 */
public class Test {

      /**
      * Array containing the names of possible test cases.
      */
      String[] tests = {
          "�tkozott szob�ban ajt�k v�ltoz�sa", //1
          "Tranzisztor haszn�lata", //2
          "Camembert haszn�lata", //3
          "T�rl?rongy haszn�lata", //4 
          "Logarl�c megszerz�se", //5
          "TVSZ haszn�lata 1", //6
          "TVSZ haszn�lata 2", //7
          "S�r�spoh�r haszn�lata 1", //8
          "S�r�spoh�r haszn�lata 2", //9
          "Maszk haszn�lata 1", //10
          "Maszk haszn�lata 2", //11
          "Passz�v t�rgyak haszn�lata", //12
          "Hallgat� �sszefut tan�rral", //13
          "Tan�r �sszefut hallgat�val", //14
          "Egy szoba kett� v�lik", //15
          "K�t szoba �sszeolvad", //16
          "G�zos szoba maszk n�lk�l", //17
          "Tan�r rongyos szob�ba l�p.", //18
          "Tanul� �tl�p egy m�sik szob�ba", //19
          "Tan�r �tl�p egy m�sik szob�ba", //20
          "T�rgy felv�tele", //21
          "T�rgy let�tele", //22
          "Tesztel�s v�ge" //23
      };

      /**
      * Function to print the names and numbers of possible test cases.
      */
      void printTests(){
           System.out.println("Lehets�ges tesztesetek:")
           for (int i = 1; i <= 23; i++) {
                if(i == 1 || i == 23) System.out.println(\n);
                System.out.println(i + ": " + tests[i - 1]);
           }
      }

      /**
      * Function that runs the 1st test case 
      */
      void test01(){

      }

      /**
      * Function that runs the 2nd test case 
      */
      void test02(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test03(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test04(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test05(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test06(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test07(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test08(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test09(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test10(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test11(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test12(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test13(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test14(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test15(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test16(){

      }    
      
      /**
      * Function that runs the 1st test case 
      */
      void test17(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test18(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test19(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test20(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test21(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void test22(){

      }
      
      /**
      * Function that runs the 1st test case 
      */
      void endTest(){
          testCase = 23;
          System.out.print(\n"A tesztel�s befejezt�k.");

      }
          
      /**
      * Variable that defines the current test case 
      */
      int testCase;

      /**
      * The main function that runs the testing 
      *
      *It consists of a while loop that first lists possible test cases,
      *prompts the user for a number, 
      *and then runs the test with the specified sequence number.
      *Then lists the tests again and asks for a number.
      *To finish testing, you must provide the corresponding input.
      */
      public static void main(String[] args){
          
        Scanner scanner = new Scanner(System.in);

        while(testCase != 23){
            printTests();
            System.out.print("V�lassz egy tesztesetet: ");
            testCase = scanner.nextInt();

            switch (testCase) {
            case 1: test01();
                break;
            case 2: test02();
                break;
            case 3: test03();
                break;
            case 4: test04();
                break;
            case 5: test05();
                break;
            case 6: test06();
                break;
            case 7: test07();
                break;
            case 8: test08();
                break;
            case 9: test09();
                break;
            case 10: test10();
                break;
            case 11: test11();
                break;
            case 12: test12();
                break;
            case 13: test13();
                break;
            case 14: test14();
                break;
            case 15: test15();
                break;
            case 16: test16();
                break;
            case 17: test17();
                break;
            case 18: test18();
                break;
            case 19: test19();
                break;
            case 20: test20();
                break;
            case 21: test21();
                break;
            case 22: test22();
                break;
            case 23: endTest();
                break;          
            default:
                System.out.println("Nincs megfelel? f�ggv�ny ehhez a sz�mhoz.");
            }
        }
      }
}

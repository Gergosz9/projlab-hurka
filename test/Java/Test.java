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
          "Átkozott szobában ajtók változása", //1
          "Tranzisztor használata", //2
          "Camembert használata", //3
          "Törl?rongy használata", //4 
          "Logarléc megszerzése", //5
          "TVSZ használata 1", //6
          "TVSZ használata 2", //7
          "Söröspohár használata 1", //8
          "Söröspohár használata 2", //9
          "Maszk használata 1", //10
          "Maszk használata 2", //11
          "Passzív tárgyak használata", //12
          "Hallgató összefut tanárral", //13
          "Tanár összefut hallgatóval", //14
          "Egy szoba ketté válik", //15
          "Két szoba összeolvad", //16
          "Gázos szoba maszk nélkül", //17
          "Tanár rongyos szobába lép.", //18
          "Tanuló átlép egy másik szobába", //19
          "Tanár átlép egy másik szobába", //20
          "Tárgy felvétele", //21
          "Tárgy letétele", //22
          "Tesztelés vége" //23
      };

      /**
      * Function to print the names and numbers of possible test cases.
      */
      void printTests(){
           System.out.println("Lehetséges tesztesetek:")
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
          System.out.print(\n"A tesztelés befejezték.");

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
            System.out.print("Válassz egy tesztesetet: ");
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
                System.out.println("Nincs megfelel? függvény ehhez a számhoz.");
            }
        }
      }
}

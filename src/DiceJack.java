import java.util.Scanner;

public class DiceJack {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Escoge 3 números entre 1 y 6 (ambos incluidos):");
        System.out.print("Primer número: ");
        int inputNum1 = input.nextInt();

        System.out.print("Segundo número: ");
        int inputNum2 = input.nextInt();

        System.out.print("Tercer número: ");
        int inputNum3 = input.nextInt();
        input.nextLine();

       boolean isLessThanOne = isLessThanOne(inputNum1, inputNum2, inputNum3);
       boolean isHigherThanSix = isHigherThanSix(inputNum1, inputNum2, inputNum3);

       if (isHigherThanSix || isLessThanOne) {
           System.out.println("Números fuera de rango. Finalizando programa.");
           System.exit(0);
       } else {
           System.out.println("¿Deseas lanzar los dados? Responde con Y(sí) o N(no)");
           String userResponse = input.nextLine();

           if (!userResponse.equalsIgnoreCase("y")) {
               System.out.println("No quieres lanzar los dados. Finalizando programa.");
               System.exit(0);
           } else {
               int generatedNum1 = rollDice();
               int generatedNum2 = rollDice();
               int generatedNum3 = rollDice();
               int sumRollDiceNumber = generatedNum1 + generatedNum2 + generatedNum3;
               int sumUserNumbers = inputNum1 + inputNum2 + inputNum3;
               boolean isTrue = userWon(sumUserNumbers, sumRollDiceNumber);

               if (isTrue) {
                   System.out.println("Has escogido los siguientes números: " + "\n" + inputNum1 + ", " + inputNum2 + ", " + inputNum3);
                   System.out.println("Resultado: " + sumUserNumbers);
                   System.out.println("Números de los dados: " + "\n" + generatedNum1 + ", " + generatedNum2 + ", " + generatedNum3);
                   System.out.println("Resultado: " + sumRollDiceNumber);
                   System.out.println("¡Felicidades, has ganado!");
               } else {
                   System.out.println("¡Oh, has perdido! \n Fin del programa.");
               }
           }

           input.close();

       }


        /*
        Reglas del juego:
        - El usuario debe escoger 3 números entre 1 y 6 (incluidos).
        - El usuario debe lanzar los dados una vez, el resultado serán 3 números aleatorios.

        ¿Cuándo gana el usuario?:
        - Cuando la suma de los números escogidos es mayor a la suma de los dados lanzados
        - Y cuando la diferencia entre los dos números anteriores es menor de 5

        ej. 
        - Usuario escoge los números: 1 3 5 (la suma es 9)
        - Usuario lanza dados y salen los números: 3 1 3 (la suma es 7)
        - 9 es mayor a 7 y la diferencia entre los dos números es menor a 5. El usuario gana.

        Requisitos no funcionales (atributos de calidad):
        - Definir las 4 funciones descritas abajo.
        - En el metodo main escribir el programa (usar condicionales, reusar las funciones creadas,
        pedir al usuario que ingrese datos y recogerlos).
      
        Pasos:
        - Pedir al usuario que escoja 3 números.
        - Si el usuario escoge un número fuera del rango, salir del programa (mira en los recursos system exit).
        - Si los números son correctos, pedir al usuario si desea lanzar dados.
        - Si el usuario dice que no, salir del programa.
        - Si el usuario dice que si, lanzar dados, hacer los cálculos que indiquen si el usuario ganó o perdió.
        - Imprimir la suma de los números escogidos por el usuario y la suma de los números que salieron en los dados.
        - Imprimir si el usuario ganó o perdió.
        */
    }

    /**
     * 
     * Function name: isLessThanOne
     * 
     * @param num1 (int)
     * @param num2 (int)
     * @param num3 (int)
     * @return (boolean)
     * 
     * Inside the function:
     * 1. check if numbers are less than 1
     */
    
    public static boolean isLessThanOne (int num1, int num2, int num3) {
        if (num1 < 1 || num2 < 1 || num3 < 1) {
            return true;
        }
        return false;
    }

    /**
     * 
     * Function name: isHigherThanSix
     * 
     * @param num1 (int)
     * @param num2 (int)
     * @param num3 (int)
     * @return (boolean)
     * 
     * Inside the function:
     * 1. Check if numbers are greater than 6
     */

    public static boolean isHigherThanSix (int num1, int num2, int num3) {
        if (num1 > 6 || num2 > 6 || num3 > 6) {
            return true;
        }
        return false;
    }

    /**
     * 
     * Function name: userWon
     * 
     * @param sumNumbers (int)
     * @param sumDiceRolls (int)
     * @return (boolean)
     * 
     * Inside the function:
     * 1. check if user numbers are greater than computer numbers
     * and the difference between user numbers and computer numbers are less than 5.
     */

    public static boolean userWon (int sumNumbers, int sumDiceRolls) {
        int difference = sumDiceRolls - sumNumbers;
        if (sumNumbers > sumDiceRolls && difference < 5) {
            return true;
        }
        return false;
    }

    /**
     * Function name: rollDice
     * 
     * @return (int)
     * 
     * Inside the function:
     * 1. get random number between 1 and 6
     */

    public static int rollDice () {
        return (int)(Math.random() * 6) + 1;
    }


}

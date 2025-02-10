package es.jorge.uno;

public class Maximo {

    /**
     * Compara dos numeros y me dice cual es mayor
     * @param num1 numero que va a comparar
     * @param num2 numero que va a comparar
     * @return String indicando que numero es mayor
     */
    public static String calcularMaximo(int num1, int num2){

        String respuesta;

        if(num1 > num2){
            respuesta = "El numero " +num1 + " es mayor que " +num2;

        } else if(num1 < num2) {
            respuesta = "El numero " +num2 + " es mayor que " +num1;

        } else if (num1 == num2) {
            respuesta = "El numero " +num1 + " es igual que " +num2;

        } else {
            respuesta = "Error en la comprobacion de los numeros";
        }

        return respuesta;
    }

    public static void main(String[] args) {
        try{
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);

            //Llamada al metodo
            String respuesta = Maximo.calcularMaximo(num1, num2);

            System.out.println(respuesta);


        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Parametros pasados incorrectos");
        }

    }
}
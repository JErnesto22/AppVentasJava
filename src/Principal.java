import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        int eleccion = 1;
        double precio = 0;
        String descripcion;
        Scanner scan = new Scanner(System.in);

        System.out.println("Ingrese el limite de su tarjeta");
        double limite = scan.nextDouble();
        TarjetaDeCredito newTarjeta = new TarjetaDeCredito(limite);

        do {
            System.out.println("Ingrese la descripcion del producto");
            descripcion = scan.next();
            System.out.println("Ingrese el precio del producto");
            precio = Double.valueOf(scan.nextDouble());

            Compra nuevaCompra = new Compra(descripcion , precio);
            boolean compraRealizada = newTarjeta.lanzarCompra(nuevaCompra);

            if (compraRealizada){
                System.out.println("Compra realizada con exito!!");
                System.out.println("Ingrese[1] para seguir comprando o ingrese [0] para salir");
                eleccion = scan.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                eleccion = 0;
            }
        } while (eleccion != 0);




        System.out.println("******************************");
        System.out.println("Sus compras fueron: ");
        Collections.sort(newTarjeta.getListaDeCompras());
        for (Compra compra: newTarjeta.getListaDeCompras()) {
            System.out.println(compra.getDescripcion() + "-" + compra.getValor());
        }
        System.out.println("******************************");

        System.out.println("El saldo en su tarjeta es de: " + newTarjeta.getSaldo());








    }
}

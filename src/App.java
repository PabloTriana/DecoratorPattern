import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        List<Beverage> order = new ArrayList<>();
        boolean continueSale = true;

        Scanner scanner = new Scanner(System.in);

        while (continueSale) {
            System.out.println("Selecciona una bebida:");
            System.out.println("1. House Blend");
            System.out.println("2. Dark Roast");
            System.out.println("3. Decaf");
            System.out.println("4. Espresso");
            System.out.println("5. Cerrar la venta");
            System.out.print(">>>>");
            int option = scanner.nextInt();

            if (option >= 1 && option <= 4) {
                System.out.println("Selecciona los condimentos (0 para finalizar):");
                System.err.println("1. Steamed Milk");
                System.out.println("2. Mocha");
                System.out.println("3. Soy");
                System.out.println("4. Whip");
                System.out.print(">>>>");

                Beverage beverage = null;

                switch (option) {
                    case 1:
                        beverage = new HouseBlend();
                        break;
                    case 2:
                        beverage = new DarkRoast();
                        break;
                    case 3:
                        beverage = new Decaf();
                        break;
                    case 4:
                        beverage = new Espresso();
                        break;
                }

                List<Integer> condimentOptions = new ArrayList<>();

                while (true) {
                    System.out.print(">>>>");
                    int condimentOption = scanner.nextInt();

                    if (condimentOption == 0) {
                        break;
                    }

                    if (condimentOption >= 1 && condimentOption <= 4) {
                        condimentOptions.add(condimentOption);
                    } else {
                        System.out.println("Opción de condimento no válida. Por favor, selecciona nuevamente.");
                    }
                }

                for (int condimentOption : condimentOptions) {
                    switch (condimentOption) {
                        case 1:
                            beverage = new SteamedMilk(beverage);
                            break;
                        case 2:
                            beverage = new Mocha(beverage);
                            break;
                        case 3:
                            beverage = new Soy(beverage);
                            break;
                        case 4:
                            beverage = new Whip(beverage);
                            break;
                    }
                }

                order.add(beverage);
            } else if (option == 5) {
                continueSale = false;
            } else {
                System.out.println("Opción no válida. Por favor, selecciona nuevamente.");
            }
        }

        // Generar el ticket
        double subtotal = 0.0;
        System.out.println("********************BIENVENIDO***************");
        System.out.println("******Cafeteria El Patron pero de diseño******");
        System.out.println("Cantidad\tDescripción\tTotal");
        for (Beverage beverage : order) {
            String description = beverage.getDescription();
            double cost = beverage.cost();
            subtotal += cost;
            System.out.printf("1\t%s\t%.2f%n", description, cost);
        }

        double iva = subtotal * 0.16;
        double total = subtotal + iva;

        System.out.printf("\nSubtotal: %.2f%n", subtotal);
        System.out.printf("IVA (16%%): %.2f%n", iva);
        System.out.printf("Total: %.2f%n", total);
        System.out.println("********************GRACIAS POR SU COMPRA***************");
        System.out.println("Atendido por: Jose Pablo Triana Corvera - C18210381");

        /*
         * Beverage cafe = new HouseBlend();
         * cafe = new SteamedMilk(cafe);
         * 
         * Beverage cafe2 = new DarkRoast();
         * cafe2 = new Mocha(cafe2);
         * 
         * Beverage cafe3 = new Decaf();
         * cafe3 = new Soy(cafe3);
         * 
         * Beverage cafe4 = new Espresso();
         * cafe4 = new Whip(cafe4);
         * 
         * System.out.println(cafe.getDescription() + " $" + cafe.cost());
         * System.out.println(cafe2.getDescription() + " $" + cafe2.cost());
         * System.out.println(cafe3.getDescription() + " $" + cafe3.cost());
         * System.out.println(cafe4.getDescription() + " $" + cafe4.cost());
         * 
         * Scanner scanner = new Scanner(System.in);
         * 
         * int option = 0;
         * 
         * do{
         * System.out.println("********************BIENVENIDO***************");
         * System.out.println("******Cafeteria El Patron pero de diseño******");
         * System.out.println("Presione 1 para ordernar");
         * System.out.println("Presione 2 para terminar orden");
         * System.out.print("Ingrese una opcion:");
         * option = scanner.nextInt();
         * 
         * 
         * 
         * }while(option != 2);
         * 
         * 
         */
    }
}

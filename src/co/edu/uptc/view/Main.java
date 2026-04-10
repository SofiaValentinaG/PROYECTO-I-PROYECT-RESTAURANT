package co.edu.uptc.view;

import javax.swing.JOptionPane;
import co.edu.uptc.cruds.data.*;

public class Main {
    public static void main(String[] args) {

        CrudClient crudClient = new CrudClient();
        CrudEmployee crudEmployee = new CrudEmployee();
        CrudProduct crudProduct = new CrudProduct();
        CrudRestaurant crudRestaurant = new CrudRestaurant();
        CrudOrder crudOrder = new CrudOrder(crudClient, crudEmployee, crudProduct, crudRestaurant);

        boolean flag = true;

        while (flag) {
            String input = JOptionPane.showInputDialog(
                null,
                "[1] Clientes\n"
                + "[2] Empleados\n"
                + "[3] Productos\n"
                + "[4] Órdenes\n"
                + "[5] Restaurantes\n"
                + "[6] Salir",
                "MENÚ PRINCIPAL",
                JOptionPane.INFORMATION_MESSAGE
            );

            if (input == null) break;

            try {
                switch (Integer.parseInt(input)) {
                    case 1: crudClient.menu();     break;
                    case 2: crudEmployee.menu();   break;
                    case 3: crudProduct.menu();    break;
                    case 4: crudOrder.menu();      break;
                    case 5: crudRestaurant.menu(); break;
                    case 6: flag = false;          break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida",
                            "Error", JOptionPane.ERROR_MESSAGE);
                        break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingresa un número válido",
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

        JOptionPane.showMessageDialog(null, "Programa finalizado. ¡Hasta luego!");
    }
}
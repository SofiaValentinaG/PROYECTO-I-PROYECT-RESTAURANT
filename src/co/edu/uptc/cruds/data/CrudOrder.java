package co.edu.uptc.cruds.data;

import co.edu.uptc.cruds.enums.Status;
import co.edu.uptc.cruds.model.*;
import com.toedter.calendar.JDateChooser;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrudOrder extends AbstractCrud<Order> {
    private List<Order> orders;
    private CrudClient crudClient;
    private CrudEmployee crudEmployee;
    private CrudProduct crudProduct;
    private CrudRestaurant crudRestaurant;

    public CrudOrder(CrudClient crudClient, CrudEmployee crudEmployee,
                     CrudProduct crudProduct, CrudRestaurant crudRestaurant) {
        super("orden");
        this.orders = new ArrayList<>();
        this.crudClient = crudClient;
        this.crudEmployee = crudEmployee;
        this.crudProduct = crudProduct;
        this.crudRestaurant = crudRestaurant;
    }

    @Override
    protected Order createInstance() {
        int clientId = Integer.parseInt(JOptionPane.showInputDialog(null, "ID del cliente:", "Nueva orden", JOptionPane.INFORMATION_MESSAGE));
        int employeeId = Integer.parseInt(JOptionPane.showInputDialog(null, "ID del empleado:", "Nueva orden", JOptionPane.INFORMATION_MESSAGE));
        int restaurantId = Integer.parseInt(JOptionPane.showInputDialog(null, "ID del restaurante:", "Nueva orden", JOptionPane.INFORMATION_MESSAGE));

        Client client = crudClient.findRecordById(clientId);
        Employee employee = crudEmployee.findRecordById(employeeId);
        Restaurant restaurant = crudRestaurant.findRecordById(restaurantId);

        if (client == null || employee == null || restaurant == null) {
            JOptionPane.showMessageDialog(null, "Cliente, empleado o restaurante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        String deliveryAddress = JOptionPane.showInputDialog(null, "Dirección de entrega:", "Nueva orden", JOptionPane.INFORMATION_MESSAGE);
        String paymentMethod = JOptionPane.showInputDialog(null, "Método de pago (EFECTIVO/TARJETA):", "Nueva orden", JOptionPane.INFORMATION_MESSAGE);
        String createdBy = JOptionPane.showInputDialog(null, "Creado por (usuario):", "Nueva orden", JOptionPane.INFORMATION_MESSAGE);

        JDateChooser dateChooser = new JDateChooser();
        JOptionPane.showConfirmDialog(null, dateChooser, "Fecha de la orden", JOptionPane.OK_CANCEL_OPTION);
        Date timeOrder = dateChooser.getDate();

        return new Order(client, employee, restaurant, Status.PENDING,
                         timeOrder, deliveryAddress, paymentMethod, createdBy, new Date());
    }

    @Override
    protected Order createUpdatedInstance(Order current) {
        String[] statuses = {"PENDING", "IN_PREPARATION", "DELIVERED"};
        String chosen = (String) JOptionPane.showInputDialog(null,
            "Nuevo estado (" + current.getStatus() + "):", "Actualizar orden",
            JOptionPane.QUESTION_MESSAGE, null, statuses, current.getStatus().name());

        String deliveryAddress = JOptionPane.showInputDialog(null,
            "Nueva dirección entrega (" + current.getDeliveryAddress() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        String paymentMethod = JOptionPane.showInputDialog(null,
            "Nuevo método de pago (" + current.getPaymentMethod() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);

        if (chosen != null) current.setStatus(Status.valueOf(chosen));
        current.setDeliveryAddress(deliveryAddress);
        current.setPaymentMethod(paymentMethod);
        current.setUpdatedAt(new Date());

        return current;
    }

    @Override
    protected boolean newRecord(Order record) {
        if (record == null) return false;
        orders.add(record);
        return true;
    }

    @Override
    protected Order findRecordById(int id) {
        for (Order o : orders) {
            if (o.getId() == id) return o;
        }
        return null;
    }

    @Override
    protected boolean updateRecord(Order o) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == o.getId()) {
                orders.set(i, o);
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return orders.removeIf(o -> o.getId() == id);
    }
}
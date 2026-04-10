package co.edu.uptc.cruds.data;

import co.edu.uptc.cruds.model.Restaurant;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrudRestaurant extends AbstractCrud<Restaurant> {
    private List<Restaurant> restaurants;

    public CrudRestaurant() {
        super("restaurante");
        this.restaurants = new ArrayList<>();
    }

    @Override
    protected Restaurant createInstance() {
        String name = JOptionPane.showInputDialog(null, "Nombre del restaurante:", "Nuevo restaurante", JOptionPane.INFORMATION_MESSAGE);
        String address = JOptionPane.showInputDialog(null, "Dirección:", "Nuevo restaurante", JOptionPane.INFORMATION_MESSAGE);
        String telephone = JOptionPane.showInputDialog(null, "Teléfono:", "Nuevo restaurante", JOptionPane.INFORMATION_MESSAGE);
        String typeKitchen = JOptionPane.showInputDialog(null, "Tipo de cocina:", "Nuevo restaurante", JOptionPane.INFORMATION_MESSAGE);
        double score = Double.parseDouble(JOptionPane.showInputDialog(null, "Calificación (0.0 - 5.0):", "Nuevo restaurante", JOptionPane.INFORMATION_MESSAGE));
        String openingHours = JOptionPane.showInputDialog(null, "Horario (ej: 8am-10pm):", "Nuevo restaurante", JOptionPane.INFORMATION_MESSAGE);
        String createdBy = JOptionPane.showInputDialog(null, "Creado por (usuario):", "Nuevo restaurante", JOptionPane.INFORMATION_MESSAGE);

        return new Restaurant(name, address, telephone, typeKitchen, score, openingHours, createdBy, new Date());
    }

    @Override
    protected Restaurant createUpdatedInstance(Restaurant current) {
        String name = JOptionPane.showInputDialog(null, "Nuevo nombre (" + current.getName() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        String address = JOptionPane.showInputDialog(null, "Nueva dirección (" + current.getAddress() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        String telephone = JOptionPane.showInputDialog(null, "Nuevo teléfono (" + current.getTelephone() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        String typeKitchen = JOptionPane.showInputDialog(null, "Nuevo tipo de cocina (" + current.getTypeKitchen() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        double score = Double.parseDouble(JOptionPane.showInputDialog(null, "Nueva calificación (" + current.getScore() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE));
        String openingHours = JOptionPane.showInputDialog(null, "Nuevo horario (" + current.getOpeningHours() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);

        current.setName(name);
        current.setAddress(address);
        current.setTelephone(telephone);
        current.setTypeKitchen(typeKitchen);
        current.setScore(score);
        current.setOpeningHours(openingHours);
        current.setUpdatedAt(new Date());

        return current;
    }

    @Override
    protected boolean newRecord(Restaurant record) {
        if (record == null) return false;
        restaurants.add(record);
        return true;
    }

    @Override
    protected Restaurant findRecordById(int id) {
        for (Restaurant r : restaurants) {
            if (r.getId() == id) return r;
        }
        return null;
    }

    @Override
    protected boolean updateRecord(Restaurant r) {
        for (int i = 0; i < restaurants.size(); i++) {
            if (restaurants.get(i).getId() == r.getId()) {
                restaurants.set(i, r);
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return restaurants.removeIf(r -> r.getId() == id);
    }

    public List<Restaurant> getRestaurants() { return restaurants; }
}
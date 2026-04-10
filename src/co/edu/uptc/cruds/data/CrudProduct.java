package co.edu.uptc.cruds.data;

import co.edu.uptc.cruds.model.Product;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CrudProduct extends AbstractCrud<Product> {
    private List<Product> products;

    public CrudProduct() {
        super("producto");
        this.products = new ArrayList<>();
    }

    @Override
    protected Product createInstance() {
        String name = JOptionPane.showInputDialog(null, "Nombre del producto:", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE);
        String description = JOptionPane.showInputDialog(null, "Descripción:", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE);
        double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Precio:", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE));
        String category = JOptionPane.showInputDialog(null, "Categoría (ej: Entrada/Plato fuerte/Postre):", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE);
        boolean isAvailable = JOptionPane.showConfirmDialog(null, "¿Está disponible?", "Disponibilidad", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        String createdBy = JOptionPane.showInputDialog(null, "Creado por (usuario):", "Nuevo producto", JOptionPane.INFORMATION_MESSAGE);

        return new Product(name, description, price, category, isAvailable, createdBy, new Date());
    }

    @Override
    protected Product createUpdatedInstance(Product current) {
        String name = JOptionPane.showInputDialog(null, "Nuevo nombre (" + current.getName() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        String description = JOptionPane.showInputDialog(null, "Nueva descripción:", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        double price = Double.parseDouble(JOptionPane.showInputDialog(null, "Nuevo precio (" + current.getPrice() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE));
        String category = JOptionPane.showInputDialog(null, "Nueva categoría (" + current.getCategory() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        boolean isAvailable = JOptionPane.showConfirmDialog(null, "¿Disponible?", "Disponibilidad", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        current.setName(name);
        current.setDescription(description);
        current.setPrice(price);
        current.setCategory(category);
        current.setAvailable(isAvailable);
        current.setUpdatedAt(new Date());

        return current;
    }

    @Override
    protected boolean newRecord(Product record) {
        if (record == null) return false;
        products.add(record);
        return true;
    }

    @Override
    protected Product findRecordById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    @Override
    protected boolean updateRecord(Product p) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == p.getId()) {
                products.set(i, p);
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return products.removeIf(p -> p.getId() == id);
    }

    public List<Product> getProducts() { return products; }
}
package co.edu.uptc.cruds.data;
import java.util.Date;
import co.edu.uptc.cruds.model.Client;

import javax.swing.JOptionPane;
import java.util.ArrayList;

import java.util.List;
import com.toedter.calendar.JDateChooser;



public class CrudClient extends AbstractCrud<Client> {
    private List<Client> clients;

    public CrudClient() {
        super("cliente");
        this.clients = new ArrayList<>();
    }

    @Override
    protected Client createInstance() {
        String name = JOptionPane.showInputDialog(null, "Nombre:", "Nuevo cliente", JOptionPane.INFORMATION_MESSAGE);
        String telephone = JOptionPane.showInputDialog(null, "Teléfono:", "Nuevo cliente", JOptionPane.INFORMATION_MESSAGE);
        String address = JOptionPane.showInputDialog(null, "Dirección:", "Nuevo cliente", JOptionPane.INFORMATION_MESSAGE);
        String email = JOptionPane.showInputDialog(null, "Email:", "Nuevo cliente", JOptionPane.INFORMATION_MESSAGE);
        String membership = JOptionPane.showInputDialog(null, "Tipo membresía (BÁSICA/PREMIUM):", "Nuevo cliente", JOptionPane.INFORMATION_MESSAGE);
        boolean isVip = JOptionPane.showConfirmDialog(null, "¿Es cliente VIP?", "VIP", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
        String createdBy = JOptionPane.showInputDialog(null, "Creado por (usuario):", "Nuevo cliente", JOptionPane.INFORMATION_MESSAGE);

        JDateChooser dateChooser = new JDateChooser();
        JOptionPane.showConfirmDialog(null, dateChooser, "Fecha de nacimiento", JOptionPane.OK_CANCEL_OPTION);
        Date birthdate = dateChooser.getDate();

        return new Client(name, telephone, birthdate, address, email,
                          membership, isVip, createdBy, new Date());
    }

    @Override
    protected Client createUpdatedInstance(Client current) {
        String name = JOptionPane.showInputDialog(null, "Nuevo nombre (" + current.getName() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        String telephone = JOptionPane.showInputDialog(null, "Nuevo teléfono (" + current.getTelephone() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        String email = JOptionPane.showInputDialog(null, "Nuevo email (" + current.getEmail() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        String membership = JOptionPane.showInputDialog(null, "Nueva membresía (" + current.getMembershipType() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        boolean isVip = JOptionPane.showConfirmDialog(null, "¿Es VIP?", "VIP", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        current.setName(name);
        current.setTelephone(telephone);
        current.setEmail(email);
        current.setMembershipType(membership);
        current.setVip(isVip);
        current.setUpdatedAt(new Date());

        return current;
    }

    @Override
    protected boolean newRecord(Client record) {
        if (record == null) return false;
        clients.add(record);
        return true;
    }

    @Override
    protected Client findRecordById(int id) {
        for (Client c : clients) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    @Override
    protected boolean updateRecord(Client c) {
        for (int i = 0; i < clients.size(); i++) {
            if (clients.get(i).getId() == c.getId()) {
                clients.set(i, c);
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return clients.removeIf(c -> c.getId() == id);
    }

    public List<Client> getClients() { return clients; }
}
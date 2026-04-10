package co.edu.uptc.cruds.data;

import co.edu.uptc.cruds.model.Employee;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import com.toedter.calendar.JDateChooser;

public class CrudEmployee extends AbstractCrud<Employee> {
    private List<Employee> employees;

    public CrudEmployee() {
        super("empleado");
        this.employees = new ArrayList<>();
    }

    @Override
    protected Employee createInstance() {
        String name = JOptionPane.showInputDialog(null, "Nombre:", "Nuevo empleado", JOptionPane.INFORMATION_MESSAGE);
        String telephone = JOptionPane.showInputDialog(null, "Teléfono:", "Nuevo empleado", JOptionPane.INFORMATION_MESSAGE);
        String address = JOptionPane.showInputDialog(null, "Dirección:", "Nuevo empleado", JOptionPane.INFORMATION_MESSAGE);
        String email = JOptionPane.showInputDialog(null, "Email:", "Nuevo empleado", JOptionPane.INFORMATION_MESSAGE);
        String position = JOptionPane.showInputDialog(null, "Cargo:", "Nuevo empleado", JOptionPane.INFORMATION_MESSAGE);
        double salary = Double.parseDouble(JOptionPane.showInputDialog(null, "Salario:", "Nuevo empleado", JOptionPane.INFORMATION_MESSAGE));
        String schedule = JOptionPane.showInputDialog(null, "Horario (ej: 8am-4pm):", "Nuevo empleado", JOptionPane.INFORMATION_MESSAGE);
        String contractType = JOptionPane.showInputDialog(null, "Tipo contrato (FIJO/TEMPORAL):", "Nuevo empleado", JOptionPane.INFORMATION_MESSAGE);
        String createdBy = JOptionPane.showInputDialog(null, "Creado por (usuario):", "Nuevo empleado", JOptionPane.INFORMATION_MESSAGE);

        JDateChooser dateChooser = new JDateChooser();
        JOptionPane.showConfirmDialog(null, dateChooser, "Fecha de nacimiento", JOptionPane.OK_CANCEL_OPTION);
        Date birthdate = dateChooser.getDate();

        return new Employee(name, telephone, birthdate, address, email,
                            position, salary, schedule, contractType, createdBy, new Date());
    }

    @Override
    protected Employee createUpdatedInstance(Employee current) {
        String name = JOptionPane.showInputDialog(null, "Nuevo nombre (" + current.getName() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        String telephone = JOptionPane.showInputDialog(null, "Nuevo teléfono (" + current.getTelephone() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        String position = JOptionPane.showInputDialog(null, "Nuevo cargo (" + current.getPosition() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);
        double salary = Double.parseDouble(JOptionPane.showInputDialog(null, "Nuevo salario (" + current.getSalary() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE));
        String schedule = JOptionPane.showInputDialog(null, "Nuevo horario (" + current.getSchedule() + "):", "Actualizar", JOptionPane.INFORMATION_MESSAGE);

        current.setName(name);
        current.setTelephone(telephone);
        current.setPosition(position);
        current.setSalary(salary);
        current.setSchedule(schedule);
        current.setUpdatedAt(new Date());

        return current;
    }

    @Override
    protected boolean newRecord(Employee record) {
        if (record == null) return false;
        employees.add(record);
        return true;
    }

    @Override
    protected Employee findRecordById(int id) {
        for (Employee e : employees) {
            if (e.getId() == id) return e;
        }
        return null;
    }

    @Override
    protected boolean updateRecord(Employee e) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == e.getId()) {
                employees.set(i, e);
                return true;
            }
        }
        return false;
    }

    @Override
    protected boolean deleteRecord(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }

    public List<Employee> getEmployees() { return employees; }
}

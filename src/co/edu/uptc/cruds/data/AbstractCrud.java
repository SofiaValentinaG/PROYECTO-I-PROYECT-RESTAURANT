package co.edu.uptc.cruds.data;

import javax.swing.JOptionPane;
import co.edu.uptc.cruds.model.BaseClass;

public abstract class AbstractCrud<T extends BaseClass> {
    private String nameEntity;

    public AbstractCrud(String nameEntity) {
        this.nameEntity = nameEntity;
    }

    public void menu() {
        boolean flag = true;
        while (flag) {
            int operacion = Integer.parseInt(JOptionPane.showInputDialog(
                null,
                "[1] Crear " + nameEntity + "\n[2] Buscar " + nameEntity
                + "\n[3] Actualizar " + nameEntity + "\n[4] Eliminar " + nameEntity
                + "\n[5] Salir al menú principal",
                " ------- MENU DE " + nameEntity.toUpperCase() + " -------",
                JOptionPane.INFORMATION_MESSAGE
            ));

            switch (operacion) {
                case 1:
                    T recordCreate = this.createInstance();
                    if (recordCreate != null && this.newRecord(recordCreate)) {
                        JOptionPane.showMessageDialog(null,
                            "Se agregó el registro con ID: " + recordCreate.getId(),
                            "Creación del registro", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se agregó el registro",
                            "Creación del registro", JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 2:
                    int idFind = Integer.parseInt(JOptionPane.showInputDialog(
                        null, "Digite el ID del registro:",
                        "Búsqueda de " + nameEntity, JOptionPane.INFORMATION_MESSAGE));
                    T record = this.findRecordById(idFind);
                    if (record != null) {
                        JOptionPane.showMessageDialog(null, record.toString(),
                            "Búsqueda de " + nameEntity, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "El registro no fue encontrado",
                            "Búsqueda de " + nameEntity, JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 3:
                    int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(
                        null, "Digite el ID del registro a actualizar:",
                        "Actualización de " + nameEntity, JOptionPane.INFORMATION_MESSAGE));
                    T recordUpdate = this.findRecordById(idUpdate);
                    if (recordUpdate != null) {
                        T updatedRecord = this.createUpdatedInstance(recordUpdate);
                        if (updatedRecord != null && this.updateRecord(updatedRecord)) {
                            JOptionPane.showMessageDialog(null, "El registro fue actualizado",
                                "Actualización de " + nameEntity, JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "No se pudo actualizar",
                                "Actualización de " + nameEntity, JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El registro no existe",
                            "Actualización de " + nameEntity, JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 4:
                    int idDelete = Integer.parseInt(JOptionPane.showInputDialog(
                        null, "Digite el ID del registro a eliminar:",
                        "Eliminación de " + nameEntity, JOptionPane.INFORMATION_MESSAGE));
                    if (this.deleteRecord(idDelete)) {
                        JOptionPane.showMessageDialog(null, "Registro eliminado con éxito.",
                            "Eliminación de " + nameEntity, JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(null, "No se encontró el registro.",
                            "Eliminación de " + nameEntity, JOptionPane.ERROR_MESSAGE);
                    }
                    break;

                case 5:
                    flag = false;
                    break;
            }
        }
    }

    protected abstract boolean newRecord(T record);
    protected abstract T findRecordById(int id);
    protected abstract boolean updateRecord(T t);
    protected abstract T createInstance();
    protected abstract T createUpdatedInstance(T current);
    protected abstract boolean deleteRecord(int id);
}
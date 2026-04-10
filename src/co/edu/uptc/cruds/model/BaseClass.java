package co.edu.uptc.cruds.model;

import java.util.Date;

public class BaseClass {
    protected int id;
    protected String createdBy;      // quién creó el registro
    protected Date createdAt;        // cuándo se creó
    protected Date updatedAt;        // última actualización
    protected boolean isActive;      // si el registro está activo o fue "eliminado"

    public BaseClass() {}

    public BaseClass(int id, String createdBy, Date createdAt) {
        this.id = id;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
        this.isActive = true;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCreatedBy() { return createdBy; }
    public void setCreatedBy(String createdBy) { this.createdBy = createdBy; }

    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }

    public Date getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(Date updatedAt) { this.updatedAt = updatedAt; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean isActive) { this.isActive = isActive; }

    @Override
    public String toString() {
        return "BaseClass [id=" + id + ", creadoPor=" + createdBy +
               ", creadoEn=" + createdAt + ", activo=" + isActive + "]";
    }
}
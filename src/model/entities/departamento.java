package model.entities;


import java.io.Serializable;
import java.util.Objects;

public class departamento implements Serializable {
    private Integer id;
    private String name;

    public departamento(){

    }
    public departamento(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        departamento that = (departamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "departamento[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ']';
    }
}

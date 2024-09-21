package model.entities;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class seller implements Serializable {
   private Integer id;
   private String name;
   private String email;
   private Date nascimento;
   private double salario;

   private departamento dep ;

   public seller(){

   }

    public seller(Integer id, String name, String email, Date nascimento, double salario, departamento dep) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.nascimento = nascimento;
        this.salario = salario;
        this.dep = dep;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public departamento getDep() {
        return dep;
    }

    public void setDep(departamento dep) {
        this.dep = dep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        seller seller = (seller) o;
        return Objects.equals(id, seller.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "seller[" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nascimento=" + nascimento +
                ", salario=" + salario +
                ", dep=" + dep +
                ']';
    }
}

package vijay.fsad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "product")
public class Sekhar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;

    private int quant;
    private int price;
    private String Name;
    private String des;

    public int getId() {
        return Id;
    }
    public void setId(int id) {
        Id = id;
    }
    public int getQuant() {
        return quant;
    }
    public void setQuant(int quant) {
        this.quant = quant;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getDes() {
        return des;
    }
    public void setDes(String des) {
        this.des = des;
    }
}

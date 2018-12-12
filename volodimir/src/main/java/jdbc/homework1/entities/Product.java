package jdbc.homework1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
//@Entity

public class Product extends AbstractEntity {
    private String type;
    private String name;
    private String producer;
    private Integer price;

    public Product(Integer id, String type, String name, String producer, Integer price) {
        super(id);
        this.type = type;
        this.name = name;
        this.producer = producer;
        this.price = price;
    }
}

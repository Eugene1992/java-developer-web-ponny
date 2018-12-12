package jdbc.homework1.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractEntity {
    //    @PrimeryId(name = "id")
    protected Integer id;
}

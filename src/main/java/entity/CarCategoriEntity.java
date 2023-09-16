package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.ToString.Exclude;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "ar_category_info")
public class CarCategoriEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Category_ID",nullable = false)
    private Integer categoryid;

    @Column(name = "Catogery_Name",nullable = false)
    private String name;


    public CarCategoriEntity(String name) {
        this.name = name;
    }

    @ToString.Exclude
    @OneToMany(mappedBy = "carCategoryEntity",targetEntity = CarEntity.class)
    private List<CarEntity> carEntities;
}

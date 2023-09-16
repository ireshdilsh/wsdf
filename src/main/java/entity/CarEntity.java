package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "car_info")
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CarID",nullable = false)
    private Integer carid;

    @Column(name = "Brand",nullable = false)
    private String brand;

    @Column(name = "Model",nullable = false)
    private String model;

    @Column(name = "Vehicle_NO",nullable = false,length = 4)
    private Integer vehino;

    @Column(name = "Year",nullable = false)
    private String year;

    @Column(name = "PricePerDay",nullable = false)
    private Double priceperday;

    @OneToMany(mappedBy = "carEntity", targetEntity = RentEntity.class)
    private List<RentEntity> rentEntityList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Category_ID",nullable = false)
    private CarCategoriEntity carCategoryEntity;
}

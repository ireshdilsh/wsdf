package entity;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer_info")
public class CustomerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CustID",nullable = false)
    private Integer custid;

    @Column(name = "NIC",nullable = false,length = 12)
    private Double nic;

    @Column(name = "Name",nullable = false)
    private String name;

    @Column(name = "Address",nullable = false)
    private String address;

    @Column(name = "MobileNO",nullable = false,length = 9)
    private Double mobileno;

    @ToString.Exclude

    @OneToMany(mappedBy = "customerEntity", targetEntity = RentEntity.class)
    private List<RentEntity> rentEntityList;

    public CustomerEntity(Double nic, String name, String address, Double mobileno) {
        this.nic = nic;
        this.name = name;
        this.address = address;
        this.mobileno = mobileno;
    }
}


package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "rent_info")
public class RentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Rent_ID",nullable = false)
    private Integer rentid;

    @Column(name = "From_Date",columnDefinition = "date",nullable = false)
    private Date from_date;

    @Column(name = "To_Date",columnDefinition = "date",nullable = false)
    private Date to_date;

    @Column(name = "Total",nullable = false)
    private Double total;

    @Column(name = "IsReturn",nullable = false)
    private boolean isreturn;

    @Column(name = "Balance",nullable = false)
    private Double balance;

    @Column(name = "Deposit",nullable = false)
    private Double refundeposit;

    @Column(name = "Advanced",nullable = false)
    private Double advancespay;

    @Column(name = "PerDayRent",nullable = false)
    private Double perdayrent;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CustID", nullable = false)
    private CustomerEntity customerEntity;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CarID", nullable = false)
    private CarEntity carEntity;


}

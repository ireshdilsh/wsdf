package entity;

import lombok.*;

import javax.persistence.*;

@Setter
@ToString
@Getter
@NoArgsConstructor
@Entity
@Table(name = "user_info")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserID",nullable = false)
    private Integer id;

    @Column(name = "Name",length = 20,nullable = false)
    private String name;

    @Column(name = "Address",nullable = false)
    private String address;

    @Column(name ="Email" ,nullable = false)
    private String email;

    @Column(name = "Username",length = 10,nullable = false)
    private String username;

    @Column(name = "Password",length = 8,nullable = false)
    private String password;


    public UserEntity(String name, String address, String email, String username, String password) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.username = username;
        this.password = password;
    }

}

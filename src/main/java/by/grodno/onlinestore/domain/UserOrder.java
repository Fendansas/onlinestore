package by.grodno.onlinestore.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "user_order")
public class UserOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User user;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_date")
    private Date createdDate;

    // адрес доставки----------------- может стоит вынести в отдельный класс?
    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "house_number")
    private String houseNumber;

    @Column(name = "place_number")
    private String placeNumber;
    //-------------------------------

    @NotNull
    @Column(name = "total_price")
    private BigDecimal totalPrice = BigDecimal.ZERO;
    // проблема тут
    @OneToMany(cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();

    private OrderStatus status = OrderStatus.PROCESSING;


}

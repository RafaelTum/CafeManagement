package com.cafemanagment.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "product_order")
public class ProductInOrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "prod_id")
    private ProductEntity product;

    private long amount;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductInOrderStatus status;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ProductEntity getProductEntity() {
        return product;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.product = productEntity;
    }

    public OrderEntity getOrderEntity() {
        return order;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.order = orderEntity;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public ProductInOrderStatus getStatus() {
        return status;
    }

    public void setStatus(ProductInOrderStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductInOrderEntity that = (ProductInOrderEntity) o;

        if (id != that.id) return false;
        if (amount != that.amount) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        if (product != null ? !product.equals(that.product) : that.product != null) return false;
        return status == that.status;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (int) (amount ^ (amount >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}

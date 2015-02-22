package by.bsu.model;

public class OrderCarAcc {
    private Order order;
    private Car car;
    private Account account;

    public OrderCarAcc() {
        order = new Order();
        car = new Car();
        account = new Account();
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

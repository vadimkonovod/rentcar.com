package by.bsu.model;

import java.sql.Date;

public class Order {
    private int id;
    private int accId;
    private int carId;
    private Date startDate;
    private Date finishDate;

    public Order() {
    }

    public Order(int accId, int carId, Date startDate, Date finishDate) {
        this.accId = accId;
        this.carId = carId;
        this.startDate = startDate;
        this.finishDate = finishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccId() {
        return accId;
    }

    public void setAccId(int accId) {
        this.accId = accId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Order{");
        sb.append("id=").append(id);
        sb.append(", accId=").append(accId);
        sb.append(", carId=").append(carId);
        sb.append(", startDate=").append(startDate);
        sb.append(", finishDate=").append(finishDate);
        sb.append('}');
        return sb.toString();
    }
}

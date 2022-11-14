package Booking;

public abstract class Ticket {

    private String depStation, arrStation; // Will need changing to Station obj
    private String passType, time, date, qrCode;
    private int passQuantity, refNumber;
    protected double price;

    public void setDepStation(String depStation){
        this.depStation = depStation;
    }

    public String getDepStation(){
        return depStation;
    }

    public void setArrStation(String arrStation){
        this.arrStation = arrStation;
    }

    public String getArrStation(){
        return arrStation;
    }

    public void setPassType(String passType){
        this.passType = passType;
    }

    public String getPassType(){
        return passType;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return time;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setQrCode(String qrCode){
        this.qrCode = qrCode;
    }

    public String getQrCode(){
        return qrCode;
    }

    public void setPassQuantity(int passQuantity){
        this.passQuantity = passQuantity;
    }

    public int getPassQuantity(){
        return passQuantity;
    }

    public void setRefNumber(int refNumber){ 
        this.refNumber = refNumber;         
    }           

    public int getRefNumber(){
        return refNumber;
    }


    public void setPrice(double price){ 
        this.price = price;         
    } 
    
    
    public abstract double getPrice();

    public abstract double getTimeLimit();

}
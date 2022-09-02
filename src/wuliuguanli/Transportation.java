package wuliuguanli;

public abstract class Transportation {
    private String carrier;
    private String carnumber;
    private String carmodel;
    public abstract void transport();
    public Transportation(){
    }
    public Transportation(String carrier,String carnumber,String carmodel){
        this.carrier=carrier;
        this.carnumber=carnumber;
        this.carmodel=carmodel;
    }
    public abstract void transportation();
    public String getCarrier(){
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }
    public String getCarnumber(){
        return carnumber;
    }
    public void setCarnumber(String carnumber) {
        this.carnumber = carnumber;
    }
    public String getCarmodel(){
        return carmodel;
    }
    public void setCarmodel(String carmodel) {
        this.carmodel = carmodel;
}
}


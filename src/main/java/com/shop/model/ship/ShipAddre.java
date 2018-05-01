package com.shop.model.ship;

public class ShipAddre {
    private Integer shipid;

    public Integer getShipid() {
        return shipid;
    }

    public void setShipid(Integer shipid) {
        this.shipid = shipid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getShipusername() {
        return shipusername;
    }

    public void setShipusername(String shipusername) {
        this.shipusername = shipusername;
    }

    public String getShipusermobile() {
        return shipusermobile;
    }

    public void setShipusermobile(String shipusermobile) {
        this.shipusermobile = shipusermobile;
    }

    public String getShipaddress() {
        return shipaddress;
    }

    public void setShipaddress(String shipaddress) {
        this.shipaddress = shipaddress;
    }

    public Integer getShipisdefault() {
        return shipisdefault;
    }

    public void setShipisdefault(Integer shipisdefault) {
        this.shipisdefault = shipisdefault;
    }

    private Integer userid;
    private String shipusername;
    private String shipusermobile;
    private String shipaddress;
    private Integer shipisdefault;
}

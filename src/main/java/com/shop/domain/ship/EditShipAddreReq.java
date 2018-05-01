package com.shop.domain.ship;

public class EditShipAddreReq {
    /**
     * shipAddre : {"shipaddress":"饿饭方向感","shipid":2,"shipisdefault":1,"shipusermobile":"15425554","shipusername":"讨厌你","userid":1}
     */
    private ShipAddreBean shipAddre;

    public ShipAddreBean getShipAddre() {
        return shipAddre;
    }

    public void setShipAddre(ShipAddreBean shipAddre) {
        this.shipAddre = shipAddre;
    }

    public static class ShipAddreBean {
        /**
         * shipaddress : 饿饭方向感
         * shipid : 2
         * shipisdefault : 1
         * shipusermobile : 15425554
         * shipusername : 讨厌你
         * userid : 1
         */

        private String shipaddress;
        private int shipid;
        private int shipisdefault;
        private String shipusermobile;
        private String shipusername;
        private int userid;

        public String getShipaddress() {
            return shipaddress;
        }

        public void setShipaddress(String shipaddress) {
            this.shipaddress = shipaddress;
        }

        public int getShipid() {
            return shipid;
        }

        public void setShipid(int shipid) {
            this.shipid = shipid;
        }

        public int getShipisdefault() {
            return shipisdefault;
        }

        public void setShipisdefault(int shipisdefault) {
            this.shipisdefault = shipisdefault;
        }

        public String getShipusermobile() {
            return shipusermobile;
        }

        public void setShipusermobile(String shipusermobile) {
            this.shipusermobile = shipusermobile;
        }

        public String getShipusername() {
            return shipusername;
        }

        public void setShipusername(String shipusername) {
            this.shipusername = shipusername;
        }

        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }
    }
}

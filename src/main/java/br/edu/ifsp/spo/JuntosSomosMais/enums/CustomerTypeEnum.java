package br.edu.ifsp.spo.JuntosSomosMais.enums;

public enum CustomerTypeEnum {
    NORMAL, SPECIAL, LABORIOUS;

    public static CustomerTypeEnum defineCustomerTypeEnum(float lat, float lon) {

        if(lon > -2.196998 && lat > -46.361899 && lon < -15.411580 && lat < -34.276938) {
            return CustomerTypeEnum.SPECIAL;
        } else if (lon > -26.155681 && lat > -54.777426 && lon < -34.016466 && lat < -46.603598) {
            return CustomerTypeEnum.NORMAL;
        } else {
            return CustomerTypeEnum.LABORIOUS;
        }

    }
}

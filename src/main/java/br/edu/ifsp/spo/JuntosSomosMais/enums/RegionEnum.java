package br.edu.ifsp.spo.JuntosSomosMais.enums;

import java.util.HashMap;
import java.util.Map;

public enum RegionEnum {
    NORTE, NORDESTE, CENTRO_OESTE, SUL, SUDESTE;

    private static Map<StateEnum, RegionEnum> stateRegionMap = new HashMap<>();

    static {
        stateRegionMap.put(StateEnum.ACRE, RegionEnum.NORTE);
        stateRegionMap.put(StateEnum.ALAGOAS, RegionEnum.NORDESTE);
        stateRegionMap.put(StateEnum.AMAPÁ, RegionEnum.NORTE);
        stateRegionMap.put(StateEnum.AMAZONAS, RegionEnum.NORTE);
        stateRegionMap.put(StateEnum.BAHIA, RegionEnum.NORDESTE);
        stateRegionMap.put(StateEnum.CEARÁ, RegionEnum.NORDESTE);
        stateRegionMap.put(StateEnum.DISTRITO_FEDERAL, RegionEnum.CENTRO_OESTE);
        stateRegionMap.put(StateEnum.ESPÍRITO_SANTO, RegionEnum.SUDESTE);
        stateRegionMap.put(StateEnum.GOIÁS, RegionEnum.CENTRO_OESTE);
        stateRegionMap.put(StateEnum.MARANHÃO, RegionEnum.NORDESTE);
        stateRegionMap.put(StateEnum.MATO_GROSSO, RegionEnum.CENTRO_OESTE);
        stateRegionMap.put(StateEnum.MATO_GROSSO_DO_SUL, RegionEnum.CENTRO_OESTE);
        stateRegionMap.put(StateEnum.MINAS_GERAIS, RegionEnum.SUDESTE);
        stateRegionMap.put(StateEnum.PARÁ, RegionEnum.NORTE);
        stateRegionMap.put(StateEnum.PARAÍBA, RegionEnum.NORDESTE);
        stateRegionMap.put(StateEnum.PARANÁ, RegionEnum.SUL);
        stateRegionMap.put(StateEnum.PERNAMBUCO, RegionEnum.NORDESTE);
        stateRegionMap.put(StateEnum.PIAUÍ, RegionEnum.NORDESTE);
        stateRegionMap.put(StateEnum.RIO_DE_JANEIRO, RegionEnum.SUDESTE);
        stateRegionMap.put(StateEnum.RIO_GRANDE_DO_NORTE, RegionEnum.NORDESTE);
        stateRegionMap.put(StateEnum.RIO_GRANDE_DO_SUL, RegionEnum.SUL);
        stateRegionMap.put(StateEnum.RONDÔNIA, RegionEnum.NORTE);
        stateRegionMap.put(StateEnum.RORAIMA, RegionEnum.NORTE);
        stateRegionMap.put(StateEnum.SANTA_CATARINA, RegionEnum.SUL);
        stateRegionMap.put(StateEnum.SÃO_PAULO, RegionEnum.SUDESTE);
        stateRegionMap.put(StateEnum.SERGIPE, RegionEnum.NORDESTE);
        stateRegionMap.put(StateEnum.TOCANTINS, RegionEnum.NORTE);
    }

    public static RegionEnum defineRegionByState(StateEnum state) {
        return stateRegionMap.get(state);
    }
}

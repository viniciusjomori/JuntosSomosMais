package br.edu.ifsp.spo.JuntosSomosMais.enums;

import java.util.HashMap;
import java.util.Map;

public enum StateEnum {
    ACRE,
    ALAGOAS,
    AMAPÁ,
    AMAZONAS,
    BAHIA,
    CEARÁ,
    DISTRITO_FEDERAL,
    ESPÍRITO_SANTO,
    GOIÁS,
    MARANHÃO,
    MATO_GROSSO,
    MATO_GROSSO_DO_SUL,
    MINAS_GERAIS,
    PARÁ,
    PARAÍBA,
    PARANÁ,
    PERNAMBUCO,
    PIAUÍ,
    RIO_DE_JANEIRO,
    RIO_GRANDE_DO_NORTE,
    RIO_GRANDE_DO_SUL,
    RONDÔNIA,
    RORAIMA,
    SANTA_CATARINA,
    SÃO_PAULO,
    SERGIPE,
    TOCANTINS;

    private static Map<String, StateEnum> stringStateMap = new HashMap<>();

    static {
        stringStateMap.put("acre", StateEnum.ACRE);
        stringStateMap.put("alagoas", StateEnum.ALAGOAS);
        stringStateMap.put("amapá", StateEnum.AMAPÁ);
        stringStateMap.put("amazonas", StateEnum.AMAZONAS);
        stringStateMap.put("bahia", StateEnum.BAHIA);
        stringStateMap.put("ceará", StateEnum.CEARÁ);
        stringStateMap.put("distrito federal", StateEnum.DISTRITO_FEDERAL);
        stringStateMap.put("espírito santo", StateEnum.ESPÍRITO_SANTO);
        stringStateMap.put("goiás", StateEnum.GOIÁS);
        stringStateMap.put("maranhão", StateEnum.MARANHÃO);
        stringStateMap.put("mato grosso", StateEnum.MATO_GROSSO);
        stringStateMap.put("mato grosso do sul", StateEnum.MATO_GROSSO_DO_SUL);
        stringStateMap.put("minas gerais", StateEnum.MINAS_GERAIS);
        stringStateMap.put("pará", StateEnum.PARÁ);
        stringStateMap.put("paraíba", StateEnum.PARAÍBA);
        stringStateMap.put("paraná", StateEnum.PARANÁ);
        stringStateMap.put("pernambuco", StateEnum.PERNAMBUCO);
        stringStateMap.put("piauí", StateEnum.PIAUÍ);
        stringStateMap.put("rio de janeiro", StateEnum.RIO_DE_JANEIRO);
        stringStateMap.put("rio grande do norte", StateEnum.RIO_GRANDE_DO_NORTE);
        stringStateMap.put("rio grande do sul", StateEnum.RIO_GRANDE_DO_SUL);
        stringStateMap.put("rondônia", StateEnum.RONDÔNIA);
        stringStateMap.put("roraima", StateEnum.RORAIMA);
        stringStateMap.put("santa catarina", StateEnum.SANTA_CATARINA);
        stringStateMap.put("são paulo", StateEnum.SÃO_PAULO);
        stringStateMap.put("sergipe", StateEnum.SERGIPE);
        stringStateMap.put("tocantins", StateEnum.TOCANTINS);
    }

    public static StateEnum stringToStateEnum(String state) {
        return stringStateMap.get(state);
    }
}

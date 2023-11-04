package br.edu.ifsp.spo.JuntosSomosMais.enums;

public enum GenderEnum {
    M, F;

    public static GenderEnum wordToEnum(String word) {
        word = word.toUpperCase().substring(0, 1);
        return GenderEnum.valueOf(word);
    }
}

package com.example.estacionamentoPDS1.estacionamentoPDS1.Entitys.Enum;

//Classe para definir o tipo de veiculo estacionado
public enum TipoVeiculo {

    CARRO(0),
    MOTO(1),
    UTILITARIO(2);

    private int code;

    TipoVeiculo(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public static TipoVeiculo valueOf(int code) {
        for (TipoVeiculo value : TipoVeiculo.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus code");
    }
}

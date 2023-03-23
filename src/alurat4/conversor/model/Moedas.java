package alurat4.conversor.model;

public class Moedas {
String code;
String codein;
String name;
double bid;

public String getCodigoMoedaEntrada() {
    return code;
}

public String getCodigoMoedaSaida() {
    return codein;
}

public String getName() {
    return name;
}
public double getValor() {
    return bid;
}

@Override
public String toString() {
    return "ConversorMoeda{" +
            "name='" + name + '\'' +
            ", codigoMoedaEntrada='" + code + '\'' +
            ", codigoMoedaSaida='" + codein + '\'' +
            ", valor=" + bid +
            '}';
}
}

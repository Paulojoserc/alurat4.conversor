package alurat4.conversor.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Moedas {
String code;
String codein;
String name;
double bid;

public String getCode() {
    return code;
}

public String getCodein() {
    return codein;
}

public String getName() {
    return name;
}
public Double getBid() {
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

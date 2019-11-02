package challenge;

import java.util.Objects;

public class Carro {

    private final Motorista motorista;

    private final String placa;

    private final Cor cor;

    private Carro(Motorista motorista, String placa, Cor cor) {
        this.motorista = motorista;
        this.placa = placa;
        this.cor = cor;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public String getPlaca() {
        return placa;
    }

    public Cor getCor() {
        return cor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(motorista, carro.motorista) &&
                Objects.equals(placa, carro.placa) &&
                cor == carro.cor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(motorista, placa, cor);
    }

    @Override
    public String toString() {
        return "Carro{" +
                "motorista=" + motorista +
                ", placa='" + placa + '\'' +
                ", cor=" + cor +
                '}';
    }

    public static CarroBuilder builder() {
        return new CarroBuilder();
    }


    public static class CarroBuilder {

        private Motorista motorista;

        private String placa;

        private Cor cor;

        private CarroBuilder() {
        }

        public CarroBuilder withMotorista(Motorista motorista) {
            validarMotorista(motorista);
            this.motorista = motorista;
            return this;
        }

        public CarroBuilder withPlaca(String placa) {
            validarPlaca(placa);
            this.placa = placa;
            return this;
        }

        public CarroBuilder withCor(Cor cor) {
            this.cor = cor;
            return this;
        }

        public Carro build() {
            validarTudo(motorista, placa, cor);
            return new Carro(motorista, placa, cor);
        }

    }

    private static void validarMotorista(Motorista motorista){
        if(Objects.isNull(motorista) || motorista.getIdade() < 18 || !pontosValidos(motorista.getPontos()))
            throw new EstacionamentoException("Motorista nulo");
    }

    private static void validarPlaca(String placa){
        if(Objects.isNull(placa)) throw new NullPointerException("Placa nula");
        if(placa.isEmpty()) throw new IllegalArgumentException("Placa vasia");
    }

    private static void validarCor(Cor cor){
        if(Objects.isNull(cor)) throw new NullPointerException("Cor está nula");
    }

    private static boolean pontosValidos(int pontos){
        if(Objects.isNull(pontos) || pontos < 1 || pontos > 20 )
            return false;
        return true;
    }


    private static void validarTudo(Motorista motorista, String placa, Cor cor){
        validarPlaca(placa);
        validarCor(cor);
        validarMotorista(motorista);
    }
}

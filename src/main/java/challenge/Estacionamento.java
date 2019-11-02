package challenge;

import java.util.*;

public class Estacionamento {
    private List<Carro> vagas = new ArrayList<>();


    public void estacionar(Carro carro) {
        if(!temVaga() && vagas.stream().allMatch(car -> Objects.nonNull(car) && car.getMotorista().getIdade() > 55)){
            throw new EstacionamentoException("Todos os motoristas são senior´s.");
        }

        if(temVaga()){
            vagas.add(carro);
        }else{
            Carro primeiro = vagas.get(0);
            if(primeiro.getMotorista().getIdade() < 55){
                substituirCarro(carro, 0);
            }else{
                for(int i = 1; i < 10; i++){
                    Carro atual = vagas.get(i);
                    if(atual.getMotorista().getIdade() < 55){
                        substituirCarro(carro, i);
                        break;
                    }
                }
            }
        }
    }

    private void substituirCarro(Carro carro, int i2) {
        vagas.remove(i2);
        vagas.add(i2, carro);
    }

    public int carrosEstacionados() {
        return vagas.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return vagas.contains(carro);
    }

    private boolean temVaga(){
        return vagas.size() < 10;
    }
}

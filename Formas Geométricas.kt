import kotlin.math.pow
import kotlin.math.sqrt

abstract class forma(var area: Double){
    abstract fun calcular_area(): Double;

}

class quadrado(var lado: Double): forma(area = 0.0){

    init{
        if(lado<0){
            println("nao pode numero negativo");
        }
    }
    override fun calcular_area(): Double{
        area = lado*lado;
        println("O quadrado tem area ${area}");
        return area;
    }
}

class circulo(var raio: Double): forma(area = 0.0){

    init{
        if(raio<0){
            println("nao pode numero negativo");
        }
    }
    override fun calcular_area(): Double{
        area = 3.1415*raio*raio;
        println(area);
        return area;
    }
}

class triangulo(var lado1: Double, var lado2: Double, var lado3: Double): forma(area = 0.0){


    private fun n_equilatero():Double{

        var base: Double = 0.0;
        var perimetro: Double = 0.0;

        if(lado1 == lado2){
            base = lado3;
        }else if(lado1==lado3){
            base=lado2;
        }else if (lado2==lado3){
            base=lado1;
        }else{
            perimetro = (lado1+lado2+lado3)/2;
            area= sqrt(perimetro*(perimetro-lado1)*(perimetro-lado2)*(perimetro-lado3));
            return area;
        }
        var altura = sqrt((base/2).pow(2)+(lado1).pow(2));

        area = (base*altura)/2
        return area;

    }


    override fun calcular_area(): Double{

        try{
            if(lado1<(lado2-lado3)||lado1<(lado3-lado2)||lado2<(lado1-lado3)||lado2<(lado3-lado1)||lado3<(lado2-lado1)||lado3<(lado1-lado2)){
                throw IllegalArgumentException();
            }else if(lado1 == lado2 && lado1 == lado3){

                area = ((lado1.pow(2))*1.7)/4

            }else{
                n_equilatero();
                println("A area do triangulo éh ${area}")
            }

        }catch (e:IllegalArgumentException){
            println("Os lados nao formam a poha de um triangulo")
        }
        return area;
    }
}





fun main() {

    println("Qual o lado do quadrado?")
    var q:quadrado = quadrado(readLine()?.toDouble() ?: 0.0);
    q.calcular_area();

    println("Qual o raio do circulo?")
    var c:circulo = circulo(readLine()?.toDouble() ?: 0.0);
    c.calcular_area();

    println("Qual os lados do triangulo")//mudar a variavel da base por lado03, e depois criar uma variavel base pra receber o valor do lado certo
    var t:triangulo = triangulo(readLine()?.toDouble() ?: 0.0, readLine()?.toDouble() ?: 0.0, readLine()?.toDouble() ?: 0.0);
    t.calcular_area();


}
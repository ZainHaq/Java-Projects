package mandelbrotset;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.


/**
 *
 * @author haqz8592
 */
public class Complex {
    double coefficientA;
    double coefficientB;
    public Complex(double a, double b){
        coefficientA=a;
        coefficientB=b;
        
    }
    
    public void display(){
        if(coefficientB>=0){
            System.out.println(coefficientA + " + " + coefficientB+ "i");
        }
        else{
            System.out.println(coefficientA + " - " + Math.abs(coefficientB) + "i");
        }              
    }
    
    public Complex add(Complex secondComplex){
        double newCoefficientA= coefficientA+ secondComplex.coefficientA;
        double newCoefficientB= coefficientB+ secondComplex.coefficientB;
        Complex add = new Complex(newCoefficientA, newCoefficientB);
        return add;
    }
    public void multiplyByScalar(double s){
        double newCoefficientA= coefficientA*s;
        double newCoefficientB= coefficientB*s;
        Complex scalar = new Complex(newCoefficientA, newCoefficientB);
        scalar.display();
    }
    
    public Complex multiplyByComplex(Complex secondComplex){
        double newCoefficientA = coefficientA*secondComplex.coefficientA + coefficientB*secondComplex.coefficientB*-1;
        double newCoefficientB = coefficientA*secondComplex.coefficientB + coefficientB*secondComplex.coefficientA;
        return new Complex(newCoefficientA, newCoefficientB);
        
    }
    
    public double absolute(){
        double abs = Math.sqrt(Math.pow(coefficientA, 2) + Math.pow(coefficientB, 2));
        return abs;
    }
    
    public double absoluteSquared(){
        double abs = (Math.pow(coefficientA, 2) + Math.pow(coefficientB, 2));
        return abs;
    }
    public Complex conj(){
        double newcoefficientB=coefficientB*-1;
        return new Complex(coefficientA, newcoefficientB);
    }
    public Complex divideByComplex(Complex secondComplex){        
        Complex top = multiplyByComplex(secondComplex.conj());
        double bottom=Math.pow(secondComplex.coefficientA,2) + Math.pow(secondComplex.coefficientB,2);
        return new Complex(top.coefficientA/bottom,top.coefficientB/bottom);
    }
    
    public Complex exponent(int exp){
        Complex sameNum = new Complex(coefficientA, coefficientB);
        for(int i=2;i<=exp;i++){
          sameNum = multiplyByComplex(sameNum); 
        }
        return sameNum;       
    }
    
   
}

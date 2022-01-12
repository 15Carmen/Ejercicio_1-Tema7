package com.company;

public class Cuenta {

    //atributos

    private String nombreCliente, numeroCuenta;
    private double tipoInteres, saldo;

    public Cuenta() {

    }

    //constructor con parametros

    public Cuenta (String nombreCliente, String numeroCuenta, double tipoInteres, double saldo){

        this.nombreCliente = nombreCliente;
        this.numeroCuenta = numeroCuenta;
        this.tipoInteres = tipoInteres;
        this.saldo = saldo;

    }

    //hacemos los getter

    public String getNumeroCuenta(){
        return numeroCuenta;
    }

    public String getNombreCliente(){
        return nombreCliente;
    }

    public double getTipoInteres(){
        return tipoInteres;
    }

    public double getSaldo(){
        return saldo;
    }

    //hacemos los setter

    public void setNombreCliente (String nombreCliente){
        this.nombreCliente = nombreCliente;
    }
    public void setNumeroCuenta (String numeroCuenta){
        this.numeroCuenta = numeroCuenta;
    }

    public void setTipoInteres (double tipoInteres){
        this.tipoInteres = tipoInteres;
    }

    public void setSaldo (double saldo){
        this.saldo = saldo;
    }

    public Cuenta (Cuenta cuenta){

        this.nombreCliente = cuenta.getNombreCliente();
        this.numeroCuenta = cuenta.getNumeroCuenta();
        this.tipoInteres = cuenta.getTipoInteres();
        this.saldo = cuenta.getSaldo();
    }

    /**
     *
     * @param cantidad de dinero ingresar
     * @return booleano para indicar que si se ha podido realizar el ingreso
     *
     */

    public boolean ingresar (double cantidad){

        boolean realizado;

        if (cantidad<0){
            realizado = false;
        }else{
            this.saldo += cantidad;
            realizado = true;
        }
        return realizado;
    }

    /**
     *
     * @param cantidad de dinero retirado
     * @return booleano para indicar que si se ha podido realizar la  retirada
     *
     */

    public boolean retirar (double cantidad){

        boolean realizado = false;

        if ( this.getSaldo()>=cantidad && cantidad > 0 ){
            this.saldo -= cantidad;
            realizado = true;
        }
        return realizado;
    }

    public boolean transferencia (Cuenta cuentaDestino, double cantidad){

        boolean realizado = false;

        if(cantidad <= this.getSaldo() && cantidad >= 0){

            cuentaDestino.setSaldo(cuentaDestino.getSaldo()+cantidad);
            this.setSaldo(this.getSaldo()-cantidad);
            realizado = true;
        }
        return realizado;
    }

}

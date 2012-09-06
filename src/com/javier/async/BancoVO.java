package com.javier.async;

import android.content.Context;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joseb2
 */
public class BancoVO {
	
	
    private String nombreEmpresa;
    private String numCuenta;
    private String tipoCuenta;
    private String saldoActual;
    private String saldoDisponible;

    
    private BancoVO() {



	}

	private static BancoVO banco;

	/** A private Constructor prevents any other class from instantiating. */

	public static synchronized BancoVO getInstance() {
		if (banco == null) {
			banco = new BancoVO();
		}

		return banco;
	}

	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
    /**
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * @param nombreEmpresa the nombreEmpresa to set
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * @return the tipoCuenta
     */
    public String getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * @param tipoCuenta the tipoCuenta to set
     */
    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    /**
     * @return the saldoActual
     */
    public String getSaldoActual() {
        return saldoActual;
    }

    /**
     * @param saldoActual the saldoActual to set
     */
    public void setSaldoActual(String saldoActual) {
        this.saldoActual = saldoActual;
    }

    /**
     * @return the saldoDisponible
     */
    public String getSaldoDisponible() {
        return saldoDisponible;
    }

    /**
     * @param saldoDisponible the saldoDisponible to set
     */
    public void setSaldoDisponible(String saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }
    
    
    public void datos(){
        System.out.println(        
 "\n nombreEmpresa:"+nombreEmpresa+
 "\n numCuenta:"+  numCuenta +
 "\n tipoProducto:"+tipoCuenta+
 "\n saldoActual:"+saldoActual+
 "\n saldoDisponible:"+saldoDisponible
         );
    }
    
    
    public String getDatos(){
        return  (
 "\n nombreEmpresa:"+nombreEmpresa+
 "\n numCuenta:"+  numCuenta +
 "\n tipoProducto:"+tipoCuenta+
 "\n saldoActual:"+saldoActual+
 "\n saldoDisponible:"+saldoDisponible
         );
    }

    /**
     * @return the numCuenta
     */
    public String getNumCuenta() {
        return numCuenta;
    }

    /**
     * @param numCuenta the numCuenta to set
     */
    public void setNumCuenta(String numCuenta) {
        this.numCuenta = numCuenta;
    }
}

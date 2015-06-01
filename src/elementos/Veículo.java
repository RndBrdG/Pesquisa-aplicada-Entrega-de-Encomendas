package elementos;

import java.util.ArrayList;

public class Veículo {
	private final float gasolinaMáx;
	private float gasolinaAtual;
	private final int cargaMáx;
	private int cargaAtual;
	ArrayList<Encomenda> encomendas;
	
	public Veículo(float gasolinaMáx, int cargaMáx) {		
		this.gasolinaMáx = gasolinaMáx;
		this.cargaMáx = cargaMáx;
		gasolinaAtual = gasolinaMáx;
		cargaAtual = 0;
		encomendas = new ArrayList<Encomenda>();
	}
	
	public Veículo(Veículo veículo) {
		this.gasolinaMáx = veículo.gasolinaMáx;
		this.cargaMáx = veículo.cargaMáx;
		gasolinaAtual = veículo.gasolinaAtual;
		cargaAtual = veículo.cargaAtual;
		encomendas = new ArrayList<Encomenda>(veículo.encomendas);
	}
	
	public void encherDepósito() {
		gasolinaAtual = gasolinaMáx;
	}
	
	public void gastarGasolina(double d) {
		gasolinaAtual -= d;
	}
	
	public void addEncomenda(Encomenda enc) {
		int volumeEncomenda = enc.getVolume();
		if (cargaAtual + volumeEncomenda > cargaMáx) throw new IllegalArgumentException();
		encomendas.add(enc);
		cargaAtual += volumeEncomenda;
	}
	
	public void decCargaEncomenda(Encomenda enc) {
		int volumeEncomenda = enc.getVolume();
		if (cargaAtual - volumeEncomenda < 0 || !encomendas.contains(enc)) throw new IllegalArgumentException();
		cargaAtual -= volumeEncomenda;
	}
	
	public float getGasolinaMáx() {
		return gasolinaMáx;
	}
	
	public float getGasolinaAtual() {
		return gasolinaAtual;
	}
	
	public int getCargaMáx() {
		return cargaMáx;
	}
	
	public int getCargaAtual() {
		return cargaAtual;
	}
	
	public ArrayList<Encomenda> getEncomendas() {
		return encomendas;
	}
}

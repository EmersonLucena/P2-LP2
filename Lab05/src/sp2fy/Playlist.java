package sp2fy;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
	private List<Musica> sequencia;
	private String titulo;
	private int duracaoTotal;
	
	public Playlist(String titulo) throws Exception {
		if(titulo == null || titulo.equals(""))
			throw new Exception("Nome invalido!");
		
		sequencia = new ArrayList<Musica>();
		this.titulo = titulo;
		this.duracaoTotal = 0;
	}
	
	public boolean pesquisaMusica(String titulo) throws Exception {
		if(titulo == null || titulo.equals(""))
			throw new Exception("Nome invalido!");
		
		for (Musica musica : sequencia) {
			if(titulo.equals(musica.getTitulo()))
				return true;
		}
		return false;
	}
	
	public boolean pesquisaMusica(Musica musica) throws Exception {
		if(musica == null)
			throw new Exception("Musica invalida!");
		
		return sequencia.contains(musica);
	}
	
	public boolean adicionaMusica(Musica musica) throws Exception {
		if(musica == null)
			throw new Exception("Musica invalida!");
		
		if(!pesquisaMusica(musica))
			return false;
		
		sequencia.add(musica);
		duracaoTotal += musica.getDuracao();
		return true;
	}
	
	public boolean removeMusica(String titulo) throws Exception {
		if(titulo == null || titulo.equals(""))
			throw new Exception("Nome invalido!");
		
		for (Musica musica : sequencia) {
			if(titulo.equals(musica.getTitulo())) {
				sequencia.remove(musica);
				return true;
			}
		}
		return false;
	}

	public boolean removeMusica(Musica musica) throws Exception {
		if(musica == null)
			throw new Exception("Musica invalida!");
		
		return sequencia.remove(musica);
	}
	
	public String getTitulo() {
		return titulo;
	}

	public int getDuracaoTotal() {
		return duracaoTotal;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}

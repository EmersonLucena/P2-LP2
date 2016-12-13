package sp2fy;

import java.util.ArrayList;
import java.util.List;

public class Album {
	private List <Musica> conteudo;
	private int duracaoTotal;
	private String artista;
	private String titulo;
	private int anoLancamento;
	
	public Album(String artista, String titulo, int anoLancamento) throws Exception {
		if(titulo == null || titulo.equals(""))
			throw new Exception("Título do álbum inválido!");	
		if(artista == null || artista.equals(""))
			throw new Exception("Artista inválido!");
		if(anoLancamento <= 1800)
			throw new Exception("Ano de lançamento inválido!");
		
		conteudo = new ArrayList<Musica>();
		duracaoTotal = 0;
		
		this.artista = artista;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
	}
	
	public boolean musicaPresente(Musica musica) {
		//TODO musica null
		return conteudo.contains(musica);
	}
	
	public boolean adicionarMusica(Musica musica) {
		//TODO exceções
		if(!musicaPresente(musica)) {
			conteudo.add(musica);
			duracaoTotal += musica.getDuracao();
			return true;
		}
		
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((artista == null) ? 0 : artista.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Album))
			return false;
		Album other = (Album) obj;
		if (artista == null) {
			if (other.artista != null)
				return false;
		} else if (!artista.equals(other.artista))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
}

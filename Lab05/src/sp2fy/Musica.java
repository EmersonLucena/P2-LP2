package sp2fy;

public class Musica {
	private String titulo;
	private String genero;
	private int duracao;
	
	public Musica(String titulo, String genero, int duracao) throws Exception {
		if(titulo == null || titulo.equals(""))
			throw new Exception("T�tulo da m�sica inv�lido!");
		if(genero == null || genero.equals(""))
			throw new Exception("G�nero da m�sica inv�lido!");
		if(duracao <= 0)
			throw new Exception("Dura��o da m�sica inv�lida!");
		
		this.titulo = titulo;
		this.genero = genero;
		this.duracao = duracao;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getGenero() {
		return genero;
	}

	public int getDuracao() {
		return duracao;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Musica))
			return false;
		Musica other = (Musica) obj;
		if (duracao != other.duracao)
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + duracao;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
}

package sp2fy;

public class Perfil {
	String nome;
	Musiteca musiteca;
	
	public Perfil(String nome) throws Exception {
		if(nome == null || nome.equals(""))
			throw new Exception("Nome invalido!");
		
		this.nome = nome;
		musiteca = new Musiteca();
	}
	
	public boolean pesquisaColecao(String titulo) throws Exception {
		return musiteca.pesquisaColecao(titulo);
	}
	
	public boolean adicionaParaColecao(Album album) throws Exception {
		return musiteca.adicionaParaColecao(album);
	}
	
	public boolean removeDeColecao(String titulo) throws Exception {
		return musiteca.removeDeColecao(titulo);
	}
	
	public boolean pesquisaFavoritos(String titulo) throws Exception {
		return musiteca.pesquisaFavoritos(titulo);
	}
	
	public boolean adicionaParaFavoritos(Album album) throws Exception {
		return musiteca.adicionaParaFavoritos(album);
	}
	
	public boolean removeDeFavoritos(String titulo) throws Exception {
		return musiteca.removeDeFavoritos(titulo);
	}
	
	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {
		return musiteca.adicionaPlaylist(nomePlaylist, nomeAlbum, faixa);
	}

	public String getNome() {
		return nome;
	}
}

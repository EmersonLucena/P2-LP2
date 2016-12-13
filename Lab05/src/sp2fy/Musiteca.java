package sp2fy;

import java.util.HashSet;

public class Musiteca {
	private HashSet<Album> colecao;
	private HashSet<Album> favoritos;
	
	public Musiteca() {
		colecao = new HashSet<Album>();
	}
	
	public boolean adicionaParaColecao(Album album) throws Exception {
		if(album == null)
			throw new Exception("Album invalido!!");		
		return colecao.add(album);
	}
	
	public boolean pesquisaColecao(Album album) throws Exception {
		if(album == null)
			throw new Exception("Album invalido!!");		
		return colecao.contains(album);
	}
	
	public boolean removeDeColecao(Album album) throws Exception {
		if(album == null)
			throw new Exception("Album invalido!!");		
		return colecao.remove(album);
	}
	
	public boolean adicionaParaFavoritos(Album album) throws Exception {
		if(album == null)
			throw new Exception("Album invalido!!");		
		return favoritos.add(album);
	}
	
	public boolean pesquisaFavoritos(Album album) throws Exception {
		if(album == null)
			throw new Exception("Album invalido!!");		
		return favoritos.contains(album);
	}
	
	public boolean removeDeFavoritos(Album album) throws Exception {
		if(album == null)
			throw new Exception("Album invalido!!");		
		return favoritos.remove(album);
	}
}

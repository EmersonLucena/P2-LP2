package sp2fy;

import java.util.HashMap;
import java.util.Map;

public class Musiteca {
	private Map<String, Album> colecao;
	private Map<String, Album> favoritos;
	private Map<String, Playlist> playlists;
	
	public Musiteca() {
		colecao = new HashMap<String, Album>();
		favoritos = new HashMap<String, Album>();
		playlists = new HashMap<String, Playlist>();
	}
	
	public boolean pesquisaColecao(String titulo) throws Exception {
		if(titulo == null)
			throw new Exception("Album invalido!!");		
		return colecao.containsKey(titulo);
	}
	
	public boolean adicionaParaColecao(Album album) throws Exception {
		if(album == null)
			throw new Exception("Album invalido!!");		
		
		if(!pesquisaColecao(album.getTitulo()))
			return false;
		
		colecao.put(album.getTitulo(), album);
		return true;
	}
	
	public boolean removeDeColecao(String titulo) throws Exception {
		if(titulo == null)
			throw new Exception("Album invalido!!");		
		
		if(!pesquisaColecao(titulo))
			return false;
		
		colecao.remove(titulo);
		return true;
	}
	
	public boolean pesquisaFavoritos(String titulo) throws Exception {
		if(titulo == null)
			throw new Exception("Album invalido!!");		
		return favoritos.containsKey(titulo);
	}
	
	public boolean adicionaParaFavoritos(Album album) throws Exception {
		if(album == null)
			throw new Exception("Album invalido!!");		
		
		if(!pesquisaFavoritos(album.getTitulo()))
			return false;
		
		favoritos.put(album.getTitulo(), album);
		return true;
	}
	
	public boolean removeDeFavoritos(String titulo) throws Exception {
		if(titulo == null)
			throw new Exception("Album invalido!!");		
		
		if(!pesquisaFavoritos(titulo))
			return false;
		
		favoritos.remove(titulo);
		return true;
	}
	
	public boolean adicionaPlaylist(String nomePlaylist, String nomeAlbum, int faixa) throws Exception {
		if(nomePlaylist == null || nomePlaylist.equals(""))
			throw new Exception("Nome invalido!");
		
		if(nomeAlbum == null || nomeAlbum.equals(""))
			throw new Exception("Nome invalido!");
		
		if(!colecao.containsKey(nomeAlbum))
			throw new Exception("Album nao pertence ao Perfil especificado");
		
		Playlist playlistAlvo;
		if(!playlists.containsKey(nomePlaylist)) {
			playlistAlvo = playlists.put(nomePlaylist, new Playlist(nomePlaylist));
		} else {
			playlistAlvo = playlists.get(nomePlaylist);
		}
		
		Musica novaMusica = colecao.get(nomeAlbum).getMusica(faixa);
		return playlistAlvo.adicionaMusica(novaMusica);
	}
}

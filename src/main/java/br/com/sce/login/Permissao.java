package br.com.sce.login;


public enum Permissao {
	
	ADM(1,"*"),
	ALUNO(2,"/aluno/*");
	
	private Integer id;
	private String urlPattern;

	private Permissao(Integer id, String urlPattern) {
		this.id = id;
		this.urlPattern = urlPattern;
	}

	public Integer getId() {
		return id;
	}

	public String getUrlPattern() {
		return urlPattern;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUrlPattern(String urlPattern) {
		this.urlPattern = urlPattern;
	}
	
}

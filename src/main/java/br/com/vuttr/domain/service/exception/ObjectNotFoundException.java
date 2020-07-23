package br.com.vuttr.domain.service.exception;

import io.swagger.annotations.ApiModel;

/**
 * 
 * @author felipessca
 *
 */
@ApiModel(description = "Classe de captura de erro e exibição de erro personalizado")
public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message) {
		super(message);

	}

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

}

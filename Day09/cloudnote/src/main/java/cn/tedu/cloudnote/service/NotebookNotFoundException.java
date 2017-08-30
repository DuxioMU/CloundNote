package cn.tedu.cloudnote.service;

public class NotebookNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 8937501369306626438L;

	public NotebookNotFoundException() {
	}

	public NotebookNotFoundException(String message) {
		super(message);
	}

	public NotebookNotFoundException(Throwable cause) {
		super(cause);
	}

	public NotebookNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotebookNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}

package com.plivo.api.models.address;

public enum FileExtensionType {
	PNG("png"),
	JPG("jpg"),
	PDF("pdf");

	private final String fileType;

	FileExtensionType(final String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return this.fileType;
	}
}

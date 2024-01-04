package utility;

public enum FileType {

    TEXT(".txt"),
    PDF(".pdf"),
    IMAGE(".jpg"),
    HTML(".html");
    private String extension;

    FileType(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        return extension;
    }

}

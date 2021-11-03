package app;

public enum DaoType {

    chrome("chrome"),
    edge("edge");

    private final String type;

    DaoType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public static DaoType init(String type) {
        switch (type) {
            case "chrome" : return chrome;
            case "edge" : return edge;
        }
        return null;
    }
}

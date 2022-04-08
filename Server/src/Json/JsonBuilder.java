package Json;

public class JsonBuilder {
    public JsonAnalizador createJsonLectura() {
        return new JsonLecturaBuilder().createJsonLectura();
    }
}
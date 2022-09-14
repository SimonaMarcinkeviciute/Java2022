package lt.codeacademy.eshopapi;

public interface ApplicationPath {
    // variables
    String productId = "productId";
    String FILE_NAME = "fileName";
    String ID = "id";

    //paths
    String ROOT = "/api";
    String PRODUCTS = ROOT + "/products";
    String PRODUCT =  "/{" + productId + "}";
    String SEARCH = "/search";
    String FILES = ROOT + "/files";
    String METADATA = "/metadata";
    String FILE = "/{" + FILE_NAME + "}";
    String FILE_METADATA = METADATA + "/{" + ID + "}";
    String BLOBS = "/blobs";
    String GET_BLOB = BLOBS + "/{" + ID + "}";
}

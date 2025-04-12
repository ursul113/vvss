package inventory.model;

import inventory.repository.InventoryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InventoryLab3Test {
    private static Inventory inventory;
    private static InventoryRepository repo;

    private static Inventory emptyInventory;

    @BeforeAll
    static void setUp() {
        repo = new InventoryRepository();
        inventory = repo.getInventory();
        emptyInventory = new Inventory();
    }

    @Test
    void F02_TC01() {

        assert inventory.lookupProduct("")==null;

    }

    @Test
    void F02_TC02() {
        Part part1 = new InhousePart(1, "part1", 20, 3, 1,10, 1);
        Part part2 = new InhousePart(2, "part2", 20, 3, 1,10, 1);
        Part part3 = new InhousePart(3, "part3", 20, 3, 1,10, 1);
        ObservableList<Part> partIdList = FXCollections.observableArrayList();
        partIdList.addAll(part1,part2,part3);
        Product product = new Product(1,"Produs_1",10,7,2,20,partIdList);

        //repo.addProduct(product);
        Product foundProduct = inventory.lookupProduct("Produs_1");
        assert foundProduct.getName().equals(product.getName());
        assert foundProduct.getPrice()==product.getPrice();
        assert foundProduct.getInStock()==product.getInStock();
        assert foundProduct.getMin()==product.getMin();
        assert foundProduct.getMax()==product.getMax();


    }

    @Test
    void F02_TC03() {

        assert inventory.lookupProduct("Produs_3")==null;

    }

    @Test
    void F02_TC04() {
        Product foundProduct = emptyInventory.lookupProduct("Produs_1");
        assert foundProduct.getName() == null;
        assert foundProduct.getProductId()==0;
        assert foundProduct.getMax()==0;
        assert foundProduct.getMin()==0;
        assert foundProduct.getPrice()==0.0;
        assert foundProduct.getInStock()==0;
    }

    @Test
    void F02_TC05() {
        assert inventory.lookupProduct("Produs_2")==null;
    }

    @Test
    void F02_TC06() {
        Product foundProduct = emptyInventory.lookupProduct("Produs_4");
        assert foundProduct.getName() == null;
        assert foundProduct.getProductId()==0;
        assert foundProduct.getMax()==0;
        assert foundProduct.getMin()==0;
        assert foundProduct.getPrice()==0.0;
        assert foundProduct.getInStock()==0;
    }

    @Test
    void F02_TC07() {
        assert inventory.lookupProduct("Produs_2")==null;
    }
}
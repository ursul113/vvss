package inventory.service;

import inventory.model.InhousePart;
import inventory.model.Part;
import inventory.model.Product;
import inventory.repository.InventoryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class InventoryServiceLab4IntegrationTest {
    @InjectMocks
    public InventoryService service;
    // Create a mock object of the InventoryRepository class
    @Mock
    public InventoryRepository repository;

    // This method runs before each test method to initialize the mock object
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    // This test method checks if a part can be added to the repository
    @Test
    public void testAddPart() {
        // Create a test part object
        Part part = new InhousePart(1, "Test Part", 19.99, 5, 1, 10, 123);
        // Call the addPart method of the repository with the test part object
        repository.addPart(part);
        // Verify that the addPart method was called with the test part object as an argument
        Mockito.verify(repository).addPart(part);


        ObservableList<Part> parts = FXCollections.observableArrayList(part);
        // Tell the mock object to return the ObservableList when getAllParts is called
        Mockito.when(service.getAllParts()).thenReturn(parts);
        // Call getAllParts on the service object and store the result in allParts
        List<Part> allParts = service.getAllParts();
        // Verify that allParts is not null and not empty
        assertNotNull(parts);
        assertFalse(parts.isEmpty());
    }

    // This test method checks if a product can be added to the repository
    @Test
    public void testAddProduct() {
        // Create a test part object and a test product object with the part as a component
        List<Part> parts = Arrays.asList(new InhousePart(1, "Test Part", 19.99, 5, 1, 10, 123),
                new InhousePart(2, "Test Part 2", 29.99, 5, 1, 10, 456));
        Product product = new Product(1, "Test Product", 19.99, 5, 1, 10, FXCollections.observableArrayList(parts));
        // Call the addProduct method of the repository with the test product object
        repository.addProduct(product);
        // Verify that the addProduct method was called with the test product object as an argument
        Mockito.verify(repository).addProduct(product);

        ObservableList<Part> partsNew = FXCollections.observableArrayList(parts);
        // Tell the mock object to return the ObservableList when getAllParts is called
        Mockito.when(service.getAllParts()).thenReturn(partsNew);
        // Call getAllParts on the service object and store the result in allParts
        List<Part> allParts = service.getAllParts();
        // Verify that allParts is not null and not empty
        assertNotNull(parts);
        assertFalse(parts.isEmpty());
        assertEquals(2, allParts.size());
    }

    // This test method checks if the getAllParts method of the repository returns a non-empty list
    @Test
    public void testGetAllParts() {
        // Create a test part object and add it to the repository
        Part part = new InhousePart(1, "Test Part", 19.99, 5, 1, 10, 123);
        ObservableList<Part> parts = FXCollections.observableArrayList(part);
        Mockito.when(repository.getAllParts()).thenReturn(parts);
        // Call the getAllParts method of the repository and check if it returns a non-empty list
        List<Part> allParts = repository.getAllParts();
        assertNotNull(parts);
        assertFalse(parts.isEmpty());
        assertNotNull(allParts);
        assertEquals(1, allParts.size());

        ObservableList<Part> partsNew = FXCollections.observableArrayList(parts);
        // Tell the mock object to return the ObservableList when getAllParts is called
        Mockito.when(service.getAllParts()).thenReturn(partsNew);
        // Call getAllParts on the service object and store the result in allParts
        allParts = service.getAllParts();
        // Verify that allParts is not null and not empty
        assertNotNull(partsNew);
        assertFalse(partsNew.isEmpty());
        assertEquals(1, allParts.size());
    }
}
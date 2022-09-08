//package com.techelevator.business;
//
//import com.techelevator.model.Ingredient;
//import com.techelevator.repository.IngredientRepository;
//import okhttp3.mockwebserver.MockResponse;
//import okhttp3.mockwebserver.MockWebServer;
//import org.apache.commons.lang3.RandomStringUtils;
//import org.junit.jupiter.api.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.web.servlet.MockMvc;
//
//import java.io.IOException;
//
//@WithMockUser(username = "test", password = "test", roles = "USER")
//public class IngredientServiceTests {
//
//
//    IngredientRepository ingredientRepository;
//    IngredientService ingredientService;
//    public static MockWebServer mockWebServer;
//
//    @BeforeAll
//    static void setUp() throws IOException {
//        mockWebServer = new MockWebServer();
//        mockWebServer.start();
//    }
//
//    @AfterAll
//    static void tearDown() throws IOException {
//        mockWebServer.shutdown();
//    }
//
//    @BeforeEach
//    void initialize() {
//        String baseUrl = String.format("http://localhost:8080",
//                mockWebServer.getPort());
//        ingredientService = new IngredientService(baseUrl);
//    }
//
//
//    public void createIngredientTest() {
//
//        String testIngredient = RandomStringUtils.randomAlphabetic(10);
//        String testCategory = RandomStringUtils.randomAlphabetic(10);
//        Ingredient testIngredientObject = ingredientService.createIngredient(testIngredient, testCategory);
//
//        mockWebServer.enqueue(new MockResponse()
//                .setResponseCode(HttpStatus.CREATED.value()));
//    }
//}

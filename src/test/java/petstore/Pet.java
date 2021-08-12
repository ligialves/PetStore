// Pacote
package petstore;

// Bibliotecas

import org.testng.annotations.Test;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

//Classe
public class Pet {
    // Atributo
    String uri = "https://petstore.swagger.io/v2/pet " ;// esse endere�o pegamos do swagger

    // M�todos e fun��es
    public String lerJson(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

    // Incluir - Create - Post
    @Test
    public void incluirPet() throws IOException {
        String jsonBody = lerJson("db/pet1.json");

        // dado - quando - ent�o


        // given - when - then
        given() // Dado
                .contentType("application/json") // tipo de informa��o comum em API REST - antigamente eram "text/xml"
                .log().all() // registro
                .body(jsonBody)
        .when() // Quando
                .post(uri)
        .then()
                .log().all()  // request e response.
                .statusCode(200)
                .body("name", is("Coxinha"))
                .body("status", is("available"))
        ;
    }

}
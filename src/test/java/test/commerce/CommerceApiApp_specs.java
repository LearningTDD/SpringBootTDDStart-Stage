package test.commerce;

import commerce.CommerceApiApp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = CommerceApiApp.class)
@ExtendWith(CheckDatabaseConnection.class)
public class CommerceApiApp_specs {

    @Test
    void 컨텍스트가_초기화된다() {
    }
}

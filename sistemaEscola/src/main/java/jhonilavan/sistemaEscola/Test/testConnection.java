package jhonilavan.sistemaEscola.Test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class testConnection {
    @GetMapping("/connection")
    public String testConnection(){
        return "Conectado com sucesso";
    }
}

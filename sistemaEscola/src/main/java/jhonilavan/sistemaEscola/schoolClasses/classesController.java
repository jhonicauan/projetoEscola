package jhonilavan.sistemaEscola.schoolClasses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/class")
public class classesController {
    @Autowired
    IRepositoryClasses repositoryClasses;

    @SuppressWarnings("rawtypes")
    @PostMapping("/add")
    public ResponseEntity createClass(@RequestBody modelClasses modelClass){
        repositoryClasses.save(modelClass);
        return ResponseEntity.accepted().body(modelClass);
    }

    @SuppressWarnings("rawtypes")
    @GetMapping("/viewAll")
    public ResponseEntity viewAll(){
        var classes = repositoryClasses.findAll();
        if(classes.size() == 0){
            return ResponseEntity.badRequest().body("Não existem salas cadastradas");
        }
        return ResponseEntity.accepted().body(classes);
    }
}

package fr.semifir.demospringboot.controllers;

import fr.semifir.demospringboot.models.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("users") //localhost:8080/users
public class UserController {

    //FAKE BASE DE DONNEES
    private List<User> users = initUser();

    @GetMapping() //localhost:8080/users --> GET
    public List<User> findAll() {
        return this.users;
    }

    @GetMapping("/{id}") //localhost:8080/users/un_id --> GET
    public User findById(@PathVariable int id) {
        return this.users.get(id);
    }

    @GetMapping("/nom/{nom}") //localhost:8080/users/nom/un_nom --> GET
    public List<User> findByNom(@PathVariable String nom) {
        // Initialisation d'une liste de retour vide
        List<User> users = new ArrayList<>();
        // Pour chaque utilisateur de ma liste
        for(User user : this.users) {
            // Si le nom de l'utilisateur est égal au nom placé en paramètre
            // Alors ajouter cet utilisateur à la liste de retour
            if(nom.toLowerCase().equals(user.getNom().toLowerCase())) {
                users.add(user);
            }
        }
        return users;
    }

    @PostMapping() //localhost:8080/users --> POST
    public User save(@RequestBody User user) {
        this.users.add(user);
        return user;
    }

    @PutMapping("/{id}") //localhost:8080/users/un_id --> PUT
    public User update(@PathVariable int id, @RequestBody User user) {
        // Récupère l'ancien utilisateur pas encore modifié
        User newUser = findById(id);
        // Modifie le nom de l'ancien utilisateur avec son nouveau nom (user du body)
        newUser.setNom(user.getNom());
        // Modifie le prénom de l'ancien utilisateur avec son nouveau prénom (user du body)
        newUser.setPrenom(user.getPrenom());
        // Modifie l'âge de l'ancien utilisateur avec son nouvel âge (user du body)
        newUser.setAge(user.getAge());
        return newUser;
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable int id){
        return this.users.remove(id);
    }


    /**
     * Méthode qui créer et retourne une liste instanciée d'utilisateurs
     * @return
     */
    public List<User> initUser() {
        List<User> users = new ArrayList<>();
        users.add(new User("DOE", "John", 12));
        users.add(new User("DUPONT", "Martin", 23));
        users.add(new User("DUJARDIN", "Laura", 12));
        return users;
    }

}

package org.learning.java.springlamiapizzeriacrud.controller;

import org.learning.java.springlamiapizzeriacrud.model.Ingredient;
import org.learning.java.springlamiapizzeriacrud.repository.IngredientRepository;
import org.learning.java.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    @Autowired
    PizzaRepository pizzaRepository;
    @Autowired
    IngredientRepository ingredientRepository;

    @GetMapping
    public String list(Model model) {
        List<Ingredient> ingredients = ingredientRepository.findAll();
        model.addAttribute("ingredients", ingredients);
        return "/ingredient/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("ingredient", new Ingredient());
        return "/ingredient/create";
    }

    @PostMapping("/create")
    public String store(@ModelAttribute("ingredient") Ingredient ingredient, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "discount/create";
        }
        ingredientRepository.save(ingredient);
        return "redirect:/ingredient";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<Ingredient> ingredientToDelete = ingredientRepository.findById(id);
        if (ingredientToDelete.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        ingredientRepository.delete(ingredientToDelete.get());
        return "redirect:/ingredient";
    }
}

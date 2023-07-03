package org.learning.java.springlamiapizzeriacrud.controller;

import org.learning.java.springlamiapizzeriacrud.model.Pizza;
import org.learning.java.springlamiapizzeriacrud.repository.IngredientRepository;
import org.learning.java.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class PizzaController {
    @Autowired
    private PizzaRepository pizzaRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @GetMapping
    public String home(Model model) {
        List<Pizza> pizzas = pizzaRepository.findAll();
        model.addAttribute("pizzasList", pizzas);
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza", new Pizza());
        model.addAttribute("ingredientList", ingredientRepository.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String store(@ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        pizzaRepository.save(formPizza);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Integer id, Model model) {
        List<Pizza> pizzas = pizzaRepository.findAll();
        if (id <= pizzas.size()) {
            model.addAttribute("pizza", pizzaRepository.findById(id).get());
            return "show";
        } else {
            return "error";
        }
    }

    @PostMapping("delete/{id}")
    public String delete(@PathVariable("id") Integer id) {
        pizzaRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String edit(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("pizza", pizzaRepository.findById(id).get());
        model.addAttribute("ingredientList", ingredientRepository.findAll());
        return "edit";
    }

    @PostMapping("edit/{id}")
    public String update(@ModelAttribute("pizza") Pizza formPizza, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        pizzaRepository.save(formPizza);
        return "redirect:/";
    }

}

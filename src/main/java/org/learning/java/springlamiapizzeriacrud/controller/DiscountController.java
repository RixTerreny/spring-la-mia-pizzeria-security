package org.learning.java.springlamiapizzeriacrud.controller;

import org.learning.java.springlamiapizzeriacrud.model.Discount;
import org.learning.java.springlamiapizzeriacrud.model.Pizza;
import org.learning.java.springlamiapizzeriacrud.repository.DiscountRepository;
import org.learning.java.springlamiapizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Controller
@RequestMapping("/discount")
public class DiscountController {

    @Autowired
    PizzaRepository pizzaRepository;
    @Autowired
    DiscountRepository discountRepository;

    @GetMapping("/create")
    public String create(@RequestParam("pizzaId") Integer pizzaId, Model model) {
        Optional<Pizza> pizza = pizzaRepository.findById(pizzaId);
        if (pizza.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "pizza con id " + pizzaId + " non è stata trovata");
        }
        Discount discount = new Discount();
        model.addAttribute("discount", discount);
        discount.setPizza(pizza.get());
        return "/discount/create";
    }

    @PostMapping("/create")
    public String store(@ModelAttribute("discount") Discount formDiscount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "discount/create";
        }
        discountRepository.save(formDiscount);
        return "redirect:/" + formDiscount.getPizza().getId();
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        Optional<Discount> discountToDelete = discountRepository.findById(id);
        if (discountToDelete.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        discountRepository.delete(discountToDelete.get());
        return "redirect:/" + discountToDelete.get().getPizza().getId();
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Optional<Discount> discount = discountRepository.findById(id);
        if (discount.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        model.addAttribute("discount", discount.get());
        return "discount/edit";
    }

    @PostMapping("/edit/{id}")
    public String doEdit(@PathVariable Integer id, @ModelAttribute("borrowing") Discount discount, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/discount/edit";
        }
        Optional<Discount> discountToEdit = discountRepository.findById(id);
        if (discountToEdit.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        discount.setId(id);
        discountRepository.save(discount);
        return "redirect:/" + discount.getPizza().getId();
    }

}

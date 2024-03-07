package org.humber.project.controllers;

import org.humber.project.services.OrderDto;
import org.humber.project.domain.Orders;
import org.humber.project.repositories.OrdersRepo;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
     @Autowired
    private OrdersRepo repo;

     @GetMapping({"", "/"})
    public String showOrdersList(Model model){
        List<Orders> orders = repo.findAll();
        model.addAttribute("orders", orders);
        return "orders/index";
    }

    @GetMapping("/order")
    public String showCreate(Model model){
         OrderDto orderDto = new OrderDto();
         model.addAttribute("orderDto", orderDto);
         return "orders/CreateOrder";
    }

    @PostMapping("/order")
    public String createOrder(@Valid @ModelAttribute OrderDto orderDto, BindingResult result){
         if (result.hasErrors()){
             return"orders/CreateOrder";
         }

        Orders orders = new Orders();
        orders.setName(orderDto.getName());
        orders.setPrice(orderDto.getPrice());
        repo.save(orders);

         return"redirect:/orders";
    }


    @GetMapping("/edit")
    public String edit(Model model, @RequestParam int id) {

            return "redirect:/orders";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam int id){
         try {
             Orders orders = repo.findById(id).get();
             repo.delete(orders);
         } catch(Exception ex){
             System.out.println("Exception" + ex.getMessage());
         }
         return "redirect:/orders";
    }

}

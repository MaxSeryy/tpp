package ua.cn.stu.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import ua.cn.stu.lab3.entity.Supplier;
import ua.cn.stu.lab3.service.FirmService;
import ua.cn.stu.lab3.service.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {

    private final SupplierService supplierService;
    private final FirmService firmService;

    public SupplierController(SupplierService supplierService, FirmService firmService) {
        this.supplierService = supplierService;
        this.firmService = firmService;
    }

    @GetMapping
    public String getSuppliers(Model model) {
        model.addAttribute("suppliers", supplierService.getAll());
        return "suppliers/suppliers";
    }

    @GetMapping("/{id}")
    public String getSupplier(@PathVariable Long id, Model model) {
        model.addAttribute("supplier", supplierService.getById(id));
        return "suppliers/supplier-detail";
    }

    @GetMapping("/new")
    public String newSupplierForm(Model model) {
        model.addAttribute("supplier", new Supplier());
        model.addAttribute("firms", firmService.getAll());
        return "suppliers/form";
    }

    @PostMapping
    public String createSupplier(@Valid @ModelAttribute Supplier supplier, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("firms", firmService.getAll());
            return "suppliers/form";
        }
        supplierService.create(supplier);
        return "redirect:/suppliers";
    }

    @GetMapping("/{id}/edit")
    public String editSupplierForm(@PathVariable Long id, Model model) {
        model.addAttribute("supplier", supplierService.getById(id));
        model.addAttribute("firms", firmService.getAll());
        return "suppliers/form";
    }

    @PostMapping("/{id}")
    public String updateSupplier(@PathVariable Long id, @Valid @ModelAttribute Supplier supplier, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("firms", firmService.getAll());
            return "suppliers/form";
        }
        supplierService.update(id, supplier);
        return "redirect:/suppliers/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteSupplier(@PathVariable Long id) {
        supplierService.delete(id);
        return "redirect:/suppliers";
    }
}
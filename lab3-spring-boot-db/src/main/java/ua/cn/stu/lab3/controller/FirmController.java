package ua.cn.stu.lab3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import ua.cn.stu.lab3.entity.Firm;
import ua.cn.stu.lab3.service.FirmService;

@Controller
@RequestMapping("/firms")
public class FirmController {
    
    private final FirmService firmService;

    public FirmController(FirmService firmService) {
        this.firmService = firmService;
    }

    @GetMapping
    public String getAllFirms(Model model) {
        model.addAttribute("firms", firmService.getAll());
        return "firms/firms";
    }

    @GetMapping("/{id}")
    public String getFirm(@PathVariable Long id, Model model) {
        model.addAttribute("firm", firmService.getById(id));
        return "firms/firm-detail";
    }

    @GetMapping("/new")
    public String newFirmForm(Model model) {
        model.addAttribute("firm", new Firm());
        return "firms/form";
    }

    @PostMapping
    public String createFirm(@Valid @ModelAttribute Firm firm, BindingResult result) {
        if (result.hasErrors()) {
            return "firms/form";
        }
        firmService.create(firm);
        return "redirect:/firms";
    }

    @GetMapping("/{id}/edit")
    public String editFirmForm(@PathVariable Long id, Model model) {
        model.addAttribute("firm", firmService.getById(id));
        return "firms/form";
    }

    @PostMapping("/{id}")
    public String updateFirm(@PathVariable Long id, @Valid @ModelAttribute Firm firm, BindingResult result) {
        if (result.hasErrors()) {
            return "firms/form";
        }
        firmService.update(id, firm);
        return "redirect:/firms/" + id;
    }

    @PostMapping("/{id}/delete")
    public String deleteFirm(@PathVariable Long id) {
        firmService.delete(id);
        return "redirect:/firms";
    }
}
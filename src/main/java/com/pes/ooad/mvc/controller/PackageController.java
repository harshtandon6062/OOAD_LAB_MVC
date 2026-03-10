package com.pes.ooad.mvc.controller;

import com.pes.ooad.mvc.model.PackageRecord;
import com.pes.ooad.mvc.service.PackageService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PackageController {

    private final PackageService packageService;

    public PackageController(PackageService packageService) {
        this.packageService = packageService;
    }

    @GetMapping("/")
    public String home(Model model) {
        if (!model.containsAttribute("packageForm")) {
            model.addAttribute("packageForm", new PackageRecord());
        }
        model.addAttribute("packages", packageService.getAllPackages());
        return "index";
    }

    @PostMapping("/save")
    public String savePackage(@Valid @ModelAttribute("packageForm") PackageRecord packageRecord,
                              BindingResult bindingResult,
                              RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.packageForm", bindingResult);
            redirectAttributes.addFlashAttribute("packageForm", packageRecord);
            redirectAttributes.addFlashAttribute("errorMessage", "Please correct the highlighted fields.");
            return "redirect:/";
        }

        try {
            packageService.savePackage(packageRecord);
            redirectAttributes.addFlashAttribute("successMessage", "Package saved successfully.");
        } catch (IllegalArgumentException ex) {
            redirectAttributes.addFlashAttribute("packageForm", packageRecord);
            redirectAttributes.addFlashAttribute("errorMessage", ex.getMessage());
        }

        return "redirect:/";
    }
}

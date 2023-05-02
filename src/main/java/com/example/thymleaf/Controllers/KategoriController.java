package com.example.thymleaf.Controllers;

import com.example.thymleaf.Models.Kategori;
import com.example.thymleaf.Repositories.KategoriRepo;
import com.example.thymleaf.Repositories.KundRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(path = "/kategori")
public class KategoriController {


    private final KategoriRepo kategoriRepo;
    private final KundRepo kundRepo;

    KategoriController(KategoriRepo kategoriRepo, KundRepo kundRepo){
        this.kategoriRepo=kategoriRepo;
        this.kundRepo=kundRepo;
    }


    @RequestMapping("/all")
    public String getAll(Model model) {
        List<Kategori> k = kategoriRepo.findAll();
        model.addAttribute("allCategories", k);
        //model.addAttribute("allCategories", new ArrayList<Kategori>());
        model.addAttribute("name", "Kategorinamn");
        model.addAttribute("categoryTitle", "Alla kategorier");
        return "showAllCategories";
    }



    //servar ett formulär för att skapa en ny kategori
    @RequestMapping("/addByForm")
    public String createByForm(Model model) {
        return "createCategory";
    }

    //Tar emot från ett formulär
    @PostMapping("/create")
    public String create(@RequestParam String name, Model model) {
        kategoriRepo.save(new Kategori(name));
        return getAll(model);
    }

    @RequestMapping("/allWithDelete")
    public String getAllWithDelete(Model model) {
        List<Kategori> k = kategoriRepo.findAll();
        model.addAttribute("allCategories", k);
        model.addAttribute("name", "Kategorinamn");
        model.addAttribute("categoryTitle", "Alla kategorier");
        return "deleteCategory";
    }

    @RequestMapping(path = "/deleteById/{id}")
    public String deleteCap(@PathVariable Long id, Model model) {
        kategoriRepo.deleteById(id);
        return getAllWithDelete(model);
    }


}
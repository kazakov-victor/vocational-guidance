package com.globallogic.guidance.controller;

import com.globallogic.guidance.entity.Root;
import com.globallogic.guidance.service.RootService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roots")
public class RootController {

    @Autowired
    RootService rootService;

    /**
     * @param root_number
     * @param child      0 - left child, 1 - right child
     * @return
     */
    @RequestMapping("/get-next/{root_number}/{child}")
    public Root getNextRoot(@PathVariable Long root_number, @PathVariable Integer child) {
        Long oldRootNumber = rootService.findByRootNumber(root_number).getRoot_number();
        Long childNumber = (child == 0) ? oldRootNumber * 2 : oldRootNumber * 2 + 1;
        return rootService.findByRootNumber(childNumber);
    }


    @GetMapping("/list")
    public List<Root> listRoot() {
        List<Root> roots = rootService.findAll();
        return roots;
    }

    @Transactional
    @RequestMapping("/save")
    public String saveRoot(@RequestParam(value = "number") Long number,
                           @RequestParam(value = "content") String content) {
        if(rootService.findByRootNumber(number) == null) {
            Root root = new Root(number, content);
            rootService.save(root);
            return "redirect:/roots/list";
        } else {
            return "We have such number already";
        }
    }

    @RequestMapping("/edit/{id}")
    public Root editRoot(@PathVariable Long id) {
        return rootService.findById(id);
    }

    @RequestMapping("/delete/{id}")
    public String deleteRoot(@PathVariable Long id) {
        rootService.deleteById(id);
        return "redirect:/roots/list";
    }

}






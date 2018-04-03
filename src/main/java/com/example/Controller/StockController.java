package com.example.Controller;

import com.example.Entity.Stock;
import com.example.Service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @RequestMapping("")
    public Iterable<Stock> getAllStock() {

        //return categoryService.getAllCategoryList();
        return stockService.findAll();
    }


    @RequestMapping("/{id}")
    public Optional<Stock> searchStock(@PathVariable int id) {
        //return categoryService.searchCategory(id);
        return stockService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "")
    public void addStock(@RequestBody Stock stock) {

        //categoryService.addCategory(category);
        stockService.insert(stock);
    }

    @RequestMapping(method = RequestMethod.PUT,value ="/{id}")
    public void updateStock(@RequestBody Stock stock, @PathVariable int stockId) {
        stockService.updateStock(stockId, stock);
    }

    @RequestMapping(method = RequestMethod.DELETE,value ="/{id}")
    public void deleteStock(int stockId) {
        stockService.deleteStock(stockId);
    }



}
package ra.controller;


import antlr.ASTNULLType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ra.model.entity.Catalog;
import ra.model.service.CatalogService;

import java.util.List;
@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("api/v1/catalog")
public class CatalogController {
    @Autowired
    private CatalogService catalogService;

    public CatalogController() {
    }

    @GetMapping
    public List<Catalog> getAllCatalog(){
        return catalogService.findAll();
    }
    @GetMapping("/{catalogId}")
    public Catalog getCatalogById(@PathVariable("catalogId") int catalogId){
        return catalogService.findById(catalogId);
    }
    @PostMapping
    public Catalog createCatalog(@RequestBody Catalog catalog){
        return catalogService.saveOrUpdate(catalog);
    }
    @PutMapping("/{catalogId}")
    public Catalog updateCatalog(@PathVariable("catalogId") int catalogId, @RequestBody Catalog catalog){
        Catalog catalogUpDate = catalogService.findById(catalogId);
        catalogUpDate.setCatalogName(catalog.getCatalogName());
        catalogUpDate.setDescription(catalog.getDescription());
        catalogUpDate.setStatus(catalogUpDate.isStatus());
        return catalogService.saveOrUpdate(catalogUpDate);
  }
  @DeleteMapping("/{catalogId}")
  public void deleteCatalog (@PathVariable("catalogId") int catalogId){
        catalogService.delete(catalogId);
  }
  @GetMapping("/search")
  public List<Catalog> searchbyNameOrId(@RequestParam("catalogName")String catalogName, @RequestParam("catalogId") int catalogId){
        return this.catalogService.searchByName(catalogName, catalogId);

  }
}
